package com.finance.income.domain.repository

import com.finance.income.domain.results.ObtainIncomeData

interface IncomeFeatureRepository {


    suspend fun getIncomeData(
        startDate: String,
        endDate: String,
    ): ObtainIncomeData
} 