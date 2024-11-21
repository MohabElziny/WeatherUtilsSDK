package com.mohab.weatherutils

fun Long.formatSecondsToDate(): String = DateUtils.formatter("dd MMMM yyyy", this)

fun Long.formatSecondsToTime(): String = DateUtils.formatter("hh:mm a", this)

fun Long.formatSecondsToDayName(): String = DateUtils.formatter("EEE", this)