package com.finance.brief.data.remote.mappers

import com.finance.brief.data.remote.models.Account
import com.finance.brief.domain.models.Balance

fun accountToUIMapper(account: Account): Balance =
    Balance(
        formattedAmount = account.balance,
        currency = account.currency
    )