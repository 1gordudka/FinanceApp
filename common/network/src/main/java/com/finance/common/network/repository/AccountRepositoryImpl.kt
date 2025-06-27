package com.finance.common.network.repository

import android.util.Log
import com.finance.common.network.network.AccountService
import com.finance.common.network.results.ObtainAccountId

class AccountRepositoryImpl(
    private val accountService: AccountService
) : AccountRepository {

    private var accountId: Int? = null


    override suspend fun getAccountId(): ObtainAccountId {
        if (accountId != null) {
            return ObtainAccountId.Success(accountId!!)
        } else {
            try {
                val response = accountService.getAccounts()
                if (response.isSuccessful) {
                    accountId = response.body()!!.get(0).id
                    return ObtainAccountId.Success(accountId!!)
                } else {
                    return ObtainAccountId.Error
                }
            } catch (e: Exception) {
                Log.d("ERROR", e.message.toString())
                return ObtainAccountId.Error
            }
        }
    }
}