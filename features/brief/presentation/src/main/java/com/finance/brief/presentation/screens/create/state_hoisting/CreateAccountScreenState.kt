package com.finance.brief.presentation.screens.create.state_hoisting

sealed class CreateAccountScreenState {
    data object Error: CreateAccountScreenState()

    data object Loading: CreateAccountScreenState()

    data class Content(
        val name: String,
        val currency: String,
        val amount: String,
    ): CreateAccountScreenState()
}