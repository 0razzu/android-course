package io.orazzu.android_course.data.local

import androidx.room.TypeConverter
import io.orazzu.android_course.domain.AppCategory

class AppCategoryConverter {
    @TypeConverter
    fun fromCategory(category: AppCategory): String = category.name

    @TypeConverter
    fun toCategory(categoryName: String): AppCategory = AppCategory.valueOf(categoryName)
}
