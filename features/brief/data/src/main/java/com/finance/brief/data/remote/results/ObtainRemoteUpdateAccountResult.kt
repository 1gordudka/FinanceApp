package com.finance.brief.data.remote.results

import com.finance.brief.data.remote.models.CreateAccountResponse

sealed class ObtainRemoteUpdateAccountResult {

    data object Error: ObtainRemoteUpdateAccountResult()

    data class Success(val updateAccountResponse: CreateAccountResponse):
        ObtainRemoteUpdateAccountResult()
}