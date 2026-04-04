package io.orazzu.android_course.data.caching.app_details

import io.orazzu.android_course.TestCase
import io.orazzu.android_course.domain.AppCategory
import io.orazzu.android_course.domain.app_details.AppDetails
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertNull
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class TestAppDetailsEntityMapper {
    @ParameterizedTest(name = "{0}")
    @MethodSource("dto to domain simple cases")
    @MethodSource("dto to domain corner cases")
    fun `dto to domain mapping fills all fields`(case: TestCase<AppDetailsEntity>) {
        val mapper = AppDetailsEntityMapper()

        val entity = case.value
        val domain = mapper.toDomain(entity)

        assertAll(
            { assertEquals(entity.id, domain.id) },
            { assertEquals(entity.name, domain.name) },
            { assertEquals(entity.developer, domain.developer) },
            { assertEquals(entity.category, domain.category) },
            { assertEquals(entity.ageRating, domain.ageRating) },
            { assertEquals(entity.iconUrl, domain.iconUrl) },
            { assertEquals(entity.screenshots, domain.screenshotUrlList) },
            { assertNull(domain.shortDescription) },
            { assertEquals(entity.description, domain.longDescription) },
            { assertEquals(entity.isInWishlist, domain.isInWishlist) },
        )
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("domain to dto simple cases")
    @MethodSource("domain to dto corner cases")
    fun `domain to dto mapping fills all fields`(case: TestCase<AppDetails>) {
        val mapper = AppDetailsEntityMapper()

        val domain = case.value
        val entity = mapper.toEntity(domain)

        assertAll(
            { assertEquals(domain.id, entity.id) },
            { assertEquals(domain.name, entity.name) },
            { assertEquals(domain.developer, entity.developer) },
            { assertEquals(domain.category, entity.category) },
            { assertEquals(domain.ageRating, entity.ageRating) },
            { assertEquals(domain.iconUrl, entity.iconUrl) },
            { assertEquals(domain.screenshotUrlList, entity.screenshots) },
            {
                assertEquals(
                    domain.longDescription ?: domain.shortDescription ?: "",
                    entity.description,
                )
            },
            { assertEquals(domain.isInWishlist, entity.isInWishlist) },
        )
    }


    companion object {
        @JvmStatic
        fun `dto to domain simple cases`(): List<TestCase<AppDetailsEntity>> = listOf(
            TestCase(
                name = "simple 1",
                value = AppDetailsEntity(
                    id = "349reii4ur8r",
                    name = "Name",
                    developer = "Dev",
                    category = AppCategory.UTILITIES,
                    ageRating = 0,
                    iconUrl = "https://smth.com",
                    screenshots = listOf(
                        "https://smth.com/1",
                        "https://smth.else/2?d=900x400",
                    ),
                    description = "Abc abc defghi.",
                    isInWishlist = false,
                ),
            ),
            TestCase(
                name = "simple 2",
                value = AppDetailsEntity(
                    id = "123",
                    name = "12345",
                    developer = "54321",
                    category = AppCategory.PHOTO_AND_VIDEO,
                    ageRating = 5,
                    iconUrl = "http://somewhere.net",
                    screenshots = listOf("url"),
                    description = "A b c! j@n*;",
                    isInWishlist = true,
                ),
            ),
        )

        @JvmStatic
        fun `dto to domain corner cases`(): List<TestCase<AppDetailsEntity>> = listOf(
            TestCase(
                name = "utf",
                value = AppDetailsEntity(
                    id = "5",
                    name = "Тест 🚀 漢字",
                    developer = "Разраб 👨‍💻",
                    category = AppCategory.GAME,
                    ageRating = 3,
                    iconUrl = "url",
                    screenshots = listOf("url1", "url2"),
                    description = "Описание с эмодзи 🤪👉🏻👈🏻",
                    isInWishlist = true,
                ),
            ),
            TestCase(
                name = "url duplicates",
                value = AppDetailsEntity(
                    id = "6",
                    name = "Url Duplicates",
                    developer = "Dev",
                    category = AppCategory.FOOD,
                    ageRating = 3,
                    iconUrl = "url",
                    screenshots = listOf("same", "same", "same"),
                    description = "desc",
                    isInWishlist = false,
                ),
            ),
            TestCase(
                name = "empty",
                value = AppDetailsEntity(
                    id = "",
                    name = "",
                    developer = "",
                    category = AppCategory.BUSINESS,
                    ageRating = Int.MIN_VALUE,
                    iconUrl = "",
                    screenshots = emptyList(),
                    description = "",
                ),
            ),
            TestCase(
                name = "large",
                value = AppDetailsEntity(
                    id = "a".repeat(1000),
                    name = "b".repeat(1000),
                    developer = "c".repeat(1000),
                    category = AppCategory.NEWS,
                    ageRating = Int.MAX_VALUE,
                    iconUrl = "https://long-url.com/" + "x".repeat(500),
                    screenshots = List(100) { "url$it" },
                    description = "d".repeat(5000),
                    isInWishlist = true,
                ),
            ),
        )

        @JvmStatic
        fun `domain to dto simple cases`(): List<TestCase<AppDetails>> = listOf(
            TestCase(
                name = "simple",
                value = AppDetails(
                    id = "349reii4ur8r",
                    name = "Name",
                    developer = "Dev",
                    category = AppCategory.UTILITIES,
                    ageRating = 0,
                    iconUrl = "https://smth.com",
                    screenshotUrlList = listOf(
                        "https://smth.com/1",
                        "https://smth.else/2?d=900x400",
                    ),
                    shortDescription = "Aaa d",
                    longDescription = "Abc abc defghi.",
                    isInWishlist = false,
                ),
            ),
            TestCase(
                name = "no short description",
                value = AppDetails(
                    id = "123",
                    name = "12345",
                    developer = "54321",
                    category = AppCategory.PHOTO_AND_VIDEO,
                    ageRating = 5,
                    iconUrl = "http://somewhere.net",
                    shortDescription = null,
                    longDescription = "A b c! j@n*;",
                    screenshotUrlList = listOf("url"),
                    isInWishlist = true,
                ),
            ),
            TestCase(
                name = "no long description",
                value = AppDetails(
                    id = "123",
                    name = "12345",
                    developer = "54321",
                    category = AppCategory.PHOTO_AND_VIDEO,
                    ageRating = 5,
                    iconUrl = "http://somewhere.net",
                    shortDescription = "A b c! j@n*;",
                    longDescription = null,
                    screenshotUrlList = listOf("url"),
                    isInWishlist = true,
                ),
            ),
        )

        @JvmStatic
        fun `domain to dto corner cases`(): List<TestCase<AppDetails>> = listOf(
            TestCase(
                name = "no description",
                value = AppDetails(
                    id = "123",
                    name = "12345",
                    developer = "54321",
                    category = AppCategory.PHOTO_AND_VIDEO,
                    ageRating = 5,
                    iconUrl = "http://somewhere.net",
                    shortDescription = null,
                    longDescription = null,
                    screenshotUrlList = listOf("url"),
                    isInWishlist = true,
                ),
            ),
            TestCase(
                name = "utf",
                value = AppDetails(
                    id = "5",
                    name = "Тест 🚀 漢字",
                    developer = "Разраб 👨‍💻",
                    category = AppCategory.GAME,
                    ageRating = 3,
                    iconUrl = "url",
                    shortDescription = "やあ！",
                    longDescription = "Описание с эмодзи 🤪👉🏻👈🏻",
                    screenshotUrlList = listOf("url1", "url2"),
                    isInWishlist = true,
                ),
            ),
            TestCase(
                name = "url duplicates",
                value = AppDetails(
                    id = "6",
                    name = "Url Duplicates",
                    developer = "Dev",
                    category = AppCategory.FOOD,
                    ageRating = 3,
                    iconUrl = "url",
                    shortDescription = "desc",
                    longDescription = "description",
                    screenshotUrlList = listOf("same", "same", "same"),
                    isInWishlist = false,
                ),
            ),
            TestCase(
                name = "empty",
                value = AppDetails(
                    id = "",
                    name = "",
                    developer = "",
                    category = AppCategory.BUSINESS,
                    ageRating = Int.MIN_VALUE,
                    iconUrl = "",
                    shortDescription = "",
                    longDescription = "",
                    screenshotUrlList = emptyList(),
                    isInWishlist = false,
                ),
            ),
            TestCase(
                name = "large",
                value = AppDetails(
                    id = "a".repeat(1000),
                    name = "b".repeat(1000),
                    developer = "c".repeat(1000),
                    category = AppCategory.NEWS,
                    ageRating = Int.MAX_VALUE,
                    iconUrl = "https://long-url.com/" + "x".repeat(500),
                    shortDescription = "d".repeat(500),
                    longDescription = "e".repeat(5000),
                    screenshotUrlList = List(100) { "url$it" },
                    isInWishlist = true,
                ),
            ),
        )
    }
}
