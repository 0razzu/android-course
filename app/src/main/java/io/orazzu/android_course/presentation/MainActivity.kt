package io.orazzu.android_course.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.orazzu.android_course.presentation.routes.AppDetailsRoute
import io.orazzu.android_course.presentation.routes.AppListRoute
import io.orazzu.android_course.presentation.theme.AndroidCourseTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCourseTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "app_list",
                ) {
                    composable("app_list") {
                        AppListRoute(
                            onAppClick = { appId ->
                                navController.navigate("app_details/$appId")
                            },
                        )
                    }

                    composable("app_details/{appId}") { backStackEntry ->
                        AppDetailsRoute(
                            onBackClick = {
                                navController.popBackStack(
                                    route = "app_list",
                                    inclusive = false,
                                    saveState = false,
                                )
                            },
                        )
                    }
                }
            }
        }
    }
}
