package com.finance.outcome.data.remote.repository

import com.finance.outcome.data.remote.results.RemoteObtainCreateOutcomeResult
import com.finance.outcome.data.remote.results.RemoteObtainOutcomeResult
import com.finance.outcome.data.remote.results.RemoteObtainTransactionResult
import com.finance.outcome.data.remote.results.RemoteObtainUpdateOutcomeResult
import com.finance.outcome.domain.models.CreateOutcomeRequest

interface RemoteOutcomeFeatureRepository {

    suspend fun getOutcomeData(
        accountId: Int,
        startDate: String,
        endDate: String
    ): RemoteObtainOutcomeResult

    suspend fun createOutcome(
        createOutcomeRequest: CreateOutcomeRequest
    ): RemoteObtainCreateOutcomeResult
    
    suspend fun getTransactionById(
        transactionId: Int
    ): RemoteObtainTransactionResult
    
    suspend fun updateOutcome(
        transactionId: Int,
        createOutcomeRequest: CreateOutcomeRequest
    ): RemoteObtainUpdateOutcomeResult
}