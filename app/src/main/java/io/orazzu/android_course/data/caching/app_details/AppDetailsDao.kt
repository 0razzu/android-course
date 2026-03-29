package io.orazzu.android_course.data.caching.app_details

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDetailsDao {
    @Query("select * from app_details where id = :id")
    fun getAppDetails(id: String): Flow<AppDetailsEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // TODO do not replace wishlist status
    fun putAppDetails(appDetails: AppDetailsEntity)

    @Query("update app_details set isInWishlist = :isInWishlist where id = :id")
    fun updateWishlistStatus(id: String, isInWishlist: Boolean)
}
