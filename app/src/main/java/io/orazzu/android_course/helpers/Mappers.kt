package io.orazzu.android_course.helpers

import android.content.Context
import io.orazzu.android_course.R
import io.orazzu.android_course.model.app.AppCategory

fun AppCategory.toString(ctx: Context): String = ctx.getString(
    when (this) {
        AppCategory.APP -> R.string.AppCategory_APP
        AppCategory.GAME -> R.string.AppCategory_GAME
        AppCategory.PRODUCTIVITY -> R.string.AppCategory_PRODUCTIVITY
        AppCategory.SOCIAL -> R.string.AppCategory_SOCIAL
        AppCategory.EDUCATION -> R.string.AppCategory_EDUCATION
        AppCategory.ENTERTAINMENT -> R.string.AppCategory_ENTERTAINMENT
        AppCategory.MUSIC -> R.string.AppCategory_MUSIC
        AppCategory.VIDEO -> R.string.AppCategory_VIDEO
        AppCategory.PHOTOGRAPHY -> R.string.AppCategory_PHOTOGRAPHY
        AppCategory.HEALTH -> R.string.AppCategory_HEALTH
        AppCategory.SPORTS -> R.string.AppCategory_SPORTS
        AppCategory.NEWS -> R.string.AppCategory_NEWS
        AppCategory.BOOKS -> R.string.AppCategory_BOOKS
        AppCategory.BUSINESS -> R.string.AppCategory_BUSINESS
        AppCategory.FINANCE -> R.string.AppCategory_FINANCE
        AppCategory.TRAVEL -> R.string.AppCategory_TRAVEL
        AppCategory.MAPS -> R.string.AppCategory_MAPS
        AppCategory.FOOD -> R.string.AppCategory_FOOD
        AppCategory.SHOPPING -> R.string.AppCategory_SHOPPING
        AppCategory.UTILITIES -> R.string.AppCategory_UTILITIES
    },
)

