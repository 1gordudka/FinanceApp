package com.finance.brief.presentation.screens.main.di

import com.finance.brief.presentation.screens.main.BriefMainScreenViewModel
import dagger.Module
import dagger.Provides

@Module
class BriefScreenModule {

    @BriefScreenComponentScope
    @Provides
    fun providebriefMainScreenViewModel(): BriefMainScreenViewModel =
        BriefMainScreenViewModel()
}

