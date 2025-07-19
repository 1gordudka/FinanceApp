package com.finance.income.presentation.screens.add_income

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.finance.common.ui.state_hoisting.StatefulViewModel
import com.finance.income.domain.models.CreateIncomeRequest
import com.finance.income.domain.results.ObtainCreateIncomeResult
import com.finance.income.domain.results.ObtainTransactionResult
import com.finance.income.domain.results.ObtainUpdateIncomeResult
import com.finance.income.domain.use_cases.CreateIncomeUseCase
import com.finance.income.domain.use_cases.GetTransactionByIdUseCase
import com.finance.income.domain.use_cases.UpdateIncomeUseCase
import com.finance.income.presentation.screens.add_income.models.IncomeScreenMode
import com.finance.income.presentation.screens.add_income.state_hoisting.AddIncomeScreenAction
import com.finance.income.presentation.screens.add_income.state_hoisting.AddIncomeScreenEffect
import com.finance.income.presentation.screens.add_income.state_hoisting.AddIncomeScreenState
import com.finance.income.presentation.screens.add_income.utils.DateUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AddIncomeScreenViewModel(
    private val createIncomeUseCase: CreateIncomeUseCase,
    private val updateIncomeUseCase: UpdateIncomeUseCase,
    private val getTransactionByIdUseCase: GetTransactionByIdUseCase,
    private val mode: IncomeScreenMode
) : StatefulViewModel<AddIncomeScreenState, AddIncomeScreenEffect, AddIncomeScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, getInitialState()
    )

    var amount = mutableStateOf("")
    var categoryId = mutableStateOf("")
    var comment = mutableStateOf("")
    var date = mutableStateOf(getTodayDate())
    var accountID = mutableStateOf("")
    
    private var lastCreateIncomeRequest: CreateIncomeRequest? = null
    private var currentTransactionId: Int? = null
    
    init {
        initializeFields()
    }
    
    private fun getInitialState(): AddIncomeScreenState {
        return when (mode) {
            is IncomeScreenMode.Create -> AddIncomeScreenState.Content(
                "", "", "", getTodayDate(), ""
            )
            is IncomeScreenMode.Edit -> {
                val transaction = mode.transaction
                AddIncomeScreenState.Content(
                    amount = transaction.amount,
                    categoryId = transaction.category.id.toString(),
                    comment = transaction.comment ?: "",
                    date = transaction.transactionDate,
                    accountId = transaction.account.id.toString()
                )
            }
            is IncomeScreenMode.EditById -> {
                currentTransactionId = mode.transactionId
                AddIncomeScreenState.Loading
            }
        }
    }
    
    private fun initializeFields() {
        when (mode) {
            is IncomeScreenMode.Create -> {
                amount.value = ""
                categoryId.value = ""
                comment.value = ""
                date.value = getTodayDate()
                accountID.value = ""
            }
            is IncomeScreenMode.Edit -> {
                val transaction = mode.transaction
                amount.value = transaction.amount
                categoryId.value = transaction.category.id.toString()
                comment.value = transaction.comment ?: ""
                date.value = transaction.transactionDate
                accountID.value = transaction.account.id.toString()
            }
            is IncomeScreenMode.EditById -> {
                loadTransactionById(mode.transactionId)
            }
        }
    }

    override fun onAction(action: AddIncomeScreenAction) {
        when (action) {
            is AddIncomeScreenAction.ChangeAmount -> changeAmount(action.amount)
            is AddIncomeScreenAction.ChangeCategoryId -> changeCategoryId(action.categoryId)
            is AddIncomeScreenAction.ChangeComment -> changeComment(action.comment)
            is AddIncomeScreenAction.ChangeDate -> changeDate(action.date)
            is AddIncomeScreenAction.ChangeAccountId -> changeAccountId(action.accountId)
            AddIncomeScreenAction.OnBackButton -> {
                viewModelScope.launch {
                    updateEffect(AddIncomeScreenEffect.NavigateBack)
                }
            }

            AddIncomeScreenAction.OnCreateButton -> {
                val request = CreateIncomeRequest(
                    amount = amount.value,
                    categoryId = categoryId.value.toIntOrNull() ?: 1, // default category
                    accountId = accountID.value.toIntOrNull() ?: 1, // default account
                    comment = comment.value.ifBlank { null },
                    transactionDate = date.value
                )
                lastCreateIncomeRequest = request
                
                when (mode) {
                    is IncomeScreenMode.Create -> createIncome(request)
                    is IncomeScreenMode.Edit -> updateIncome(mode.transaction.id, request)
                    is IncomeScreenMode.EditById -> currentTransactionId?.let { updateIncome(it, request) }
                }
            }
            AddIncomeScreenAction.OnRetryButton -> {
                lastCreateIncomeRequest?.let { request ->
                    when (mode) {
                        is IncomeScreenMode.Create -> createIncome(request)
                        is IncomeScreenMode.Edit -> updateIncome(mode.transaction.id, request)
                        is IncomeScreenMode.EditById -> currentTransactionId?.let { updateIncome(it, request) }
                    }
                }
            }
        }
    }

    private fun changeAccountId(accountId: String) {
        viewModelScope.launch {
            accountID.value = accountId
            updateContentState()
        }
    }

    private fun createIncome(createIncomeRequest: CreateIncomeRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(AddIncomeScreenState.Loading)
            val result = createIncomeUseCase.invoke(createIncomeRequest)
            when (result) {
                ObtainCreateIncomeResult.Error -> {
                    updateState(AddIncomeScreenState.Error)
                }

                ObtainCreateIncomeResult.Success -> {
                    updateEffect(AddIncomeScreenEffect.NavigateBack)
                }
            }
        }
    }

    private fun updateIncome(transactionId: Int, createIncomeRequest: CreateIncomeRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(AddIncomeScreenState.Loading)
            val result = updateIncomeUseCase.invoke(transactionId, createIncomeRequest)
            when (result) {
                ObtainUpdateIncomeResult.Error -> {
                    updateState(AddIncomeScreenState.Error)
                }

                ObtainUpdateIncomeResult.Success -> {
                    updateEffect(AddIncomeScreenEffect.NavigateBack)
                }
            }
        }
    }

    private fun loadTransactionById(transactionId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(AddIncomeScreenState.Loading)
            val result = getTransactionByIdUseCase.invoke(transactionId)
            when (result) {
                ObtainTransactionResult.Error -> {
                    updateState(AddIncomeScreenState.Error)
                }
                is ObtainTransactionResult.Success -> {
                    val transaction = result.transaction
                    amount.value = transaction.amount
                    categoryId.value = transaction.category.id.toString()
                    comment.value = transaction.comment ?: ""
                    date.value = transaction.transactionDate
                    accountID.value = transaction.account.id.toString()
                    
                    updateState(
                        AddIncomeScreenState.Content(
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

    private suspend fun updateContentState() {
        updateState(
            AddIncomeScreenState.Content(
                amount = amount.value,
                categoryId = categoryId.value,
                comment = comment.value,
                date = date.value,
                accountId = accountID.value
            )
        )
    }

    private fun getTodayDate(): String {
        return DateUtils.getCurrentDateISO()
    }
} 