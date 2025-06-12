package com.finance.breef.presentation.screens.main.di

import com.finance.breef.presentation.screens.main.BreefMainScreenViewModel
import dagger.Subcomponent

@BreefScreenComponentScope
@Subcomponent(
    modules = [BreefScreenModule::class]
)
interface BreefScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): BreefScreenComponent
    }

    val breefMainScreenViewModel: BreefMainScreenViewModel
}
