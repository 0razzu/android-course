package io.orazzu.android_course.domain.app_details.usecase

import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.domain.app_details.AppDetailsRepo
import javax.inject.Inject

class GetAppDetailsUseCase @Inject constructor(
    private val repo: AppDetailsRepo,
) {
    suspend operator fun invoke(id: String): DomainResult<AppDetails> {
        if (id.isBlank()) {
            return DomainResult.Failure(DomainError.NOT_FOUND)
        }

        return repo.getAppDetails(id)
    }
}
