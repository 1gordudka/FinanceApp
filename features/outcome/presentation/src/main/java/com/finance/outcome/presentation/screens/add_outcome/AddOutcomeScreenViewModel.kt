package com.finance.outcome.presentation.screens.add_outcome

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.finance.common.ui.state_hoisting.StatefulViewModel
import com.finance.outcome.domain.models.CreateOutcomeRequest
import com.finance.outcome.domain.results.ObtainCreateOutcomeResult
import com.finance.outcome.domain.results.ObtainTransactionResult
import com.finance.outcome.domain.results.ObtainUpdateOutcomeResult
import com.finance.outcome.domain.use_cases.CreateOutcomeUseCase
import com.finance.outcome.domain.use_cases.GetTransactionByIdUseCase
import com.finance.outcome.domain.use_cases.UpdateOutcomeUseCase
import com.finance.outcome.presentation.screens.add_outcome.models.OutcomeScreenMode
import com.finance.outcome.presentation.screens.add_outcome.state_hoisting.AddOutcomeScreenAction
import com.finance.outcome.presentation.screens.add_outcome.state_hoisting.AddOutcomeScreenEffect
import com.finance.outcome.presentation.screens.add_outcome.state_hoisting.AddOutcomeScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class AddOutcomeScreenViewModel(
    private val createOutcomeUseCase: CreateOutcomeUseCase,
    private val updateOutcomeUseCase: UpdateOutcomeUseCase,
    private val getTransactionByIdUseCase: GetTransactionByIdUseCase,
    private val mode: OutcomeScreenMode
) : StatefulViewModel<AddOutcomeScreenState, AddOutcomeScreenEffect, AddOutcomeScreenAction>() {

    var amount = mutableStateOf("")
    var categoryId = mutableStateOf("")
    var comment = mutableStateOf("")
    var date = mutableStateOf(getTodayDate())
    var accountID = mutableStateOf("")
    
    private var lastCreateOutcomeRequest: CreateOutcomeRequest? = null
    private var currentTransactionId: Int? = null
    
    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, AddOutcomeScreenState.Loading
    )
    
    init {
        viewModelScope.launch {
            updateState(getInitialState())
        }
        initializeFields()
    }
    
    private fun getInitialState(): AddOutcomeScreenState {
        return when (mode) {
            is OutcomeScreenMode.Create -> AddOutcomeScreenState.Content(
                "", "", "", getTodayDate(), ""
            )
            is OutcomeScreenMode.Edit -> {
                val transaction = mode.transaction
                AddOutcomeScreenState.Content(
                    amount = transaction.amount,
                    categoryId = transaction.category.id.toString(),
                    comment = transaction.comment ?: "",
                    date = transaction.transactionDate,
                    accountId = transaction.account.id.toString()
                )
            }
            is OutcomeScreenMode.EditById -> {
                currentTransactionId = mode.transactionId
                AddOutcomeScreenState.Loading
            }
        }
    }
    
    private fun initializeFields() {
        when (mode) {
            is OutcomeScreenMode.Create -> {
                amount.value = ""
                categoryId.value = ""
                comment.value = ""
                date.value = getTodayDate()
                accountID.value = ""
            }
            is OutcomeScreenMode.Edit -> {
                val transaction = mode.transaction
                amount.value = transaction.amount
                categoryId.value = transaction.category.id.toString()
                comment.value = transaction.comment ?: ""
                date.value = transaction.transactionDate
                accountID.value = transaction.account.id.toString()
            }
            is OutcomeScreenMode.EditById -> {
                loadTransactionById(mode.transactionId)
            }
        }
    }

    override fun onAction(action: AddOutcomeScreenAction) {
        when (action) {
            is AddOutcomeScreenAction.OnAmountChange -> changeAmount(action.amount)
            is AddOutcomeScreenAction.OnCategoryIdChange -> changeCategoryId(action.categoryId)
            is AddOutcomeScreenAction.OnCommentChange -> changeComment(action.comment)
            is AddOutcomeScreenAction.OnDateChange -> changeDate(action.date)
            is AddOutcomeScreenAction.OnAccountIdChange -> changeAccountId(action.accountId)
            AddOutcomeScreenAction.OnBackButton -> {
                viewModelScope.launch {
                    updateEffect(AddOutcomeScreenEffect.NavigateBack)
                }
            }

            AddOutcomeScreenAction.OnCreateButton -> {
                val request = CreateOutcomeRequest(
                    amount = amount.value,
                    categoryId = categoryId.value.toIntOrNull() ?: 1, // default category
                    accountId = accountID.value.toIntOrNull() ?: 1, // default account
                    comment = comment.value.ifBlank { null },
                    transactionDate = date.value
                )
                lastCreateOutcomeRequest = request
                
                when (mode) {
                    is OutcomeScreenMode.Create -> createOutcome(request)
                    is OutcomeScreenMode.Edit -> updateOutcome(mode.transaction.id, request)
                    is OutcomeScreenMode.EditById -> currentTransactionId?.let { updateOutcome(it, request) }
                }
            }
            AddOutcomeScreenAction.OnRetryButton -> {
                lastCreateOutcomeRequest?.let { request ->
                    when (mode) {
                        is OutcomeScreenMode.Create -> createOutcome(request)
                        is OutcomeScreenMode.Edit -> updateOutcome(mode.transaction.id, request)
                        is OutcomeScreenMode.EditById -> currentTransactionId?.let { updateOutcome(it, request) }
                    }
                }
            }
        }
    }

    private fun loadTransactionById(transactionId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(AddOutcomeScreenState.Loading)
            val result = getTransactionByIdUseCase.invoke(transactionId)
            when (result) {
                ObtainTransactionResult.Error -> {
                    updateState(AddOutcomeScreenState.Error)
                }
                is ObtainTransactionResult.Success -> {
                    val transaction = result.transaction
                    amount.value = transaction.amount
                    categoryId.value = transaction.category.id.toString()
                    comment.value = transaction.comment ?: ""
                    date.value = transaction.transactionDate
                    accountID.value = transaction.account.id.toString()
                    
                    updateState(
                        AddOutcomeScreenState.Content(
                            amount = transaction.amount,
                            categoryId = transaction.category.id.toString(),
                            comment = transaction.comment ?: "",
                            date = transaction.transactionDate,
                            accountId = transaction.account.id.toString()
                        )
                    )
                }
            }
        }
    }

    private fun changeAmount(value: String) {
        viewModelScope.launch {
            amount.value = value
            updateContentState()
        }
    }

    private fun changeCategoryId(value: String) {
        viewModelScope.launch {
            categoryId.value = value
            updateContentState()
        }
    }

    private fun changeComment(value: String) {
        viewModelScope.launch {
            comment.value = value
            updateContentState()
        }
    }

    private fun changeDate(value: String) {
        viewModelScope.launch {
            date.value = value
            updateContentState()
        }
    }

    private fun changeAccountId(value: String) {
        viewModelScope.launch {
            accountID.value = value
            updateContentState()
        }
    }

    private suspend fun updateContentState() {
        updateState(
            AddOutcomeScreenState.Content(
                amount = amount.value,
                categoryId = categoryId.value,
                comment = comment.value,
                date = date.value,
                accountId = accountID.value
            )
        )
    }

    private fun createOutcome(request: CreateOutcomeRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(AddOutcomeScreenState.Loading)
            val result = createOutcomeUseCase.invoke(request)
            when (result) {
                ObtainCreateOutcomeResult.Error -> {
                    updateState(AddOutcomeScreenState.Error)
                }
                ObtainCreateOutcomeResult.Success -> {
                    updateEffect(AddOutcomeScreenEffect.NavigateBack)
                }
            }
        }
    }

    private fun updateOutcome(transactionId: Int, request: CreateOutcomeRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(AddOutcomeScreenState.Loading)
            val result = updateOutcomeUseCase.invoke(transactionId, request)
            when (result) {
                ObtainUpdateOutcomeResult.Error -> {
                    updateState(AddOutcomeScreenState.Error)
                }
                ObtainUpdateOutcomeResult.Success -> {
                    updateEffect(AddOutcomeScreenEffect.NavigateBack)
                }
            }
        }
    }
}

fun getTodayDate(): String {
    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    return today.format(formatter)
}

// Utility functions for date conversion (using common DateUtils)
private fun parseDisplayDateToIso(displayDate: String): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val date = LocalDate.parse(displayDate, formatter)
        "${date}T00:00:00.000Z"
    } catch (e: Exception) {
        displayDate
    }
} 