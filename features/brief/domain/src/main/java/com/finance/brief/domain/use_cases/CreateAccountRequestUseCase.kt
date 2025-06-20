package com.finance.brief.domain.use_cases

import com.finance.brief.domain.models.CreateAccountRequest
import com.finance.brief.domain.repository.BriefFeatureRepository

class CreateAccountRequestUseCase(
    private val briefFeatureRepository: BriefFeatureRepository
) {

    suspend operator fun invoke(createAccountRequest: CreateAccountRequest) =
        briefFeatureRepository.createAccount(createAccountRequest)
}