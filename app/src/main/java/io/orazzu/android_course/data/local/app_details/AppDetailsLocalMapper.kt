package io.orazzu.android_course.data.local.app_details

import io.orazzu.android_course.data.local.app_category.AppCategoryLocalMapper
import io.orazzu.android_course.domain.app_details.AppDetails
import javax.inject.Inject

class AppDetailsLocalMapper @Inject constructor(private val appCategoryMapper: AppCategoryLocalMapper) {
    fun toDomain(dto: AppDetailsLocalDto): AppDetails = AppDetails(
        id = dto.id,
        name = dto.name,
        developer = dto.developer,
        category = appCategoryMapper.toDomain(dto.category),
        ageRating = dto.ageRating,
        iconUrl = dto.iconUrl,
        screenshotUrlList = dto.screenshotUrlList,
        shortDescription = dto.shortDescription,
        longDescription = dto.longDescription,
    )
}
