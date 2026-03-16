package io.orazzu.android_course.data.app_details

data class AppDetailsDto(
    val id: String,
    val name: String,
    val developer: String,
    val category: String,
    val ageRating: Int,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val shortDescription: String,
    val longDescription: String?,
)
