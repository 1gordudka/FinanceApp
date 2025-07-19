package com.finance.outcome.domain.results

sealed class ObtainCreateOutcomeResult {
    data object Error : ObtainCreateOutcomeResult()
    data object Success : ObtainCreateOutcomeResult()
} 