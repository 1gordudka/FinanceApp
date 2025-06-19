package com.features.income.data.repository

import com.features.income.data.remote.mappers.calculateAllIncome
import com.features.income.data.remote.mappers.incomeCategoryToUIMapper
import com.features.income.data.remote.repository.RemoteIncomeFeatureRepository
import com.features.income.data.remote.results.RemoteObtainIncomeResult
import com.finance.common.network.repository.AccountRepository
import com.finance.common.network.results.ObtainAccountId
import com.finance.income.domain.repository.IncomeFeatureRepository
import com.finance.income.domain.results.ObtainIncomeData

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
}