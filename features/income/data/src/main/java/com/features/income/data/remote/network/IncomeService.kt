package com.features.income.data.remote.network

import com.finance.domain.transaction.Transaction
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IncomeService {


    @GET("transactions/account/{id}/period?")
    suspend fun getTransactions(
        @Path("id") accountId: Int,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): Response<List<Transaction>>
} 