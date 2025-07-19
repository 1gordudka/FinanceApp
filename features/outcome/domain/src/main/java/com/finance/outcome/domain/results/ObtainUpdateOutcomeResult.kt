package com.finance.outcome.domain.results

sealed class ObtainUpdateOutcomeResult {
    data object Error : ObtainUpdateOutcomeResult()
    data object Success : ObtainUpdateOutcomeResult()
} 