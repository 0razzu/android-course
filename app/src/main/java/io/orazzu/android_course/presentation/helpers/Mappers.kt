package io.orazzu.android_course.presentation.helpers

import android.content.Context
import io.orazzu.android_course.R
import io.orazzu.android_course.domain.AppCategory

fun AppCategory.toString(ctx: Context): String = ctx.getString(
    when (this) {
        AppCategory.APP -> R.string.AppCategory_APP
        AppCategory.BOOKS -> R.string.AppCategory_BOOKS
        AppCategory.BUSINESS -> R.string.AppCategory_BUSINESS
        AppCategory.EDUCATION -> R.string.AppCategory_EDUCATION
        AppCategory.ENTERTAINMENT -> R.string.AppCategory_ENTERTAINMENT
        AppCategory.FINANCE -> R.string.AppCategory_FINANCE
        AppCategory.FOOD -> R.string.AppCategory_FOOD
        AppCategory.GAME -> R.string.AppCategory_GAME
        AppCategory.HEALTH -> R.string.AppCategory_HEALTH
        AppCategory.LIFESTYLE -> R.string.AppCategory_LIFESTYLE
        AppCategory.MAPS -> R.string.AppCategory_MAPS
        AppCategory.MUSIC -> R.string.AppCategory_MUSIC
        AppCategory.NEWS -> R.string.AppCategory_NEWS
        AppCategory.PHOTOGRAPHY -> R.string.AppCategory_PHOTOGRAPHY
        AppCategory.PHOTO_AND_VIDEO -> R.string.AppCategory_PHOTO_AND_VIDEO
        AppCategory.PRODUCTIVITY -> R.string.AppCategory_PRODUCTIVITY
        AppCategory.SHOPPING -> R.string.AppCategory_SHOPPING
        AppCategory.SOCIAL -> R.string.AppCategory_SOCIAL
        AppCategory.SPORTS -> R.string.AppCategory_SPORTS
        AppCategory.TRAVEL -> R.string.AppCategory_TRAVEL
        AppCategory.UTILITIES -> R.string.AppCategory_UTILITIES
        AppCategory.VIDEO -> R.string.AppCategory_VIDEO
        AppCategory.WEATHER -> R.string.AppCategory_WEATHER
    },
)
