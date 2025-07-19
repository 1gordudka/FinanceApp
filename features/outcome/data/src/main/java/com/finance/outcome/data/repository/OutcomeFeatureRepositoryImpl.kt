package com.finance.outcome.data.repository

import com.finance.common.network.repository.AccountRepository
import com.finance.common.network.results.ObtainAccountId
import com.finance.outcome.data.remote.mappers.calculateAllOutcome
import com.finance.outcome.data.remote.repository.RemoteOutcomeFeatureRepository
import com.finance.outcome.data.remote.results.RemoteObtainCreateOutcomeResult
import com.finance.outcome.data.remote.results.RemoteObtainOutcomeResult
import com.finance.outcome.data.remote.results.RemoteObtainTransactionResult
import com.finance.outcome.data.remote.results.RemoteObtainUpdateOutcomeResult
import com.finance.outcome.domain.models.CreateOutcomeRequest
import com.finance.outcome.domain.repository.OutcomeFeatureRepository
import com.finance.outcome.domain.results.ObtainCreateOutcomeResult
import com.finance.outcome.domain.results.ObtainOutcomeData
import com.finance.outcome.domain.results.ObtainTransactionResult
import com.finance.outcome.domain.results.ObtainUpdateOutcomeResult

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

    override suspend fun createOutcome(createOutcomeRequest: CreateOutcomeRequest): ObtainCreateOutcomeResult {
        val remoteResult = remoteOutcomeFeatureRepository.createOutcome(createOutcomeRequest)
        return when (remoteResult) {
            RemoteObtainCreateOutcomeResult.Error -> ObtainCreateOutcomeResult.Error
            is RemoteObtainCreateOutcomeResult.Success -> ObtainCreateOutcomeResult.Success
        }
    }

    override suspend fun getTransactionById(transactionId: Int): ObtainTransactionResult {
        val remoteResult = remoteOutcomeFeatureRepository.getTransactionById(transactionId)
        return when (remoteResult) {
            RemoteObtainTransactionResult.Error -> ObtainTransactionResult.Error
            is RemoteObtainTransactionResult.Success -> ObtainTransactionResult.Success(remoteResult.transaction)
        }
    }

    override suspend fun updateOutcome(transactionId: Int, createOutcomeRequest: CreateOutcomeRequest): ObtainUpdateOutcomeResult {
        val remoteResult = remoteOutcomeFeatureRepository.updateOutcome(transactionId, createOutcomeRequest)
        return when (remoteResult) {
            RemoteObtainUpdateOutcomeResult.Error -> ObtainUpdateOutcomeResult.Error
            is RemoteObtainUpdateOutcomeResult.Success -> ObtainUpdateOutcomeResult.Success
        }
    }
}