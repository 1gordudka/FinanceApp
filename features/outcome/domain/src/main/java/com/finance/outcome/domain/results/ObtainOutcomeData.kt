package com.finance.outcome.domain.results

import com.finance.outcome.domain.models.AllOutcome
import com.finance.outcome.domain.models.OutcomeCategory

sealed class ObtainOutcomeData {

    data object Error: ObtainOutcomeData()

    data class Success(
        val startDate: String,
        val endDate: String,
        val allOutcome: AllOutcome,
        val categories: List<OutcomeCategory>,
    ): ObtainOutcomeData()
}