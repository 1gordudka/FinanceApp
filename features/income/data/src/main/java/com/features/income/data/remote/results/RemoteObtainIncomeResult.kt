package com.features.income.data.remote.results

import com.finance.domain.transaction.Transaction

sealed class RemoteObtainIncomeResult {

    data object Error: RemoteObtainIncomeResult()

    data class Success(
        val transactions: List<Transaction>,
    ): RemoteObtainIncomeResult()
} 