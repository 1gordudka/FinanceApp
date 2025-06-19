package com.finance.brief.data.remote.results

import com.finance.brief.data.remote.models.CreateAccountResponse

sealed class ObtainRemoteCreateAccountResult {

    data object Error : ObtainRemoteCreateAccountResult()

    data class Success(val createAccountResponse: CreateAccountResponse) :
        ObtainRemoteCreateAccountResult()
}