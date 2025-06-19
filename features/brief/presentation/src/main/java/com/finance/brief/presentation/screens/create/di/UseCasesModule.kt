package com.finance.brief.presentation.screens.create.di

import com.finance.brief.domain.repository.BriefFeatureRepository
import com.finance.brief.domain.use_cases.CreateAccountRequestUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @CreateAccountScreenComponentScope
    @Provides
    fun provideCreateAccountUseCase(
        briefFeatureRepository: BriefFeatureRepository
    ): CreateAccountRequestUseCase =
        CreateAccountRequestUseCase(briefFeatureRepository)
}