package com.finance.brief.presentation.screens.create.state_hoisting

sealed class CreateAccountScreenAction {

    data object OnBackButton: CreateAccountScreenAction()

    data object OnCreateButton: CreateAccountScreenAction()

    data class ChangeName(val name: String): CreateAccountScreenAction()
    data class ChangeAmount(val amount: String,): CreateAccountScreenAction()
    data class ChangeCurrency(val currency: String,): CreateAccountScreenAction()
}