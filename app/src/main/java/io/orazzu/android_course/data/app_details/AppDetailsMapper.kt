package io.orazzu.android_course.data.app_details

import io.orazzu.android_course.data.app_category.AppCategoryMapper
import io.orazzu.android_course.domain.app_details.AppDetails
import javax.inject.Inject

class AppDetailsMapper @Inject constructor(private val appCategoryMapper: AppCategoryMapper) {
    fun toDomain(dto: AppDetailsDto): AppDetails = AppDetails(
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
