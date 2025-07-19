package com.finance.outcome.data.remote.results

import com.finance.outcome.data.remote.models.CreateOutcomeResponse

sealed class RemoteObtainCreateOutcomeResult {
    data object Error : RemoteObtainCreateOutcomeResult()
    data class Success(val response: CreateOutcomeResponse) : RemoteObtainCreateOutcomeResult()
} 