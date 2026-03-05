package io.orazzu.android_course

val String.isPhoneNumber: Boolean
    get() = android.util.Patterns.PHONE.matcher(this).matches()
