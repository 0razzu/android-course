package io.orazzu.android_course

import android.content.Context
import android.widget.Toast

val String.isPhoneNumber: Boolean
    get() = android.util.Patterns.PHONE.matcher(this).matches()

fun showToast(ctx: Context, text: String) = Toast.makeText(ctx, text, Toast.LENGTH_SHORT).show()
