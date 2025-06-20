package com.finance.brief.data.remote.repository

import com.finance.brief.data.remote.models.CreateAccountRequest
import com.finance.brief.data.remote.results.ObtainRemoteAccountInfo
import com.finance.brief.data.remote.results.ObtainRemoteCreateAccountResult

interface RemoteBriefFeatureRepository {

    suspend fun getAccountInfo(id: Int): ObtainRemoteAccountInfo

    suspend fun createAccount(createAccountRequest: com.finance.brief.domain.models.CreateAccountRequest): ObtainRemoteCreateAccountResult
}