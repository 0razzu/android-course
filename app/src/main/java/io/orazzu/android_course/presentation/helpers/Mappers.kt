package io.orazzu.android_course.presentation.helpers

import android.content.Context
import android.content.res.Resources
import android.util.Log
import io.orazzu.android_course.R
import io.orazzu.android_course.domain.AppCategory

fun AppCategory.toString(ctx: Context): String = try {
    ctx.getString(
        ctx.resources.getIdentifier(
            "AppCategory_${this.name}",
            "string",
            ctx.packageName,
        ),
    )
} catch (_: Resources.NotFoundException) {
    Log.w("AppCategory.toString", "String resource not found for AppCategory $this")
    ctx.getString(R.string.AppCategory_APP)
}
