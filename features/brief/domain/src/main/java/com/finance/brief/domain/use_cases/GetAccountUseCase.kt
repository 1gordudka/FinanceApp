package com.finance.brief.domain.use_cases

import com.finance.brief.domain.repository.BriefFeatureRepository

class GetAccountUseCase(
    private val briefFeatureRepository: BriefFeatureRepository
) {

    suspend operator fun invoke() = briefFeatureRepository.getAccount()
}