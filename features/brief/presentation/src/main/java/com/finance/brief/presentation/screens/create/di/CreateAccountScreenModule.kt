package com.finance.brief.presentation.screens.create.di

import com.finance.brief.domain.use_cases.CreateAccountRequestUseCase
import com.finance.brief.presentation.screens.create.CreateAccountScreenViewModel
import dagger.Module
import dagger.Provides

@Module(
    includes = [UseCasesModule::class]
)
class CreateAccountScreenModule {

    @CreateAccountScreenComponentScope
    @Provides
    fun provideCreateAccountScreenViewModel(
        createAccountRequestUseCase: CreateAccountRequestUseCase
    ): CreateAccountScreenViewModel = CreateAccountScreenViewModel(
        createAccountRequestUseCase
    )
}