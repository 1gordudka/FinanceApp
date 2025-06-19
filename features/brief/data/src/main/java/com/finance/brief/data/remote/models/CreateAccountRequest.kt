package com.finance.brief.data.remote.models

data class CreateAccountRequest(
    val name: String,
    val balance: String,
    val currency: String,
)