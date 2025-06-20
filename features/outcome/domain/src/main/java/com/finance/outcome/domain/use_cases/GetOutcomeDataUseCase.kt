package com.finance.outcome.domain.use_cases

import com.finance.outcome.domain.repository.OutcomeFeatureRepository

class GetOutcomeDataUseCase(
    private val outcomeFeatureRepository: OutcomeFeatureRepository
) {

    suspend operator fun invoke(startDate: String, endDate: String) =
        outcomeFeatureRepository.getOutcomeData(startDate, endDate)
}