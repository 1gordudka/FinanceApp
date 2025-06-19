package com.finance.brief.data.remote.service

import com.finance.brief.data.remote.models.Account
import retrofit2.http.GET
import retrofit2.http.Path

interface BriefService {

    @GET("accounts/{id}")
    suspend fun getAccountInfo(
        @Path("id") id: Int,
    ): retrofit2.Response<Account>
}