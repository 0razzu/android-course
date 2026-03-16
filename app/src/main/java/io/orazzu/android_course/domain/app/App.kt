package io.orazzu.android_course.domain.app

import io.orazzu.android_course.domain.AppCategory

data class App(
    val id: String,
    val name: String,
    val category: AppCategory,
    val ageRating: Int,
    val iconUrl: String,
    val shortDescription: String,
)
