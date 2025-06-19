package com.finance.brief.data.repository

import android.util.Log
import com.finance.brief.data.remote.mappers.toDomain
import com.finance.brief.data.remote.repository.RemoteBriefFeatureRepository
import com.finance.brief.data.remote.results.ObtainRemoteAccountInfo
import com.finance.brief.domain.repository.BriefFeatureRepository
import com.finance.brief.domain.results.ObtainAccountResult
import com.finance.common.network.repository.AccountRepository
import com.finance.common.network.results.ObtainAccountId

class BriefFeatureRepositoryImpl(
    private val accountRepository: AccountRepository,
    private val remoteBriefFeatureRepository: RemoteBriefFeatureRepository
) : BriefFeatureRepository {
    override suspend fun getAccount(): ObtainAccountResult {
        val result = accountRepository.getAccountId()
        return when (result) {
            ObtainAccountId.Error -> ObtainAccountResult.Error
            is ObtainAccountId.Success -> {
                val remoteResult = remoteBriefFeatureRepository.getAccountInfo(result.id)
                when (remoteResult) {
                    ObtainRemoteAccountInfo.Error -> ObtainAccountResult.Error
                    is ObtainRemoteAccountInfo.Success -> ObtainAccountResult.Success(remoteResult.info.toDomain())
                }
            }
        }
    }

}