package com.finance.brief.data.remote.mappers

import com.finance.brief.data.remote.models.Account
import com.finance.brief.domain.models.Balance
import com.finance.common.network.models.AccountModel

fun AccountModel.toDomain(): Balance =
    Balance(
        formattedAmount = this.balance,
        currency = this.currency
    )

fun Account.toDomain(): Balance =
    Balance(
        formattedAmount = this.balance,
        currency = this.currency
    )