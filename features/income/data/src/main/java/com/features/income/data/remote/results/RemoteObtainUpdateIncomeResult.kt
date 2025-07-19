package com.features.income.data.remote.results

import com.features.income.data.remote.models.CreateIncomeResponse

sealed class RemoteObtainUpdateIncomeResult {
    data object Error : RemoteObtainUpdateIncomeResult()
    data class Success(val response: CreateIncomeResponse) : RemoteObtainUpdateIncomeResult()
} 