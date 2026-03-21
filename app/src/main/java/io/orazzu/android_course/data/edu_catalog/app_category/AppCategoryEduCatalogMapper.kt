package io.orazzu.android_course.data.edu_catalog.app_category

import io.orazzu.android_course.domain.AppCategory
import javax.inject.Inject

class AppCategoryEduCatalogMapper @Inject constructor() {
    fun toDomain(dto: String): AppCategory = when (dto.lowercase()) {
        "бизнес" -> AppCategory.BUSINESS
        "еда и напитки" -> AppCategory.FOOD
        "здоровье и фитнес" -> AppCategory.HEALTH
        "игры" -> AppCategory.GAME
        "книги и справочники" -> AppCategory.BOOKS
        "музыка" -> AppCategory.MUSIC
        "навигация" -> AppCategory.MAPS
        "новости" -> AppCategory.NEWS
        "образ жизни" -> AppCategory.LIFESTYLE
        "образование" -> AppCategory.EDUCATION
        "общение" -> AppCategory.SOCIAL
        "производительность" -> AppCategory.PRODUCTIVITY
        "развлечения" -> AppCategory.ENTERTAINMENT
        "утилиты" -> AppCategory.UTILITIES
        "финансы" -> AppCategory.FINANCE
        "фото и видео" -> AppCategory.PHOTOGRAPHY_AND_VIDEO
        "шопинг" -> AppCategory.SHOPPING
        else -> throw IllegalArgumentException("Unknown app category: $dto")
    }
}
