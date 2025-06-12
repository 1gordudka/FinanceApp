package com.finance.outcome.presentation.screens.main.state_hoisting

import com.finance.outcome.domain.models.AllOutcome
import com.finance.outcome.domain.models.OutcomeCategory

sealed class OutcomeMainScreenState {

    data class Content(
        val allOutcome: AllOutcome,
        val categories: List<OutcomeCategory.OutcomeCategoryLead>
    ) : OutcomeMainScreenState()

    data object Loading : OutcomeMainScreenState()

    data object Empty : OutcomeMainScreenState()

    data object Error : OutcomeMainScreenState()
}
