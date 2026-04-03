package io.orazzu.android_course.ui

import androidx.navigation.NavController

sealed class Screen(val route: String) {
    data object AppList : Screen("app_list") {
        val navigateToAppDetails: (NavController) -> (String) -> Unit = { navController ->
            { appId ->
                navController.navigate("app_details/$appId")
            }
        }
    }

    data object AppDetails : Screen("app_details/{appId}") {
        val navigateBack: (NavController) -> () -> Unit = { navController ->
            { navController.popBackStack() }
        }
    }
}
