package io.orazzu.android_course.data.caching.app_details

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDetailsDao {
    @Query("select * from app_details where id = :id")
    fun getAppDetails(id: String): AppDetailsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun putAppDetails(appDetails: AppDetailsEntity)
}
