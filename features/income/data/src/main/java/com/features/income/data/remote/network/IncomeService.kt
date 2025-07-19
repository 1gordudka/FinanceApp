package com.features.income.data.remote.network

import com.features.income.data.remote.models.CreateIncomeResponse
import com.finance.domain.transaction.Transaction
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface IncomeService {

    @GET("transactions/account/{id}/period?")
    suspend fun getTransactions(
        @Path("id") accountId: Int,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): Response<List<Transaction>>

    @POST("transactions")
    suspend fun createIncome(
        @Body request: com.finance.income.domain.models.CreateIncomeRequest
    ): Response<CreateIncomeResponse>

    @GET("transactions/{id}")
    suspend fun getTransactionById(
        @Path("id") transactionId: Int
    ): Response<Transaction>

    @PUT("transactions/{id}")
    suspend fun updateIncome(
        @Path("id") transactionId: Int,
        @Body request: com.finance.income.domain.models.CreateIncomeRequest
    ): Response<CreateIncomeResponse>
} 