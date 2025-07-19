package com.finance.outcome.data.remote.repository

import android.util.Log
import com.finance.outcome.data.remote.network.OutcomeService
import com.finance.outcome.data.remote.results.RemoteObtainCreateOutcomeResult
import com.finance.outcome.data.remote.results.RemoteObtainOutcomeResult
import com.finance.outcome.data.remote.results.RemoteObtainTransactionResult
import com.finance.outcome.data.remote.results.RemoteObtainUpdateOutcomeResult
import com.finance.outcome.domain.models.CreateOutcomeRequest
import kotlinx.coroutines.delay

class RemoteOutcomeFeatureRepositoryImpl(
    private val outcomeService: OutcomeService
) : RemoteOutcomeFeatureRepository {
    override suspend fun getOutcomeData(
        accountId: Int,
        startDate: String,
        endDate: String
    ): RemoteObtainOutcomeResult {
        val maxRetries = 3
        val retryDelayMillis = 2000L
        repeat(maxRetries) { attempt ->
            try {
                val response = outcomeService.getTransactions(accountId, startDate, endDate)
                if (response.isSuccessful) {
                    return RemoteObtainOutcomeResult.Success(response.body()!!.filter { !it.category.isIncome }.sortedBy { it.createdAt })
                } else {
                    if (response.code() == 500) {
                        if (attempt < maxRetries - 1) {
                            delay(retryDelayMillis)
                        }
                    } else {
                        return RemoteObtainOutcomeResult.Error
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
                return RemoteObtainOutcomeResult.Error
            }
        }
        return RemoteObtainOutcomeResult.Error
    }

    override suspend fun createOutcome(
        createOutcomeRequest: CreateOutcomeRequest
    ): RemoteObtainCreateOutcomeResult {
        val maxRetries = 3
        val retryDelayMillis = 2000L

        repeat(maxRetries) { attempt ->
            try {
                val response = outcomeService.createOutcome(createOutcomeRequest)
                if (response.isSuccessful) {
                    return RemoteObtainCreateOutcomeResult.Success(response.body()!!)
                } else {
                    if (response.code() == 500) {
                        if (attempt < maxRetries - 1) {
                            delay(retryDelayMillis)
                        }
                    } else {
                        return RemoteObtainCreateOutcomeResult.Error
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
                return RemoteObtainCreateOutcomeResult.Error
            }
        }
        return RemoteObtainCreateOutcomeResult.Error
    }

    override suspend fun getTransactionById(transactionId: Int): RemoteObtainTransactionResult {
        val maxRetries = 3
        val retryDelayMillis = 2000L

        repeat(maxRetries) { attempt ->
            try {
                val response = outcomeService.getTransactionById(transactionId)
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

    override suspend fun updateOutcome(
        transactionId: Int,
        createOutcomeRequest: CreateOutcomeRequest
    ): RemoteObtainUpdateOutcomeResult {
        val maxRetries = 3
        val retryDelayMillis = 2000L

        repeat(maxRetries) { attempt ->
            try {
                val response = outcomeService.updateOutcome(transactionId, createOutcomeRequest)
                if (response.isSuccessful) {
                    return RemoteObtainUpdateOutcomeResult.Success(response.body()!!)
                } else {
                    if (response.code() == 500) {
                        if (attempt < maxRetries - 1) {
                            delay(retryDelayMillis)
                        }
                    } else {
                        return RemoteObtainUpdateOutcomeResult.Error
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
                return RemoteObtainUpdateOutcomeResult.Error
            }
        }
        return RemoteObtainUpdateOutcomeResult.Error
    }
}