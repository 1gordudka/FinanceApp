package com.finance.brief.data.remote.models

data class UpdateAccountRequest(
    val name: String,
    val balance: String,
    val currency: String,
)