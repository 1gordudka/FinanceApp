package com.finance.brief.domain.models

data class CreateAccountRequest(
    val name: String,
    val balance: String,
    val currency: String,
)