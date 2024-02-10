package com.criticalay.khabar.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.criticalay.khabar.data.model.khabar.Destination
import com.criticalay.khabar.ui.home.HomeScreen
import com.criticalay.khabar.ui.settings.Settings

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = Destination.Home.path
    ) {
        composable(route = Destination.Settings.path) {
            Settings {
                navController.navigate(Destination.Home.path) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = false
                    }
                    launchSingleTop = true
                }
            }
        }
        composable(route = Destination.Home.path) {
            HomeScreen {
                navController.navigate(Destination.Settings.path)
            }
        }
    }
}