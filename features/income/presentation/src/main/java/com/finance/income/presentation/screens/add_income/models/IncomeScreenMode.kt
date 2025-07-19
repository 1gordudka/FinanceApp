package com.finance.income.presentation.screens.add_income.models

import com.finance.domain.transaction.Transaction

sealed class IncomeScreenMode {
    data object Create : IncomeScreenMode()
    data class Edit(val transaction: Transaction) : IncomeScreenMode()
    data class EditById(val transactionId: Int) : IncomeScreenMode()
} 