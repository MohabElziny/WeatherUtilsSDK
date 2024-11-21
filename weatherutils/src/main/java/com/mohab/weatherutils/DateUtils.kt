package com.mohab.weatherutils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

internal object DateUtils {
    internal fun formatter(pattern: String, dateInSeconds: Long): String {
        val sdf = SimpleDateFormat(pattern, Locale.ENGLISH)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = dateInSeconds * 1000L
        return sdf.format(calendar.time)
    }
}