package io.orazzu.android_course.data.edu_catalog

import io.orazzu.android_course.data.edu_catalog.app_category.AppCategoryEduCatalogMapper
import io.orazzu.android_course.domain.AppCategory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertNotNull
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TestAppCategoryEduCatalogMapper {
    @Test
    fun `dto to domain mapping simple cases`() {
        val mapper = AppCategoryEduCatalogMapper()

        assertAll(
            { assertEquals(AppCategory.BUSINESS, mapper.toDomain("Бизнес")) },
            { assertEquals(AppCategory.WEATHER, mapper.toDomain("Погода")) },
            { assertEquals(AppCategory.WEATHER, mapper.toDomain("погода")) },
            { assertEquals(AppCategory.PHOTO_AND_VIDEO, mapper.toDomain("Фото и видео")) },
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["Бизнес ", " погода", "23", "", " "])
    fun `dto to domain mapping fails on unknown categories`(dto: String) {
        val mapper = AppCategoryEduCatalogMapper()

        val e = assertThrows<IllegalArgumentException> { mapper.toDomain(dto) }
        assertNotNull(e.message)
        val msg = e.message!!
        assertAll(
            { assertTrue(msg.contains("Unknown app category")) },
            { assertTrue(msg.contains(dto)) },
        )
    }
}
