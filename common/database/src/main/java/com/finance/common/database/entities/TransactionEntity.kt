package com.finance.common.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.finance.domain.transaction.Transaction
import com.finance.domain.transaction.Account
import com.finance.domain.transaction.Category

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey val id: Int,
    val serverId: Int?, // null for local-only transactions
    val accountId: Int,
    val accountName: String,
    val accountBalance: String,
    val accountCurrency: String,
    val categoryId: Int,
    val categoryName: String,
    val categoryEmoji: String,
    val isIncome: Boolean,
    val amount: String,
    val transactionDate: String,
    val comment: String?,
    val createdAt: String,
    val updatedAt: String,
    val lastSyncTime: Long?,
    val syncState: SyncState,
    val isDeleted: Boolean = false,
    val version: Int = 1 // for conflict resolution
) {
    fun toDomainModel(): Transaction {
        return Transaction(
            id = serverId ?: id,
            account = Account(
                id = accountId,
                name = accountName,
                balance = accountBalance,
                currency = accountCurrency
            ),
            category = Category(
                id = categoryId,
                name = categoryName,
                emoji = categoryEmoji,
                isIncome = isIncome
            ),
            amount = amount,
            transactionDate = transactionDate,
            comment = comment,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }
}

enum class SyncState {
    SYNCED,         // Синхронизирован с сервером
    PENDING_SYNC,   // Ожидает синхронизации
    PENDING_UPDATE, // Ожидает обновления на сервере
    PENDING_DELETE, // Ожидает удаления на сервере
    CONFLICT        // Конфликт при синхронизации
} 