package com.cyb.youtubeplayer.common.util

import com.google.api.client.util.DateTime
import java.text.SimpleDateFormat
import java.util.Date

object DateUtil {

    fun formatDateTime(dateTime: DateTime): String {
        val date = Date(dateTime.value)
        val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return df.format(date)
    }
}