package io.orazzu.android_course.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.orazzu.android_course.repository.AppRepository
import io.orazzu.android_course.repository.local.AppLocalRepository
import io.orazzu.android_course.ui.screens.AppDetailsScreen
import io.orazzu.android_course.ui.screens.AppListScreen
import io.orazzu.android_course.ui.theme.AndroidCourseTheme

class MainActivity(
    private val appRepository: AppRepository = AppLocalRepository(),
) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCourseTheme {
                val navController = rememberNavController()
                val apps = appRepository.getApps()

                NavHost(
                    navController = navController,
                    startDestination = "app_list",
                ) {
                    composable("app_list") {
                        AppListScreen(
                            apps = apps,
                            onAppClick = { appId ->
                                navController.navigate("app_details/$appId")
                            },
                        )
                    }

                    composable("app_details/{appId}") { backStackEntry ->
                        val appId = backStackEntry.arguments?.getString("appId")
                        val app = apps.first { it.id == appId }

                        AppDetailsScreen(
                            app = app,
                            onBackClick = { navController.popBackStack() },
                        )
                    }
                }
            }
        }
    }
}
