package io.orazzu.android_course.data.local.app

data class AppLocalDto(
    val id: String,
    val name: String,
    val category: String,
    val ageRating: Int,
    val iconUrl: String,
    val shortDescription: String,
)
