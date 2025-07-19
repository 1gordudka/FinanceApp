package com.features.income.data.repository

import com.features.income.data.remote.mappers.calculateAllIncome
import com.features.income.data.remote.repository.RemoteIncomeFeatureRepository
import com.features.income.data.remote.results.RemoteObtainCreateIncomeResult
import com.features.income.data.remote.results.RemoteObtainIncomeResult
import com.features.income.data.remote.results.RemoteObtainTransactionResult
import com.features.income.data.remote.results.RemoteObtainUpdateIncomeResult
import com.finance.common.network.repository.AccountRepository
import com.finance.common.network.results.ObtainAccountId
import com.finance.income.domain.models.CreateIncomeRequest
import com.finance.income.domain.repository.IncomeFeatureRepository
import com.finance.income.domain.results.ObtainCreateIncomeResult
import com.finance.income.domain.results.ObtainIncomeData
import com.finance.income.domain.results.ObtainTransactionResult
import com.finance.income.domain.results.ObtainUpdateIncomeResult

class IncomeFeatureRepositoryImpl(
    private val accountRepository: AccountRepository,
    private val remoteIncomeFeatureRepository: RemoteIncomeFeatureRepository
) : IncomeFeatureRepository {
    override suspend fun getIncomeData(startDate: String, endDate: String): ObtainIncomeData {
        val resultId = accountRepository.getAccountId()
        return when (resultId) {
            ObtainAccountId.Error -> ObtainIncomeData.Error
            is ObtainAccountId.Success -> {
                val remoteResult =
                    remoteIncomeFeatureRepository.getIncomeData(resultId.id, startDate, endDate)
                when (remoteResult) {
                    RemoteObtainIncomeResult.Error -> ObtainIncomeData.Error
                    is RemoteObtainIncomeResult.Success -> ObtainIncomeData.Success(
                        startDate = startDate,
                        endDate = endDate,
                        allIncome = calculateAllIncome(remoteResult.transactions),
                        transactions = remoteResult.transactions
                    )
                }
            }
        }
    }

    override suspend fun createIncome(createIncomeRequest: CreateIncomeRequest): ObtainCreateIncomeResult {
        val remoteResult = remoteIncomeFeatureRepository.createIncome(createIncomeRequest)
        return when (remoteResult) {
            RemoteObtainCreateIncomeResult.Error -> ObtainCreateIncomeResult.Error
            is RemoteObtainCreateIncomeResult.Success -> ObtainCreateIncomeResult.Success
        }
    }

    override suspend fun getTransactionById(transactionId: Int): ObtainTransactionResult {
        val remoteResult = remoteIncomeFeatureRepository.getTransactionById(transactionId)
        return when (remoteResult) {
            RemoteObtainTransactionResult.Error -> ObtainTransactionResult.Error
            is RemoteObtainTransactionResult.Success -> ObtainTransactionResult.Success(remoteResult.transaction)
        }
    }

    override suspend fun updateIncome(transactionId: Int, createIncomeRequest: CreateIncomeRequest): ObtainUpdateIncomeResult {
        val remoteResult = remoteIncomeFeatureRepository.updateIncome(transactionId, createIncomeRequest)
        return when (remoteResult) {
            RemoteObtainUpdateIncomeResult.Error -> ObtainUpdateIncomeResult.Error
            is RemoteObtainUpdateIncomeResult.Success -> ObtainUpdateIncomeResult.Success
        }
    }
}