package io.orazzu.android_course.domain.app_details

import io.orazzu.android_course.domain.DomainResult
import kotlinx.coroutines.flow.Flow

interface AppDetailsRepo {
    suspend fun getAppDetails(id: String): DomainResult<AppDetails>
    fun observeAppDetails(id: String): Flow<DomainResult<AppDetails>>
    suspend fun refreshAppDetails(id: String): DomainResult<AppDetails> = getAppDetails(id)
    suspend fun toggleWishlistStatus(id: String): DomainResult<Unit>
}
