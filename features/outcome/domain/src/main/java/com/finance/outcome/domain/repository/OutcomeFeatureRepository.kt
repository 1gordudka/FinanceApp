package com.finance.outcome.domain.repository

import com.finance.outcome.domain.models.CreateOutcomeRequest
import com.finance.outcome.domain.results.ObtainCreateOutcomeResult
import com.finance.outcome.domain.results.ObtainOutcomeData
import com.finance.outcome.domain.results.ObtainTransactionResult
import com.finance.outcome.domain.results.ObtainUpdateOutcomeResult

interface OutcomeFeatureRepository {

    suspend fun getOutcomeData(
        startDate: String,
        endDate: String,
    ): ObtainOutcomeData
    
    suspend fun createOutcome(createOutcomeRequest: CreateOutcomeRequest): ObtainCreateOutcomeResult
    
    suspend fun getTransactionById(transactionId: Int): ObtainTransactionResult
    
    suspend fun updateOutcome(transactionId: Int, createOutcomeRequest: CreateOutcomeRequest): ObtainUpdateOutcomeResult
}