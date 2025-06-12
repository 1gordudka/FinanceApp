package com.finance.breef.presentation.screens.main.di

import com.finance.breef.presentation.screens.main.BreefMainScreenViewModel
import dagger.Module
import dagger.Provides

@Module
class BreefScreenModule {

    @BreefScreenComponentScope
    @Provides
    fun provideBreefMainScreenViewModel(): BreefMainScreenViewModel =
        BreefMainScreenViewModel()
}

