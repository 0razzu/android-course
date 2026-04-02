package io.orazzu.android_course.data.caching

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.orazzu.android_course.data.caching.app_details.AppDetailsDao
import io.orazzu.android_course.data.caching.app_details.AppDetailsEntity
import io.orazzu.android_course.data.caching.app_details.ScreenshotsConverter


@Database(
    entities = [AppDetailsEntity::class],
    version = 2,
)
@TypeConverters(AppCategoryConverter::class, ScreenshotsConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDetailsDao(): AppDetailsDao

    companion object {
        const val DATABASE_NAME = "app_database"
    }
}
