package com.finance.income.domain.use_cases

import com.finance.income.domain.models.CreateIncomeRequest
import com.finance.income.domain.repository.IncomeFeatureRepository
import com.finance.income.domain.results.ObtainCreateIncomeResult

class CreateIncomeUseCase(
    private val incomeFeatureRepository: IncomeFeatureRepository
) {
    suspend operator fun invoke(createIncomeRequest: CreateIncomeRequest): ObtainCreateIncomeResult =
        incomeFeatureRepository.createIncome(createIncomeRequest)
} 