package com.features.income.data.remote.repository

import com.features.income.data.remote.results.RemoteObtainCreateIncomeResult
import com.features.income.data.remote.results.RemoteObtainIncomeResult
import com.features.income.data.remote.results.RemoteObtainTransactionResult
import com.features.income.data.remote.results.RemoteObtainUpdateIncomeResult
import com.finance.income.domain.models.CreateIncomeRequest

interface RemoteIncomeFeatureRepository {

    suspend fun getIncomeData(
        accountId: Int,
        startDate: String,
        endDate: String
    ): RemoteObtainIncomeResult

    suspend fun createIncome(
        createIncomeRequest: CreateIncomeRequest
    ): RemoteObtainCreateIncomeResult
    
    suspend fun getTransactionById(
        transactionId: Int
    ): RemoteObtainTransactionResult
    
    suspend fun updateIncome(
        transactionId: Int,
        createIncomeRequest: CreateIncomeRequest
    ): RemoteObtainUpdateIncomeResult
} 