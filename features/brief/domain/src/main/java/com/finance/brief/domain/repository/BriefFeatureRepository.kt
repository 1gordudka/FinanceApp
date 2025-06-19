package com.finance.brief.domain.repository

import com.finance.brief.domain.results.ObtainAccountResult

interface BriefFeatureRepository {

    suspend fun getAccount(): ObtainAccountResult
}