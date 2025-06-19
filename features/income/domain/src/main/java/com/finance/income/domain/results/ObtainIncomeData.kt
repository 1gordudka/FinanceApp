package com.finance.income.domain.results

import com.finance.domain.transaction.Transaction
import com.finance.income.domain.models.AllIncome
import com.finance.income.domain.models.IncomeTransaction

sealed class ObtainIncomeData {
    data object Error : ObtainIncomeData()

    data class Success(
        val startDate: String,
        val endDate: String,
        val allIncome: AllIncome,
        val transactions: List<Transaction>,
    ) : ObtainIncomeData()
} 