package com.finance.common.database.sync

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.finance.common.database.repository.OfflineTransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject
import javax.inject.Singleton

data class SyncStatus(
    val isOnline: Boolean = false,
    val lastSyncTime: Long? = null,
    val unsyncedItemsCount: Int = 0,
    val isSyncing: Boolean = false,
    val lastError: String? = null
)

@Singleton
class SyncStatusManager @Inject constructor(
    private val context: Context,
    private val offlineRepository: OfflineTransactionRepository
) {
    
    private val _syncStatus = MutableStateFlow(SyncStatus())
    val syncStatus: StateFlow<SyncStatus> = _syncStatus.asStateFlow()
    
    private val _isSyncing = MutableStateFlow(false)
    
    suspend fun updateSyncStatus() {
        val isOnline = isNetworkAvailable()
        val lastSyncTime = offlineRepository.getLastSyncTime()
        val unsyncedCount = offlineRepository.getUnsyncedTransactionsCount()
        
        _syncStatus.value = _syncStatus.value.copy(
            isOnline = isOnline,
            lastSyncTime = lastSyncTime,
            unsyncedItemsCount = unsyncedCount,
            isSyncing = _isSyncing.value
        )
    }
    
    suspend fun performManualSync(): Result<Unit> {
        if (_isSyncing.value) {
            return Result.failure(Exception("Синхронизация уже выполняется"))
        }
        
        _isSyncing.value = true
        _syncStatus.value = _syncStatus.value.copy(isSyncing = true, lastError = null)
        
        return try {
            val result = offlineRepository.syncTransactions()
            if (result.isSuccess) {
                updateSyncStatus()
                _syncStatus.value = _syncStatus.value.copy(lastError = null)
            } else {
                _syncStatus.value = _syncStatus.value.copy(
                    lastError = result.exceptionOrNull()?.message ?: "Неизвестная ошибка"
                )
            }
            result
        } catch (e: Exception) {
            _syncStatus.value = _syncStatus.value.copy(lastError = e.message)
            Result.failure(e)
        } finally {
            _isSyncing.value = false
            _syncStatus.value = _syncStatus.value.copy(isSyncing = false)
        }
    }
    
    private fun isNetworkAvailable(): Boolean {
        return try {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) 
                as ConnectivityManager
            val activeNetwork = connectivityManager.activeNetwork
            val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
            capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
        } catch (e: Exception) {
            false
        }
    }
} 