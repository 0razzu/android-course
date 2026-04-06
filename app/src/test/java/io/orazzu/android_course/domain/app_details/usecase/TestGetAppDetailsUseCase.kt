package io.orazzu.android_course.domain.app_details.usecase

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.orazzu.android_course.domain.AppCategory
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.domain.app_details.AppDetailsRepo
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.FieldSource
import org.junit.jupiter.params.provider.ValueSource

class TestGetAppDetailsUseCase {
    private val repo = mockk<AppDetailsRepo>()
    private val useCase = GetAppDetailsUseCase(repo)

    @Test
    fun `returns success when repo returns success`() = runTest {
        val id = "1"
        val data = mockk<AppDetails>()
        val expected = DomainResult.Success(data)

        coEvery { repo.getAppDetails(id) } returns expected

        val res = useCase(id)

        assertTrue(res is DomainResult.Success)
    }

    @Test
    fun `returns failure when repo returns failure`() = runTest {
        val id = "1"

        coEvery { repo.getAppDetails(id) } returns DomainResult.Failure(DomainError.CONNECTION_ERROR)

        val res = useCase(id)

        assertTrue(res is DomainResult.Failure)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "   ", "\t", "\t\t"])
    fun `returns failure without calling repo when id is blank`(id: String) = runTest {
        val res = useCase(id)

        assertTrue(res is DomainResult.Failure)
        coVerify(exactly = 0) { repo.getAppDetails(any()) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "aaa", "abc-def5"])
    fun `calls repo with correct id`(id: String) = runTest {
        coEvery { repo.getAppDetails(id) } returns mockk()

        useCase(id)

        coVerify { repo.getAppDetails(id) }
    }

    @ParameterizedTest
    @FieldSource
    fun `does not transform result`(expected: DomainResult<AppDetails>) = runTest {
        val id = "1"

        coEvery { repo.getAppDetails(id) } returns expected

        val actual = useCase(id)

        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        private val `does not transform result` = listOf(
            DomainResult.Success(mockk<AppDetails>()),
            DomainResult.Success(
                AppDetails(
                    id = "1",
                    name = "12345",
                    developer = "54321",
                    category = AppCategory.PHOTO_AND_VIDEO,
                    ageRating = 5,
                    iconUrl = "http://somewhere.net",
                    shortDescription = "smth",
                    longDescription = "smth else",
                    screenshotUrlList = listOf("http://somehow.net"),
                    isInWishlist = true,
                ),
            ),
            DomainResult.Failure(DomainError.CONNECTION_ERROR),
            DomainResult.Failure(DomainError.NOT_FOUND),
        )
    }
}
