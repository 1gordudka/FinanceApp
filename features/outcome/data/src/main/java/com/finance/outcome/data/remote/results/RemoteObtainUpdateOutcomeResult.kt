package com.finance.outcome.data.remote.results

import com.finance.outcome.data.remote.models.CreateOutcomeResponse

sealed class RemoteObtainUpdateOutcomeResult {
    data object Error : RemoteObtainUpdateOutcomeResult()
    data class Success(val response: CreateOutcomeResponse) : RemoteObtainUpdateOutcomeResult()
} 