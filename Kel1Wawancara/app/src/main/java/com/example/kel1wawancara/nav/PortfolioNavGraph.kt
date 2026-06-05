package com.example.kel1wawancara.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kel1wawancara.screen.SplashScreen
import com.example.kel1wawancara.screen.DashboardScreen
import com.example.kel1wawancara.screen.DetailScreen

@Composable
fun PortfolioApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(onNavigateToDashboard = {

                navController.navigate("dashboard") {
                    popUpTo("splash") { inclusive = true }
                }
            })
        }
        composable("dashboard") {
            DashboardScreen(onItemClick = { itemId ->
                navController.navigate("detail/$itemId")
            })
        }
        composable(
            route = "detail/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: return@composable
            DetailScreen(itemId = itemId, onNavigateBack = { navController.popBackStack() })
        }
    }
}