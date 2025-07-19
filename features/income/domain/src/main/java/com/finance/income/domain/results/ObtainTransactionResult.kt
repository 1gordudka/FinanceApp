package com.finance.income.domain.results

import com.finance.domain.transaction.Transaction

sealed class ObtainTransactionResult {
    data object Error : ObtainTransactionResult()
    data class Success(val transaction: Transaction) : ObtainTransactionResult()
} 