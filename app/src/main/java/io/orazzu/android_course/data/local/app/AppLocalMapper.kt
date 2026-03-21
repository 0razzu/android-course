package io.orazzu.android_course.data.local.app

import io.orazzu.android_course.data.local.app_category.AppCategoryLocalMapper
import io.orazzu.android_course.domain.app.App
import javax.inject.Inject

class AppLocalMapper @Inject constructor(
    private val appCategoryMapper: AppCategoryLocalMapper,
) {
    fun toDomain(dto: AppLocalDto): App = App(
        id = dto.id,
        name = dto.name,
        category = appCategoryMapper.toDomain(dto.category),
        ageRating = dto.ageRating,
        iconUrl = dto.iconUrl,
        shortDescription = dto.shortDescription,
    )
}
