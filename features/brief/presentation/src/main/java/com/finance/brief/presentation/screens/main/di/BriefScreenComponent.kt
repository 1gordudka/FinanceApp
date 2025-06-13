package com.finance.brief.presentation.screens.main.di

import com.finance.brief.presentation.screens.main.BriefMainScreenViewModel
import dagger.Subcomponent

@BriefScreenComponentScope
@Subcomponent(
    modules = [BriefScreenModule::class]
)
interface BriefScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): BriefScreenComponent
    }

    val briefMainScreenViewModel: BriefMainScreenViewModel
}
