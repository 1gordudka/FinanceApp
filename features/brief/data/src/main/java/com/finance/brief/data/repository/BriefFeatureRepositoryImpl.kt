package com.finance.brief.data.repository

import com.finance.brief.data.remote.mappers.toDomain
import com.finance.brief.data.remote.models.UpdateAccountRequest
import com.finance.brief.data.remote.repository.RemoteBriefFeatureRepository
import com.finance.brief.data.remote.results.ObtainRemoteAccountInfo
import com.finance.brief.data.remote.results.ObtainRemoteCreateAccountResult
import com.finance.brief.data.remote.results.ObtainRemoteUpdateAccountResult
import com.finance.brief.domain.models.CreateAccountRequest
import com.finance.brief.domain.repository.BriefFeatureRepository
import com.finance.brief.domain.results.ObtainAccountResult
import com.finance.brief.domain.results.ObtainChangeAccountResult
import com.finance.brief.domain.results.ObtainCreateAccountResult
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

    override suspend fun createAccount(createAccountRequest: CreateAccountRequest): ObtainCreateAccountResult {
        val result = remoteBriefFeatureRepository.createAccount(createAccountRequest)

        return when (result) {
            ObtainRemoteCreateAccountResult.Error -> ObtainCreateAccountResult.Error
            is ObtainRemoteCreateAccountResult.Success -> ObtainCreateAccountResult.Success
        }
    }

    override suspend fun updateAccount(
        name: String,
        balance: String,
        currency: String
    ): ObtainChangeAccountResult {
        val result = accountRepository.getAccountId()
        return when (result) {
            ObtainAccountId.Error -> ObtainChangeAccountResult.Error
            is ObtainAccountId.Success -> {
                val remoteResult = remoteBriefFeatureRepository.updateAccount(
                    result.id,
                    UpdateAccountRequest(
                        name = name,
                        currency = currency,
                        balance = balance
                    )
                )
                when (remoteResult) {
                    ObtainRemoteUpdateAccountResult.Error -> ObtainChangeAccountResult.Error
                    is ObtainRemoteUpdateAccountResult.Success -> ObtainChangeAccountResult.Success(
                        remoteResult.updateAccountResponse.toDomain()
                    )
                }
            }
        }
    }


}