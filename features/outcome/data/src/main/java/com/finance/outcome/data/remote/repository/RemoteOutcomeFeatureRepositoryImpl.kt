package com.finance.outcome.data.remote.repository

import android.util.Log
import com.finance.outcome.data.remote.network.OutcomeService
import com.finance.outcome.data.remote.results.RemoteObtainOutcomeResult
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
}