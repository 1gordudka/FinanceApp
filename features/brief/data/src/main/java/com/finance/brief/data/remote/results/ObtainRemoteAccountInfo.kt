package com.finance.brief.data.remote.results

import com.finance.brief.data.remote.models.Account

sealed class ObtainRemoteAccountInfo {

    data object Error: ObtainRemoteAccountInfo()

    data class Success(val info: Account,): ObtainRemoteAccountInfo()
}