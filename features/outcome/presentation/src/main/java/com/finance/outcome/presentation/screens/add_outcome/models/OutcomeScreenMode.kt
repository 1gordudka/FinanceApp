package com.finance.outcome.presentation.screens.add_outcome.models

import com.finance.domain.transaction.Transaction

sealed class OutcomeScreenMode {
    data object Create : OutcomeScreenMode()
    data class Edit(val transaction: Transaction) : OutcomeScreenMode()
    data class EditById(val transactionId: Int) : OutcomeScreenMode()
}