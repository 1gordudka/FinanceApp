package com.finance.brief.presentation.screens.main.di

import com.finance.brief.domain.use_cases.ChangeAccountInfoUseCase
import com.finance.brief.domain.use_cases.GetAccountUseCase
import com.finance.brief.presentation.screens.main.BriefMainScreenViewModel
import dagger.Module
import dagger.Provides

@Module(
    includes = [UseCasesModule::class]
)
class BriefScreenModule {

    @BriefScreenComponentScope
    @Provides
    fun provideBriefMainScreenViewModel(
        getAccountUseCase: GetAccountUseCase,
        changeAccountInfoUseCase: ChangeAccountInfoUseCase
    ): BriefMainScreenViewModel =
        BriefMainScreenViewModel(getAccountUseCase, changeAccountInfoUseCase)
}

