package com.finance.brief.data.remote.service

import com.finance.brief.data.remote.models.Account
import com.finance.brief.data.remote.models.CreateAccountRequest
import com.finance.brief.data.remote.models.CreateAccountResponse
import com.finance.brief.domain.use_cases.CreateAccountRequestUseCase
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BriefService {

    @GET("accounts/{id}")
    suspend fun getAccountInfo(
        @Path("id") id: Int,
    ): retrofit2.Response<Account>

    @POST("accounts")
    suspend fun createAccount(
        @Body request: com.finance.brief.domain.models.CreateAccountRequest
    ): retrofit2.Response<CreateAccountResponse>
}