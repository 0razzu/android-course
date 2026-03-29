package io.orazzu.android_course.data.caching.app_details

import androidx.room.Dao
import androidx.room.Query
import io.orazzu.android_course.domain.AppCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDetailsDao {
    @Query("select * from app_details where id = :id")
    fun getAppDetails(id: String): Flow<AppDetailsEntity?>

    @Query(
        """
    insert into app_details (
        id,
        name,
        developer,
        category,
        ageRating,
        iconUrl,
        screenshots,
        description,
        isInWishlist
    )
    values (
        :id,
        :name,
        :developer,
        :category,
        :ageRating,
        :iconUrl,
        :screenshots,
        :description,
        :isInWishlist
    )
    on conflict(id) do update set
        name = excluded.name,
        developer = excluded.developer,
        category = excluded.category,
        ageRating = excluded.ageRating,
        iconUrl = excluded.iconUrl,
        screenshots = excluded.screenshots,
        description = excluded.description
    """,  // preserve isInWishlist
    )
    fun putAppDetailsInternal(
        id: String,
        name: String,
        developer: String,
        category: AppCategory,
        ageRating: Int,
        iconUrl: String,
        screenshots: List<String>,
        description: String?,
        isInWishlist: Boolean,
    )

    fun putAppDetails(appDetails: AppDetailsEntity) = putAppDetailsInternal(
        appDetails.id,
        appDetails.name,
        appDetails.developer,
        appDetails.category,
        appDetails.ageRating,
        appDetails.iconUrl,
        appDetails.screenshots,
        appDetails.description,
        appDetails.isInWishlist,
    )

    @Query("update app_details set isInWishlist = :isInWishlist where id = :id")
    fun updateWishlistStatus(id: String, isInWishlist: Boolean)
}
