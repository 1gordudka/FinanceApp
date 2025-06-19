package com.finance.brief.presentation.di

import com.finance.brief.data.remote.repository.RemoteBriefFeatureRepository
import com.finance.brief.data.repository.BriefFeatureRepositoryImpl
import com.finance.brief.domain.repository.BriefFeatureRepository
import com.finance.common.network.repository.AccountRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @BriefFeatureComponentScope
    @Provides
    fun provideBriefFeatureRepository(
        briefRemoteBriefFeatureRepository: RemoteBriefFeatureRepository,
        accountRepository: AccountRepository
    ): BriefFeatureRepository =
        BriefFeatureRepositoryImpl(
            accountRepository = accountRepository,
            remoteBriefFeatureRepository = briefRemoteBriefFeatureRepository
        )
}