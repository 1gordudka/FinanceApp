package com.finance.brief.domain.use_cases

import com.finance.brief.domain.repository.BriefFeatureRepository

class ChangeAccountInfoUseCase(
    private val briefFeatureRepository: BriefFeatureRepository
) {

    suspend operator fun invoke(
        name: String,
        balance: String,
        currency: String
    ) = briefFeatureRepository.updateAccount(
        name = name, balance = balance, currency = currency
    )
}