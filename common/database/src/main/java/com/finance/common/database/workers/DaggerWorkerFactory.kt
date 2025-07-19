package com.finance.common.database.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.finance.common.database.repository.OfflineTransactionRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DaggerWorkerFactory @Inject constructor(
    private val offlineRepository: OfflineTransactionRepository
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            SyncWorker::class.java.name -> {
                SyncWorker(appContext, workerParameters, offlineRepository)
            }
            else -> null
        }
    }
} 