package com.finance.outcome.domain.results

import com.finance.domain.transaction.Transaction
import com.finance.outcome.domain.models.AllOutcome

sealed class ObtainOutcomeData {

    data object Error: ObtainOutcomeData()

    data class Success(
        val startDate: String,
        val endDate: String,
        val allOutcome: AllOutcome,
        val transactions: List<Transaction>,
    ): ObtainOutcomeData()
}