package io.orazzu.android_course

val String.isPhoneNumber: Boolean
    get() = Regex("\\+?((\\d\\s?-?){11})").matches(this)
