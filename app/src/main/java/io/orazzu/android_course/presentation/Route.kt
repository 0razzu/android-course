package io.orazzu.android_course.presentation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

sealed class Route(val route: String) {
    data object AppList : Route("app_list") {
        val navigateToAppDetails: (NavController) -> (String) -> Unit = { navController ->
            { appId ->
                navController.navigate("app_details/$appId")
            }
        }
    }

    data object AppDetails : Route("app_details/{appId}") {
        val appId: (NavBackStackEntry) -> String? = { it.arguments?.getString("appId") }
        val navigateBack: (NavController) -> () -> Unit = { navController ->
            {
                navController.popBackStack(route = "app_list", inclusive = false, saveState = false)
            }
        }
    }
}
