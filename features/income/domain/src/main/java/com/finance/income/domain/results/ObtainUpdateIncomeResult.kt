package com.finance.income.domain.results

sealed class ObtainUpdateIncomeResult {
    data object Error : ObtainUpdateIncomeResult()
    data object Success : ObtainUpdateIncomeResult()
} 