package com.finance.brief.presentation.di

import com.finance.brief.data.remote.repository.RemoteBriefFeatureRepository
import com.finance.brief.data.remote.repository.RemoteBriefFeatureRepositoryImpl
import com.finance.brief.data.remote.service.BriefService
import com.finance.common.network.repository.AccountRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
class NetworkModule {

    @BriefFeatureComponentScope
    @Provides
    fun provideBriefService(retrofit: Retrofit): BriefService =
        retrofit.create(BriefService::class.java)

    @BriefFeatureComponentScope
    @Provides
    fun provideBriefRemoteFeatureRepository(
        briefService: BriefService,
    ): RemoteBriefFeatureRepository =
        RemoteBriefFeatureRepositoryImpl(
            briefService = briefService
        )

}