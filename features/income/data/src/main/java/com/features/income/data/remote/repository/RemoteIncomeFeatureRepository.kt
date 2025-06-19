package com.features.income.data.remote.repository

import com.features.income.data.remote.results.RemoteObtainIncomeResult

interface RemoteIncomeFeatureRepository {

    suspend fun getIncomeData(
        accountId: Int,
        startDate: String,
        endDate: String
    ): RemoteObtainIncomeResult
} 