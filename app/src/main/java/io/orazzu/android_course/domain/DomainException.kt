package io.orazzu.android_course.domain

class DomainException(
    val error: DomainError,
    cause: Throwable?,
) : RuntimeException(cause)
