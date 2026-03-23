package io.orazzu.android_course.data.mock.app_category

import io.orazzu.android_course.domain.AppCategory
import javax.inject.Inject

class AppCategoryMockMapper @Inject constructor() {
    fun toDomain(dto: String): AppCategory = when (dto.lowercase()) {
        "app" -> AppCategory.APP
        "game" -> AppCategory.GAME
        "productivity" -> AppCategory.PRODUCTIVITY
        "social" -> AppCategory.SOCIAL
        "education" -> AppCategory.EDUCATION
        "entertainment" -> AppCategory.ENTERTAINMENT
        "music" -> AppCategory.MUSIC
        "video" -> AppCategory.VIDEO
        "photo" -> AppCategory.PHOTOGRAPHY
        "health" -> AppCategory.HEALTH
        "sports" -> AppCategory.SPORTS
        "news" -> AppCategory.NEWS
        "books" -> AppCategory.BOOKS
        "business" -> AppCategory.BUSINESS
        "finance" -> AppCategory.FINANCE
        "travel" -> AppCategory.TRAVEL
        "navigation" -> AppCategory.MAPS
        "food" -> AppCategory.FOOD
        "shopping" -> AppCategory.SHOPPING
        "utilities" -> AppCategory.UTILITIES
        else -> throw IllegalArgumentException("Unknown app category: $dto")
    }
}
