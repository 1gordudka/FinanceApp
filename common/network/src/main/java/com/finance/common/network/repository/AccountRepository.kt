package com.finance.common.network.repository

import com.finance.common.network.results.ObtainAccountId

interface AccountRepository {

    suspend fun getAccountId(): ObtainAccountId
}