package io.orazzu.android_course.data.edu_catalog.app_details

data class AppDetailsEduCatalogDto(
    val id: String,
    val name: String,
    val developer: String,
    val category: String,
    val ageRating: Int,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String,
)
