package com.finance.outcome.data.remote.network

import com.finance.domain.transaction.Transaction
import com.finance.outcome.data.remote.models.CreateOutcomeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface OutcomeService {

    @GET("transactions/account/{id}/period?")
    suspend fun getTransactions(
        @Path("id") accountId: Int,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): Response<List<Transaction>>

    @POST("transactions")
    suspend fun createOutcome(
        @Body request: com.finance.outcome.domain.models.CreateOutcomeRequest
    ): Response<CreateOutcomeResponse>

    @GET("transactions/{id}")
    suspend fun getTransactionById(
        @Path("id") transactionId: Int
    ): Response<Transaction>

    @PUT("transactions/{id}")
    suspend fun updateOutcome(
        @Path("id") transactionId: Int,
        @Body request: com.finance.outcome.domain.models.CreateOutcomeRequest
    ): Response<CreateOutcomeResponse>
}