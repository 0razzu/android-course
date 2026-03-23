package io.orazzu.android_course.data.local.app_details

import androidx.room.PrimaryKey
import io.orazzu.android_course.domain.AppCategory

data class AppDetailsEntity(
    @PrimaryKey val id: String,
    val name: String,
    val developer: String,
    val category: AppCategory,
    val ageRating: Int,
    val iconUrl: String,
    val screenshots: List<String>,
    val description: String,
    val lastUpdated: Long = System.currentTimeMillis(),
)
