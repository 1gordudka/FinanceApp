package com.finance.outcome.domain.use_cases

import com.finance.outcome.domain.models.CreateOutcomeRequest
import com.finance.outcome.domain.repository.OutcomeFeatureRepository
import com.finance.outcome.domain.results.ObtainUpdateOutcomeResult

class UpdateOutcomeUseCase(
    private val outcomeFeatureRepository: OutcomeFeatureRepository
) {
    suspend operator fun invoke(transactionId: Int, createOutcomeRequest: CreateOutcomeRequest): ObtainUpdateOutcomeResult =
        outcomeFeatureRepository.updateOutcome(transactionId, createOutcomeRequest)
} 