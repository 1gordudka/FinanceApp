package com.features.income.data.remote.results

import com.finance.domain.transaction.Transaction

sealed class RemoteObtainTransactionResult {
    data object Error : RemoteObtainTransactionResult()
    data class Success(val transaction: Transaction) : RemoteObtainTransactionResult()
} 