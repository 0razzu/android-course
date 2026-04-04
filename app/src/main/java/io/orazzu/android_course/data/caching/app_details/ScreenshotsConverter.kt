package io.orazzu.android_course.data.caching.app_details

import androidx.room.TypeConverter
import com.google.gson.Gson

class ScreenshotsConverter {
    @TypeConverter
    fun fromScreenshotList(value: List<String>): String = Gson().toJson(value)

    @TypeConverter
    fun toScreenshotList(value: String): List<String> =
        Gson().fromJson(value, Array<String>::class.java).toList()
}
