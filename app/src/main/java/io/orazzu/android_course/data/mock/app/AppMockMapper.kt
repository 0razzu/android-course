package io.orazzu.android_course.data.mock.app

import io.orazzu.android_course.data.mock.app_category.AppCategoryMockMapper
import io.orazzu.android_course.domain.app.App
import javax.inject.Inject

class AppMockMapper @Inject constructor(
    private val appCategoryMapper: AppCategoryMockMapper,
) {
    fun toDomain(dto: AppMockDto): App = App(
        id = dto.id,
        name = dto.name,
        category = appCategoryMapper.toDomain(dto.category),
        ageRating = dto.ageRating,
        iconUrl = dto.iconUrl,
        shortDescription = dto.shortDescription,
    )
}
