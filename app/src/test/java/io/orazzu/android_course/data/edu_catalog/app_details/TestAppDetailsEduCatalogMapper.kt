package io.orazzu.android_course.data.edu_catalog.app_details

import io.orazzu.android_course.data.edu_catalog.app_category.AppCategoryEduCatalogMapper
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNull
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource


class TestAppDetailsEduCatalogMapper {
    @ParameterizedTest(name = "{0}")
    @MethodSource("simple cases")
    @MethodSource("corner cases")
    fun `dto to domain mapping fills all fields`(case: TestCase) {
        val categoryMapper = AppCategoryEduCatalogMapper()
        val mapper = AppDetailsEduCatalogMapper(categoryMapper)

        val dto = case.dto
        val actual = mapper.toDomain(dto)

        assertAll(
            { assertEquals(dto.id, actual.id) },
            { assertEquals(dto.name, actual.name) },
            { assertEquals(dto.developer, actual.developer) },
            { assertEquals(categoryMapper.toDomain(dto.category), actual.category) },
            { assertEquals(dto.ageRating, actual.ageRating) },
            { assertEquals(dto.iconUrl, actual.iconUrl) },
            { assertEquals(dto.screenshotUrlList, actual.screenshotUrlList) },
            { assertEquals(dto.description, actual.longDescription) },
            { assertNull(actual.shortDescription) },
        )
    }

    @Test
    fun `dto to domain mapping fails when app category mapping fails`() {
        val dto = AppDetailsEduCatalogDto(
            id = "349reii4ur8r",
            name = "Name",
            developer = "Dev",
            category = "some weird category",
            ageRating = 0,
            iconUrl = "https://smth.com",
            screenshotUrlList = listOf("https://smth.com/1", "https://smth.else/2?d=900x400"),
            description = "Abc abc defghi.",
        )

        val categoryMapper = AppCategoryEduCatalogMapper()
        val mapper = AppDetailsEduCatalogMapper(categoryMapper)

        val e = assertThrows<IllegalArgumentException> { mapper.toDomain(dto) }
        try {
            categoryMapper.toDomain(dto.category)
        } catch (expectedE: IllegalArgumentException) {
            assertEquals(expectedE.message, e.message)
        }
    }


    data class TestCase(
        val name: String,
        val dto: AppDetailsEduCatalogDto,
    ) {
        override fun toString(): String = name
    }


    companion object {
        @JvmStatic
        fun `simple cases`() = listOf(
            TestCase(
                name = "simple 1",
                dto = AppDetailsEduCatalogDto(
                    id = "349reii4ur8r",
                    name = "Name",
                    developer = "Dev",
                    category = "Утилиты",
                    ageRating = 0,
                    iconUrl = "https://smth.com",
                    screenshotUrlList = listOf(
                        "https://smth.com/1",
                        "https://smth.else/2?d=900x400",
                    ),
                    description = "Abc abc defghi.",
                ),
            ),
            TestCase(
                name = "simple 2",
                dto = AppDetailsEduCatalogDto(
                    id = "123",
                    name = "12345",
                    developer = "54321",
                    category = "Фото и видео",
                    ageRating = 5,
                    iconUrl = "http://somewhere.",
                    screenshotUrlList = listOf("url"),
                    description = "A b c! j@n*;",
                ),
            ),
        )

        @JvmStatic
        fun `corner cases`() = listOf(
            TestCase(
                name = "utf",
                dto = AppDetailsEduCatalogDto(
                    id = "5",
                    name = "Тест 🚀 漢字",
                    developer = "Разраб 👨‍💻",
                    category = "Игры",
                    ageRating = 3,
                    iconUrl = "url",
                    screenshotUrlList = listOf("url1", "url2"),
                    description = "Описание с эмодзи 🤪👉🏻👈🏻",
                ),
            ),
            TestCase(
                name = "url duplicates",
                dto = AppDetailsEduCatalogDto(
                    id = "6",
                    name = "Url Duplicates",
                    developer = "Dev",
                    category = "Игры",
                    ageRating = 3,
                    iconUrl = "url",
                    screenshotUrlList = listOf("same", "same", "same"),
                    description = "desc",
                ),
            ),
            TestCase(
                name = "empty",
                dto = AppDetailsEduCatalogDto(
                    id = "",
                    name = "",
                    developer = "",
                    category = "Бизнес",
                    ageRating = Int.MIN_VALUE,
                    iconUrl = "",
                    screenshotUrlList = emptyList(),
                    description = "",
                ),
            ),
            TestCase(
                name = "large",
                dto = AppDetailsEduCatalogDto(
                    id = "a".repeat(1000),
                    name = "b".repeat(1000),
                    developer = "c".repeat(1000),
                    category = "Игры",
                    ageRating = Int.MAX_VALUE,
                    iconUrl = "https://long-url.com/" + "x".repeat(500),
                    screenshotUrlList = List(100) { "url$it" },
                    description = "d".repeat(5000),
                ),
            ),
        )
    }
}
