package com.finance.brief.data.remote.repository

import com.finance.brief.data.remote.models.UpdateAccountRequest
import com.finance.brief.data.remote.results.ObtainRemoteAccountInfo
import com.finance.brief.data.remote.results.ObtainRemoteCreateAccountResult
import com.finance.brief.data.remote.results.ObtainRemoteUpdateAccountResult

interface RemoteBriefFeatureRepository {

    suspend fun getAccountInfo(id: Int): ObtainRemoteAccountInfo

    suspend fun createAccount(createAccountRequest: com.finance.brief.domain.models.CreateAccountRequest): ObtainRemoteCreateAccountResult

    suspend fun updateAccount(id: Int, updateAccountRequest: UpdateAccountRequest): ObtainRemoteUpdateAccountResult
}