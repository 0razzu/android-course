package io.orazzu.android_course.data.edu_catalog.app

import io.orazzu.android_course.data.edu_catalog.app_category.AppCategoryEduCatalogMapper
import io.orazzu.android_course.domain.app.App
import javax.inject.Inject

class AppEduCatalogMapper @Inject constructor(
    private val appCategoryMapper: AppCategoryEduCatalogMapper,
) {
    fun toDomain(dto: AppEduCatalogDto): App = App(
        id = dto.id,
        name = dto.name,
        category = appCategoryMapper.toDomain(dto.category),
        ageRating = null,
        iconUrl = dto.iconUrl,
        shortDescription = dto.description,
    )
}
