package com.proyecto4.grantly.registration.navigation

import ScholarshipCard.ScholarshipCard
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.proyecto4.grantly.bottomnavbar.BottomNavBar
import com.proyecto4.grantly.registration.screens.RegistrationScreen
import com.proyecto4.grantly.registration.screens.UserSelectionScreen
import com.proyecto4.grantly.dashboard.screens.MainDashboardScreen



@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "mainDashboard"
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
        composable("mainDashboard") {
            MainDashboardScreen()
        }
        composable("BottomNavBar") {
            BottomNavBar()
        }
        composable("ScholarshipCard") {
            ScholarshipCard()
        }
    }
}