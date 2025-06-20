package com.finance.brief.domain.results

import com.finance.brief.domain.models.Balance

sealed class ObtainAccountResult {

    data object Error: ObtainAccountResult()

    data class Success(val account: Balance,) : ObtainAccountResult()
}