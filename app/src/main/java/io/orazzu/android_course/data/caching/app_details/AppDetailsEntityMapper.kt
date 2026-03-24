package io.orazzu.android_course.data.caching.app_details

import io.orazzu.android_course.domain.app_details.AppDetails
import javax.inject.Inject

class AppDetailsEntityMapper @Inject constructor() {
    fun toEntity(domain: AppDetails): AppDetailsEntity = AppDetailsEntity(
        id = domain.id,
        name = domain.name,
        developer = domain.developer,
        category = domain.category,
        ageRating = domain.ageRating,
        iconUrl = domain.iconUrl,
        screenshots = domain.screenshotUrlList,
        description = (domain.longDescription ?: domain.shortDescription)!!,
    )

    fun toDomain(entity: AppDetailsEntity): AppDetails = AppDetails(
        id = entity.id,
        name = entity.name,
        developer = entity.developer,
        category = entity.category,
        ageRating = entity.ageRating,
        iconUrl = entity.iconUrl,
        screenshotUrlList = entity.screenshots,
        shortDescription = null,
        longDescription = entity.description,
    )
}
