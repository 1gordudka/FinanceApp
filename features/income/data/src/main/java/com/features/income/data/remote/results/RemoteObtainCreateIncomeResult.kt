package com.features.income.data.remote.results

import com.features.income.data.remote.models.CreateIncomeResponse

sealed class RemoteObtainCreateIncomeResult {
    data object Error : RemoteObtainCreateIncomeResult()
    data class Success(val response: CreateIncomeResponse) : RemoteObtainCreateIncomeResult()
} 