package io.orazzu.android_course.data.mock.app_details

import io.orazzu.android_course.data.mock.app_category.AppCategoryMockMapper
import io.orazzu.android_course.domain.app_details.AppDetails
import javax.inject.Inject

class AppDetailsMockMapper @Inject constructor(private val appCategoryMapper: AppCategoryMockMapper) {
    fun toDomain(dto: AppDetailsMockDto): AppDetails = AppDetails(
        id = dto.id,
        name = dto.name,
        developer = dto.developer,
        category = appCategoryMapper.toDomain(dto.category),
        ageRating = dto.ageRating,
        iconUrl = dto.iconUrl,
        screenshotUrlList = dto.screenshotUrlList,
        shortDescription = dto.shortDescription,
        longDescription = dto.longDescription,
        isInWishlist = false,
    )
}
