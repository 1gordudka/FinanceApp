package com.finance.outcome.domain.repository

import com.finance.outcome.domain.results.ObtainOutcomeData

interface OutcomeFeatureRepository {

    suspend fun getOutcomeData(
        startDate: String,
        endDate: String,
    ): ObtainOutcomeData
}