package io.orazzu.android_course.model.app

data class AppDetails(
    val id: String,
    val name: String,
    val developer: String,
    val category: AppCategory,
    val ageRating: Int,
    val iconUrl: String,
    val screenshotUrlList: List<String>?,
    val description: String,
)
