package com.finance.brief.domain.repository

import com.finance.brief.domain.models.CreateAccountRequest
import com.finance.brief.domain.results.ObtainAccountResult
import com.finance.brief.domain.results.ObtainCreateAccountResult

interface BriefFeatureRepository {

    suspend fun getAccount(): ObtainAccountResult

    suspend fun createAccount(createAccountRequest: CreateAccountRequest): ObtainCreateAccountResult
}