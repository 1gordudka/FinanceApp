package com.finance.income.domain.use_cases

import com.finance.income.domain.models.CreateIncomeRequest
import com.finance.income.domain.repository.IncomeFeatureRepository
import com.finance.income.domain.results.ObtainUpdateIncomeResult

class UpdateIncomeUseCase(
    private val incomeFeatureRepository: IncomeFeatureRepository
) {
    suspend operator fun invoke(transactionId: Int, createIncomeRequest: CreateIncomeRequest): ObtainUpdateIncomeResult =
        incomeFeatureRepository.updateIncome(transactionId, createIncomeRequest)
} 