package com.finance.common.database.workers

import android.content.Context
import android.util.Log
import androidx.work.*
import com.finance.common.database.repository.OfflineTransactionRepository
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SyncWorker(
    context: Context,
    workerParams: WorkerParameters,
    private val offlineRepository: OfflineTransactionRepository
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            Log.d("SyncWorker", "Начинаем периодическую синхронизацию")
            
            // Проверяем есть ли несинхронизированные данные
            val unsyncedCount = offlineRepository.getUnsyncedTransactionsCount()
            Log.d("SyncWorker", "Несинхронизированных транзакций: $unsyncedCount")
            
            if (unsyncedCount > 0) {
                // Выполняем синхронизацию
                val syncResult = offlineRepository.syncTransactions()
                
                if (syncResult.isSuccess) {
                    Log.d("SyncWorker", "Синхронизация завершена успешно")
                    Result.success()
                } else {
                    Log.e("SyncWorker", "Ошибка синхронизации: ${syncResult.exceptionOrNull()?.message}")
                    Result.retry()
                }
            } else {
                Log.d("SyncWorker", "Нет данных для синхронизации")
                Result.success()
            }
        } catch (e: Exception) {
            Log.e("SyncWorker", "Критическая ошибка в SyncWorker", e)
            Result.failure()
        }
    }

    companion object {
        const val WORK_NAME = "sync_transactions_work"
        const val SYNC_INTERVAL_HOURS = 2L

        fun schedulePeriodicSync(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build()

            val syncWorkRequest = PeriodicWorkRequestBuilder<SyncWorker>(
                SYNC_INTERVAL_HOURS, TimeUnit.HOURS
            )
                .setConstraints(constraints)
                .setBackoffCriteria(
                    BackoffPolicy.EXPONENTIAL,
                    WorkRequest.MIN_BACKOFF_MILLIS,
                    TimeUnit.MILLISECONDS
                )
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                syncWorkRequest
            )
            
            Log.d("SyncWorker", "Периодическая синхронизация запланирована каждые $SYNC_INTERVAL_HOURS часа")
        }

        fun cancelPeriodicSync(context: Context) {
            WorkManager.getInstance(context).cancelUniqueWork(WORK_NAME)
            Log.d("SyncWorker", "Периодическая синхронизация отменена")
        }
    }
} 