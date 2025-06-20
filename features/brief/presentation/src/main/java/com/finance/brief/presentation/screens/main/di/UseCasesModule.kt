package com.finance.brief.presentation.screens.main.di

import com.finance.brief.domain.repository.BriefFeatureRepository
import com.finance.brief.domain.use_cases.GetAccountUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @BriefScreenComponentScope
    @Provides
    fun provideGetAccountUseCase(
        briefFeatureRepository: BriefFeatureRepository
    ): GetAccountUseCase = GetAccountUseCase(briefFeatureRepository)
}