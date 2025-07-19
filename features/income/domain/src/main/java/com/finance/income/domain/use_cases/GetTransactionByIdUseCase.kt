package com.finance.income.domain.use_cases

import com.finance.income.domain.repository.IncomeFeatureRepository
import com.finance.income.domain.results.ObtainTransactionResult

class GetTransactionByIdUseCase(
    private val incomeFeatureRepository: IncomeFeatureRepository
) {
    suspend operator fun invoke(transactionId: Int): ObtainTransactionResult =
        incomeFeatureRepository.getTransactionById(transactionId)
} 