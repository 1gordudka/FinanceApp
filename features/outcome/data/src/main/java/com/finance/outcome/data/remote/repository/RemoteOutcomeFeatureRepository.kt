package com.finance.outcome.data.remote.repository

import com.finance.outcome.data.remote.results.RemoteObtainOutcomeResult

interface RemoteOutcomeFeatureRepository {

    suspend fun getOutcomeData(
        accountId: Int,
        startDate: String,
        endDate: String
    ): RemoteObtainOutcomeResult
}