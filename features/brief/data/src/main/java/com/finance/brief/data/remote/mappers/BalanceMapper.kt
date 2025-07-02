package com.finance.brief.data.remote.mappers

import com.finance.brief.data.remote.models.Account
import com.finance.brief.data.remote.models.CreateAccountResponse
import com.finance.brief.domain.models.Balance
import com.finance.common.network.models.AccountModel

fun AccountModel.toDomain(): Balance =
    Balance(
        formattedAmount = this.balance,
        currency = this.currency,
        name = this.name
    )

fun Account.toDomain(): Balance =
    Balance(
        formattedAmount = this.balance,
        currency = this.currency,
        name = this.name
    )

fun CreateAccountResponse.toDomain(): Balance =
    Balance(
        formattedAmount = this.balance,
        currency = this.currency,
        name = this.name
    )