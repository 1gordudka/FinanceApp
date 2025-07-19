package com.finance.common.database.converters

import androidx.room.TypeConverter
import com.finance.common.database.entities.SyncState

class SyncStateConverter {
    
    @TypeConverter
    fun fromSyncState(syncState: SyncState): String {
        return syncState.name
    }
    
    @TypeConverter
    fun toSyncState(syncState: String): SyncState {
        return SyncState.valueOf(syncState)
    }
} 