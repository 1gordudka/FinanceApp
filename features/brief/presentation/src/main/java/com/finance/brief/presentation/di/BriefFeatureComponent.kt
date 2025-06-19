package com.finance.brief.presentation.di

import com.finance.brief.presentation.screens.create.di.CreateAccountScreenComponent
import com.finance.brief.presentation.screens.create.di.CreateAccountScreenComponentScope
import com.finance.brief.presentation.screens.main.di.BriefScreenComponent
import dagger.Subcomponent

@BriefFeatureComponentScope
@Subcomponent(
    modules = [BriefFeatureModule::class]
)
interface BriefFeatureComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): BriefFeatureComponent
    }

    val briefMainScreenComponentFactory: BriefScreenComponent.Factory
    val createAccountScreenComponentFactory: CreateAccountScreenComponent.Factory
}
