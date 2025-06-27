package com.features.income.data.remote.repository

import android.util.Log
import com.features.income.data.remote.network.IncomeService
import com.features.income.data.remote.results.RemoteObtainIncomeResult
import kotlinx.coroutines.delay

class RemoteOutcomeFeatureRepositoryImpl(
    private val outcomeService: IncomeService
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
                val response = outcomeService.getTransactions(accountId, startDate, endDate)
                if (response.isSuccessful) {
                    return RemoteObtainIncomeResult.Success(response.body()!!.filter { it.category.isIncome })
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
}