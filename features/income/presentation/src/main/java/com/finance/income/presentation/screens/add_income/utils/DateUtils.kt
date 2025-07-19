package com.finance.income.presentation.screens.add_income.utils

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object DateUtils {
    
    private val ISO_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private val DISPLAY_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    
    fun getCurrentDateISO(): String {
        val now = LocalDateTime.now(ZoneId.systemDefault())
        return now.format(ISO_FORMATTER)
    }
    
    fun formatDateForDisplay(isoDate: String): String {
        return try {
            val dateTime = LocalDateTime.parse(isoDate, ISO_FORMATTER)
            dateTime.format(DISPLAY_FORMATTER)
        } catch (e: Exception) {
            isoDate
        }
    }
    
    fun parseToMillis(isoDate: String): Long {
        return try {
            val dateTime = LocalDateTime.parse(isoDate, ISO_FORMATTER)
            dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
        } catch (e: Exception) {
            System.currentTimeMillis()
        }
    }
    
    fun formatFromMillis(millis: Long): String {
        val instant = java.time.Instant.ofEpochMilli(millis)
        val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        return localDateTime.format(ISO_FORMATTER)
    }
} 