package com.finance.outcome.domain.use_cases

import com.finance.outcome.domain.repository.OutcomeFeatureRepository
import com.finance.outcome.domain.results.ObtainOutcomeData

class GetTodayOutcomeDataUseCase(
    private val outcomeFeatureRepository: OutcomeFeatureRepository
) {

    suspend operator fun invoke(startDate: String): ObtainOutcomeData {
        return outcomeFeatureRepository.getOutcomeData(startDate, startDate)
    }
}