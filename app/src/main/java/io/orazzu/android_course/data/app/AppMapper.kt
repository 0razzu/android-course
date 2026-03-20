package io.orazzu.android_course.data.app

import io.orazzu.android_course.data.app_category.AppCategoryMapper
import io.orazzu.android_course.domain.app.App
import javax.inject.Inject

class AppMapper @Inject constructor(
    private val appCategoryMapper: AppCategoryMapper,
) {
    fun toDomain(dto: AppDto): App = App(
        id = dto.id,
        name = dto.name,
        category = appCategoryMapper.toDomain(dto.category),
        ageRating = dto.ageRating,
        iconUrl = dto.iconUrl,
        shortDescription = dto.shortDescription,
    )
}
