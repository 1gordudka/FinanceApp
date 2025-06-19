package com.finance.common.ui.ext

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun formatIsoDate(dateString: String): String {
    val parsedDate = ZonedDateTime.parse(dateString)
    val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale("ru"))
    return parsedDate.format(formatter)
}
