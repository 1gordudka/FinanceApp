package com.finance.brief.domain.repository

import com.finance.brief.domain.models.CreateAccountRequest
import com.finance.brief.domain.results.ObtainAccountResult
import com.finance.brief.domain.results.ObtainChangeAccountResult
import com.finance.brief.domain.results.ObtainCreateAccountResult

interface BriefFeatureRepository {

    suspend fun getAccount(): ObtainAccountResult

    suspend fun createAccount(createAccountRequest: CreateAccountRequest): ObtainCreateAccountResult

    suspend fun updateAccount(
        name: String,
        balance: String,
        currency: String
    ): ObtainChangeAccountResult
}