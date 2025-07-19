package com.finance.outcome.domain.use_cases

import com.finance.outcome.domain.models.CreateOutcomeRequest
import com.finance.outcome.domain.repository.OutcomeFeatureRepository
import com.finance.outcome.domain.results.ObtainCreateOutcomeResult

class CreateOutcomeUseCase(
    private val outcomeFeatureRepository: OutcomeFeatureRepository
) {
    suspend operator fun invoke(createOutcomeRequest: CreateOutcomeRequest): ObtainCreateOutcomeResult =
        outcomeFeatureRepository.createOutcome(createOutcomeRequest)
} 