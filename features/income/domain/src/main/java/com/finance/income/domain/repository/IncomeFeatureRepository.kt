package com.finance.income.domain.repository

import com.finance.income.domain.models.CreateIncomeRequest
import com.finance.income.domain.results.ObtainCreateIncomeResult
import com.finance.income.domain.results.ObtainIncomeData
import com.finance.income.domain.results.ObtainTransactionResult
import com.finance.income.domain.results.ObtainUpdateIncomeResult

interface IncomeFeatureRepository {

    suspend fun getIncomeData(
        startDate: String,
        endDate: String,
    ): ObtainIncomeData

    suspend fun createIncome(createIncomeRequest: CreateIncomeRequest): ObtainCreateIncomeResult
    
    suspend fun getTransactionById(transactionId: Int): ObtainTransactionResult
    
    suspend fun updateIncome(transactionId: Int, createIncomeRequest: CreateIncomeRequest): ObtainUpdateIncomeResult
} 