package com.proyecto4.grantly.registration.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.proyecto4.grantly.bottomnavbar.BottomNavBar
import com.proyecto4.grantly.dashboard.screens.MainDashboardScreen
import com.proyecto4.grantly.registration.screens.LoginScreen
import com.proyecto4.grantly.registration.screens.RegistrationScreen
import com.proyecto4.grantly.registration.screens.UserSelectionScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("userSelection") {
            UserSelectionScreen(navController = navController)
        }
        composable("registration/{userType}") { backStackEntry ->
            RegistrationScreen(
                navController = navController, // Add this parameter
                userType = backStackEntry.arguments?.getString("userType")
            )
        }
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("mainDashboard") {
            MainDashboardScreen()
        }
        composable("BottomNavBar") {
            BottomNavBar()
        }
    }
}