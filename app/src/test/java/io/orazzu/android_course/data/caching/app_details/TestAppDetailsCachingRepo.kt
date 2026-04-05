package io.orazzu.android_course.data.caching.app_details

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.orazzu.android_course.data.edu_catalog.EduCatalogApi
import io.orazzu.android_course.data.edu_catalog.app_details.AppDetailsEduCatalogDto
import io.orazzu.android_course.data.edu_catalog.app_details.AppDetailsEduCatalogMapper
import io.orazzu.android_course.domain.AppCategory
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app_details.AppDetails
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.IOException

@OptIn(ExperimentalCoroutinesApi::class)
class TestAppDetailsCachingRepo {
    private val dao = mockk<AppDetailsDao>()
    private val localMapper = mockk<AppDetailsEntityMapper>()
    private val remoteApi = mockk<EduCatalogApi>()
    private val remoteMapper = mockk<AppDetailsEduCatalogMapper>()
    private val repo = AppDetailsCachingRepo(
        dao = dao,
        appDetailsLocalMapper = localMapper,
        remoteApi = remoteApi,
        appDetailsRemoteMapper = remoteMapper,
    )

    @Test
    fun `getAppDetails returns success when api returns data`() = runTest {
        val id = "1"

        val dto = mockk<AppDetailsEduCatalogDto>()
        val domain = mockk<AppDetails>()
        val entity = mockk<AppDetailsEntity>()

        coEvery { dao.getAppDetails(id) } returns flowOf(null)
        coEvery { remoteApi.getAppById(id) } returns dto

        every { remoteMapper.toDomain(dto) } returns domain
        every { localMapper.toEntity(domain) } returns entity
        coEvery { dao.putAppDetails(entity) } returns Unit

        val res = repo.getAppDetails(id)

        assertTrue(res is DomainResult.Success)
        assertEquals(domain, (res as DomainResult.Success).data)
    }

    @Test
    fun `getAppDetails caches when api returns data`() = runTest {
        val id = "1"

        val dto = mockk<AppDetailsEduCatalogDto>()
        val domain = mockk<AppDetails>()
        every { domain.id } returns id
        every { domain.copy(isInWishlist = any()) } returns domain
        val entity = mockk<AppDetailsEntity>()

        coEvery { dao.getAppDetails(id) } returns flowOf(null)
        coEvery { remoteApi.getAppById(id) } returns dto

        every { remoteMapper.toDomain(dto) } returns domain
        every { localMapper.toEntity(domain) } returns entity
        coEvery { dao.getIsInWishlist(id) } returns true
        coEvery { dao.putAppDetails(entity) } returns Unit

        repo.getAppDetails(id)

        advanceUntilIdle()

        coVerify(exactly = 1, timeout = 1000) { dao.putAppDetails(any()) }
    }

    @Test
    fun `getAppDetails returns success and does not call api when cache returns data`() = runTest {
        val id = "1"

        val domain = mockk<AppDetails>()
        val entity = mockk<AppDetailsEntity>()

        coEvery { dao.getAppDetails(id) } returns flowOf(entity)
        every { localMapper.toDomain(entity) } returns domain

        val res = repo.getAppDetails(id)

        assertTrue(res is DomainResult.Success)
        assertEquals(domain, (res as DomainResult.Success).data)
        coVerify(exactly = 0) { remoteApi.getAppById(id) }
    }

    @Test
    fun `getAppDetails returns failure when cache returns null and api fails`() = runTest {
        val id = "1"

        coEvery { dao.getAppDetails(id) } returns flowOf(null)
        coEvery { remoteApi.getAppById(id) } throws IOException()

        val res = repo.getAppDetails(id)

        assertTrue(res is DomainResult.Failure)
        assertTrue((res as DomainResult.Failure).error == DomainError.CONNECTION_ERROR)
    }

    @Test
    fun `refreshAppDetails preserves isInWishlist`() = runTest {
        val id = "1"

        val dto = mockk<AppDetailsEduCatalogDto>()
        val domain = AppDetails(
            id = id,
            name = "name",
            developer = "dev",
            category = AppCategory.APP,
            ageRating = 0,
            iconUrl = "https://abc.xyz/1",
            screenshotUrlList = listOf("https://abc.xyz/2", "https://abc.xyz/3"),
            shortDescription = "short",
            longDescription = "long",
            isInWishlist = true,
        )

        coEvery { remoteApi.getAppById(id) } returns dto
        every { remoteMapper.toDomain(dto) } returns domain.copy(isInWishlist = false)
        coEvery { dao.getIsInWishlist(id) } returns true
        every { localMapper.toEntity(any()) } answers {
            val arg = firstArg<AppDetails>()
            assertTrue(arg.isInWishlist)
            mockk()
        }
        coEvery { dao.putAppDetails(any()) } returns Unit

        repo.refreshAppDetails(id)

        advanceUntilIdle()

        // fails when the local mapper’s assert fails
        coVerify(timeout = 1000) { dao.putAppDetails(any()) }
    }
}
