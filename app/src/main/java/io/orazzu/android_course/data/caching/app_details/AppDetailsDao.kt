package io.orazzu.android_course.data.caching.app_details

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import io.orazzu.android_course.domain.AppCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDetailsDao {
    @Query("select * from app_details where id = :id")
    fun getAppDetails(id: String): Flow<AppDetailsEntity?>

    @Query("select isInWishlist from app_details where id = :id")
    fun getIsInWishlist(id: String): Boolean?

    @Upsert
    fun putAppDetails(appDetails: AppDetailsEntity)

    @Query("update app_details set isInWishlist = :isInWishlist where id = :id")
    fun updateWishlistStatus(id: String, isInWishlist: Boolean)
}
