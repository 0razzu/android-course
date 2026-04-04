package io.orazzu.android_course

data class TestCase<T>(
    val name: String,
    val value: T,
) {
    override fun toString(): String = name
}
