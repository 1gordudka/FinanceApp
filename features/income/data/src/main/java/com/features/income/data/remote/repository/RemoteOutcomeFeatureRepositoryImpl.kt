package com.features.income.data.remote.repository

import android.util.Log
import com.features.income.data.remote.network.IncomeService
import com.features.income.data.remote.results.RemoteObtainCreateIncomeResult
import com.features.income.data.remote.results.RemoteObtainIncomeResult
import com.features.income.data.remote.results.RemoteObtainTransactionResult
import com.features.income.data.remote.results.RemoteObtainUpdateIncomeResult
import com.finance.income.domain.models.CreateIncomeRequest
import kotlinx.coroutines.delay

class RemoteOutcomeFeatureRepositoryImpl(
    private val incomeService: IncomeService
) : RemoteIncomeFeatureRepository {
    override suspend fun getIncomeData(
        accountId: Int,
        startDate: String,
        endDate: String
    ): RemoteObtainIncomeResult {
        val maxRetries = 3
        val retryDelayMillis = 2000L

        repeat(maxRetries) { attempt ->
            try {
                val response = incomeService.getTransactions(accountId, startDate, endDate)
                if (response.isSuccessful) {
                    return RemoteObtainIncomeResult.Success(
                        response.body()!!.filter { it.category.isIncome })
                } else {
                    if (response.code() == 500) {
                        if (attempt < maxRetries - 1) {
                            delay(retryDelayMillis)
                        }
                    } else {
                        return RemoteObtainIncomeResult.Error
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
                return RemoteObtainIncomeResult.Error
            }
        }
        return RemoteObtainIncomeResult.Error
    }

    override suspend fun createIncome(
        createIncomeRequest: CreateIncomeRequest
    ): RemoteObtainCreateIncomeResult {
        val maxRetries = 3
        val retryDelayMillis = 2000L

        repeat(maxRetries) { attempt ->
            try {
                val response = incomeService.createIncome(createIncomeRequest)
                if (response.isSuccessful) {
                    return RemoteObtainCreateIncomeResult.Success(response.body()!!)
                } else {
                    if (response.code() == 500) {
                        if (attempt < maxRetries - 1) {
                            delay(retryDelayMillis)
                        }
                    } else {
                        return RemoteObtainCreateIncomeResult.Error
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
                return RemoteObtainCreateIncomeResult.Error
            }
        }
        return RemoteObtainCreateIncomeResult.Error
    }

    override suspend fun getTransactionById(transactionId: Int): RemoteObtainTransactionResult {
        val maxRetries = 3
        val retryDelayMillis = 2000L

        repeat(maxRetries) { attempt ->
            try {
                val response = incomeService.getTransactionById(transactionId)
                if (response.isSuccessful) {
                    return RemoteObtainTransactionResult.Success(response.body()!!)
                } else {
                    if (response.code() == 500) {
                        if (attempt < maxRetries - 1) {
                            delay(retryDelayMillis)
                        }
                    } else {
                        return RemoteObtainTransactionResult.Error
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
                return RemoteObtainTransactionResult.Error
            }
        }
        return RemoteObtainTransactionResult.Error
    }

    override suspend fun updateIncome(
        transactionId: Int,
        createIncomeRequest: CreateIncomeRequest
    ): RemoteObtainUpdateIncomeResult {
        val maxRetries = 3
        val retryDelayMillis = 2000L

        repeat(maxRetries) { attempt ->
            try {
                val response = incomeService.updateIncome(transactionId, createIncomeRequest)
                if (response.isSuccessful) {
                    return RemoteObtainUpdateIncomeResult.Success(response.body()!!)
                } else {
                    if (response.code() == 500) {
                        if (attempt < maxRetries - 1) {
                            delay(retryDelayMillis)
                        }
                    } else {
                        return RemoteObtainUpdateIncomeResult.Error
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
                return RemoteObtainUpdateIncomeResult.Error
            }
        }
        return RemoteObtainUpdateIncomeResult.Error
    }
}