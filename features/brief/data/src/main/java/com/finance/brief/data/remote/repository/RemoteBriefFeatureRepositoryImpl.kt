package com.finance.brief.data.remote.repository

import android.util.Log
import com.finance.brief.data.remote.models.UpdateAccountRequest
import com.finance.brief.data.remote.results.ObtainRemoteAccountInfo
import com.finance.brief.data.remote.results.ObtainRemoteCreateAccountResult
import com.finance.brief.data.remote.results.ObtainRemoteUpdateAccountResult
import com.finance.brief.data.remote.service.BriefService
import kotlinx.coroutines.delay

class RemoteBriefFeatureRepositoryImpl(
    private val briefService: BriefService
) : RemoteBriefFeatureRepository {
    override suspend fun getAccountInfo(id: Int): ObtainRemoteAccountInfo {
        val maxRetries = 3
        val retryDelayMillis = 2000L

        repeat(maxRetries) { attempt ->
            try {
                val response = briefService.getAccountInfo(id)
                if (response.isSuccessful) {
                    return ObtainRemoteAccountInfo.Success(response.body()!!)
                } else {
                    if (response.code() == 500) {
                        if (attempt < maxRetries - 1) {
                            delay(retryDelayMillis)
                        }
                    } else {
                        return ObtainRemoteAccountInfo.Error
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
                return ObtainRemoteAccountInfo.Error
            }
        }
        return ObtainRemoteAccountInfo.Error
    }


    override suspend fun createAccount(createAccountRequest: com.finance.brief.domain.models.CreateAccountRequest): ObtainRemoteCreateAccountResult {
        val maxRetries = 3
        val retryDelayMillis = 2000L

        repeat(maxRetries) { attempt ->
            try {
                val response = briefService.createAccount(createAccountRequest)
                if (response.isSuccessful) {
                    return ObtainRemoteCreateAccountResult.Success(response.body()!!)
                } else {
                    if (response.code() == 500) {
                        if (attempt < maxRetries - 1) {
                            delay(retryDelayMillis)
                        }
                    } else {
                        return ObtainRemoteCreateAccountResult.Error
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
                return ObtainRemoteCreateAccountResult.Error
            }
        }
        return ObtainRemoteCreateAccountResult.Error
    }

    override suspend fun updateAccount(
        id: Int,
        updateAccountRequest: UpdateAccountRequest
    ): ObtainRemoteUpdateAccountResult {
        val maxRetries = 3
        val retryDelayMillis = 2000L

        repeat(maxRetries) { attempt ->
            try {
                val response = briefService.updateAccountInfo(id, updateAccountRequest)
                if (response.isSuccessful) {
                    return ObtainRemoteUpdateAccountResult.Success(response.body()!!)
                } else {
                    if (response.code() == 500) {
                        if (attempt < maxRetries - 1) {
                            delay(retryDelayMillis)
                        }
                    } else {
                        return ObtainRemoteUpdateAccountResult.Error
                    }
                }
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
                return ObtainRemoteUpdateAccountResult.Error
            }
        }
        return ObtainRemoteUpdateAccountResult.Error
    }

}