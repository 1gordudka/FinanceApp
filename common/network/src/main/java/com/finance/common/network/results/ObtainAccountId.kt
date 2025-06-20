package com.finance.common.network.results

sealed class ObtainAccountId{

    data object Error: ObtainAccountId()

    data class Success(val id: Int,) : ObtainAccountId()
}