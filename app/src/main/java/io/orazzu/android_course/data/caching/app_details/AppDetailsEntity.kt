package io.orazzu.android_course.data.caching.app_details

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.orazzu.android_course.domain.AppCategory

@Entity(tableName = "app_details")
data class AppDetailsEntity(
    @PrimaryKey val id: String,
    val name: String,
    val developer: String,
    val category: AppCategory,
    val ageRating: Int,
    val iconUrl: String,
    val screenshots: List<String>,
    val description: String,
    @ColumnInfo(defaultValue = "0")
    val isInWishlist: Boolean = false,
    val lastUpdated: Long = System.currentTimeMillis(),
)
