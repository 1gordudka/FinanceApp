package com.finance.outcome.data.repository

import com.finance.common.network.repository.AccountRepository
import com.finance.common.network.results.ObtainAccountId
import com.finance.outcome.data.remote.mappers.calculateAllOutcome
import com.finance.outcome.data.remote.mappers.incomeCategoryToUIMapper
import com.finance.outcome.data.remote.repository.RemoteOutcomeFeatureRepository
import com.finance.outcome.data.remote.results.RemoteObtainOutcomeResult
import com.finance.outcome.domain.repository.OutcomeFeatureRepository
import com.finance.outcome.domain.results.ObtainOutcomeData

class OutcomeFeatureRepositoryImpl(
    private val accountRepository: AccountRepository,
    private val remoteOutcomeFeatureRepository: RemoteOutcomeFeatureRepository
) : OutcomeFeatureRepository {
    override suspend fun getOutcomeData(startDate: String, endDate: String): ObtainOutcomeData {
        val resultId = accountRepository.getAccountId()
        return when (resultId) {
            ObtainAccountId.Error -> ObtainOutcomeData.Error
            is ObtainAccountId.Success -> {
                val remoteResult =
                    remoteOutcomeFeatureRepository.getOutcomeData(resultId.id, startDate, endDate)
                when (remoteResult) {
                    RemoteObtainOutcomeResult.Error -> ObtainOutcomeData.Error
                    is RemoteObtainOutcomeResult.Success -> ObtainOutcomeData.Success(
                        startDate = startDate,
                        endDate = endDate,
                        allOutcome = calculateAllOutcome(remoteResult.transactions),
                        transactions = remoteResult.transactions
                    )
                }
            }
        }
    }
}