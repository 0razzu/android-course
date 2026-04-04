package io.orazzu.android_course.data.mock.app_details

import android.util.Log
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.domain.app_details.AppDetailsRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class AppDetailsMockRepo @Inject constructor(
    private val appDetailsMapper: AppDetailsMockMapper,
    private val api: AppDetailsMockApi,
) : AppDetailsRepo {
    private val logTag = this.javaClass.simpleName
    private val cache = mutableMapOf<String, MutableStateFlow<AppDetails?>>()

    override suspend fun getAppDetails(id: String): DomainResult<AppDetails> {
        Log.d(logTag, "Getting app $id")

        return try {
            val appDetailsDto = api.getAppDetails(id)
            DomainResult.Success(appDetailsMapper.toDomain(appDetailsDto))
        } catch (e: AppDetailsMockApi.NotFoundException) {
            Log.w(logTag, "App $id not found", e)

            DomainResult.Failure(DomainError.NOT_FOUND)
        } catch (e: Exception) {
            Log.e(logTag, "Unexpected exception while getting app $id", e)

            DomainResult.Failure(DomainError.UNKNOWN)
        }
    }

    override fun observeAppDetails(id: String): Flow<DomainResult<AppDetails>> {
        val flow = cache.getOrPut(id) {
            MutableStateFlow(null)
        }

        if (flow.value == null) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val curWishlistState = flow.value?.isInWishlist ?: false
                    flow.value = appDetailsMapper.toDomain(api.getAppDetails(id)).copy(
                        isInWishlist = curWishlistState,
                    )
                } catch (e: AppDetailsMockApi.NotFoundException) {
                    Log.w(logTag, "App $id not found", e)
                } catch (e: Exception) {
                    Log.e(logTag, "Unexpected exception while getting app $id", e)
                }
            }
        }

        return flow.map {
            if (it != null)
                DomainResult.Success(it)
            else DomainResult.Failure(DomainError.NOT_FOUND)
        }
    }

    override suspend fun toggleWishlistStatus(id: String): DomainResult<Unit> {
        val flow = cache[id] ?: return DomainResult.Failure(DomainError.NOT_FOUND)
        val appDetails = flow.value ?: return DomainResult.Failure(DomainError.NOT_FOUND)

        flow.value = appDetails.copy(
            isInWishlist = !appDetails.isInWishlist,
        )

        return DomainResult.Success(Unit)
    }
}
