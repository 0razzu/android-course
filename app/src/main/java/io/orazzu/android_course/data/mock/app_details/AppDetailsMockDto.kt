package io.orazzu.android_course.data.mock.app_details

data class AppDetailsMockDto(
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
