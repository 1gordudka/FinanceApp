package com.finance.income.domain.use_cases

import com.finance.income.domain.repository.IncomeFeatureRepository
import com.finance.income.domain.results.ObtainIncomeData

class GetTodayIncomeUseCase(
    private val incomeFeatureRepository: IncomeFeatureRepository
) {

    suspend operator fun invoke(startDate: String): ObtainIncomeData{
        return incomeFeatureRepository.getIncomeData(startDate, startDate)
    }
}