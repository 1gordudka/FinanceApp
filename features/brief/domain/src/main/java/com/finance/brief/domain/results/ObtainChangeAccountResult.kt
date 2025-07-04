package com.finance.brief.domain.results

import com.finance.brief.domain.models.Balance

sealed class ObtainChangeAccountResult {

    data class Success(val account: Balance) : ObtainChangeAccountResult()

    data object Error : ObtainChangeAccountResult()
}