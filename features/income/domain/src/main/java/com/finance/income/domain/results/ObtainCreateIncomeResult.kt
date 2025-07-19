package com.finance.income.domain.results

sealed class ObtainCreateIncomeResult {
    data object Error : ObtainCreateIncomeResult()
    data object Success : ObtainCreateIncomeResult()
} 