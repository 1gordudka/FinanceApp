package com.finance.outcome.domain.use_cases

import com.finance.outcome.domain.repository.OutcomeFeatureRepository
import com.finance.outcome.domain.results.ObtainTransactionResult

class GetTransactionByIdUseCase(
    private val outcomeFeatureRepository: OutcomeFeatureRepository
) {
    suspend operator fun invoke(transactionId: Int): ObtainTransactionResult =
        outcomeFeatureRepository.getTransactionById(transactionId)
} 