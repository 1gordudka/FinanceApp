package com.finance.common.network.network

import com.finance.common.network.models.AccountModel
import okhttp3.Response
import retrofit2.http.GET

interface AccountService {

    @GET("accounts")
    suspend fun getAccounts(): retrofit2.Response<List<AccountModel>>
}