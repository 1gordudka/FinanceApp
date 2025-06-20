package com.finance.brief.presentation.screens.create.di

import com.finance.brief.presentation.screens.create.CreateAccountScreenViewModel
import dagger.Subcomponent


@CreateAccountScreenComponentScope
@Subcomponent(
    modules = [CreateAccountScreenModule::class]
)
interface CreateAccountScreenComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): CreateAccountScreenComponent
    }

    val createAccountScreenViewModel: CreateAccountScreenViewModel
}