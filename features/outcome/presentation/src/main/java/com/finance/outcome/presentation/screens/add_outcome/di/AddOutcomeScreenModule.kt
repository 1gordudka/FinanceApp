package com.finance.outcome.presentation.screens.add_outcome.di

import com.finance.outcome.domain.use_cases.CreateOutcomeUseCase
import com.finance.outcome.domain.use_cases.GetTransactionByIdUseCase
import com.finance.outcome.domain.use_cases.UpdateOutcomeUseCase
import com.finance.outcome.presentation.screens.add_outcome.AddOutcomeScreenViewModel
import com.finance.outcome.presentation.screens.add_outcome.models.OutcomeScreenMode
import dagger.Module
import dagger.Provides

@Module(
    includes = [UseCasesModule::class]
)
class AddOutcomeScreenModule(
    private val mode: OutcomeScreenMode
) {

    @AddOutcomeScreenComponentScope
    @Provides
    fun provideOutcomeScreenMode(): OutcomeScreenMode = mode

    @AddOutcomeScreenComponentScope
    @Provides
    fun provideAddOutcomeScreenViewModel(
        createOutcomeUseCase: CreateOutcomeUseCase,
        updateOutcomeUseCase: UpdateOutcomeUseCase,
        getTransactionByIdUseCase: GetTransactionByIdUseCase,
        mode: OutcomeScreenMode
    ): AddOutcomeScreenViewModel = AddOutcomeScreenViewModel(
        createOutcomeUseCase, updateOutcomeUseCase, getTransactionByIdUseCase, mode
    )
} 