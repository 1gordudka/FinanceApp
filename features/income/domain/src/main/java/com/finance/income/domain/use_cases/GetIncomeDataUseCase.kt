package com.finance.income.domain.use_cases

import com.finance.income.domain.repository.IncomeFeatureRepository

class GetIncomeDataUseCase(
    private val incomeFeatureRepository: IncomeFeatureRepository
) {

    suspend operator fun invoke(startDate: String, endDate: String) =
        incomeFeatureRepository.getIncomeData(startDate, endDate)
}