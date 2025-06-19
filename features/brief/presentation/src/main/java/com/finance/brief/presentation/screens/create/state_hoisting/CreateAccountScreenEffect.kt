package com.finance.brief.presentation.screens.create.state_hoisting

sealed class CreateAccountScreenEffect {

    data object NavigateBack: CreateAccountScreenEffect()
}