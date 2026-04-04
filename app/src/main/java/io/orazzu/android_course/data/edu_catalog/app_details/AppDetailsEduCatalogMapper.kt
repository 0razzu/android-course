package io.orazzu.android_course.data.edu_catalog.app_details

import io.orazzu.android_course.data.edu_catalog.app_category.AppCategoryEduCatalogMapper
import io.orazzu.android_course.domain.app_details.AppDetails
import javax.inject.Inject

class AppDetailsEduCatalogMapper @Inject constructor(
    private val appCategoryMapper: AppCategoryEduCatalogMapper,
) {
    fun toDomain(dto: AppDetailsEduCatalogDto): AppDetails = AppDetails(
        id = dto.id,
        name = dto.name,
        category = appCategoryMapper.toDomain(dto.category),
        ageRating = dto.ageRating,
        iconUrl = dto.iconUrl,
        shortDescription = null,
        developer = dto.developer,
        screenshotUrlList = dto.screenshotUrlList,
        longDescription = dto.description,
        isInWishlist = false,
    )
}
