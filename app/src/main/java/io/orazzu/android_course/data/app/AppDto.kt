package io.orazzu.android_course.data.app

data class AppDto(
    val id: String,
    val name: String,
    val category: String,
    val ageRating: Int,
    val iconUrl: String,
    val shortDescription: String,
)
