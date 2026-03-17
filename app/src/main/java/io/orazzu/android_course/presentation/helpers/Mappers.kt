package io.orazzu.android_course.presentation.helpers

import android.content.Context
import io.orazzu.android_course.domain.AppCategory

fun AppCategory.toString(ctx: Context): String = ctx.getString(
    ctx.resources.getIdentifier(
        "AppCategory_${this.name}",
        "string",
        ctx.packageName,
    )
)
