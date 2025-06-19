package com.finance.outcome.data.remote.results

import com.finance.domain.transaction.Transaction

sealed class RemoteObtainOutcomeResult {

    data object Error: RemoteObtainOutcomeResult()

    data class Success(
        val transactions: List<Transaction>,
    ): RemoteObtainOutcomeResult()
}