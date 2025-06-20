package com.finance.brief.domain.results

sealed class ObtainCreateAccountResult {

    data object Error: ObtainCreateAccountResult()

    data object Success: ObtainCreateAccountResult()
}