package com.proyecto4.grantly.registration.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.proyecto4.grantly.dashboard.screens.MainDashboardScreen
import com.proyecto4.grantly.registration.screens.LoginScreen
import com.proyecto4.grantly.registration.screens.RegistrationScreen
import com.proyecto4.grantly.registration.screens.UserSelectionScreen
import com.proyecto4.grantly.scholarships.screens.ScholarshipsRegistration

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onSignInSuccess = { navController.navigate("dashboard") },
                onNavigateToUserSelection = { navController.navigate("userSelection") }
            )
        }
        composable("userSelection") {
            UserSelectionScreen(
                onUserTypeSelected = { route -> navController.navigate(route) },
                onBack = { navController.popBackStack() }
            )
        }
        composable("registration/{userType}") { backStackEntry ->
            val userType = backStackEntry.arguments?.getString("userType")
            RegistrationScreen(
                userType = userType,
                onBack = { navController.popBackStack() },
                onRegistrationSuccess = { navController.navigate("dashboard") }
            )
        }
        composable("dashboard") {
            MainDashboardScreen(
                onHomeClick = { navController.navigate("dashboard") },
                onScholarshipsClick = { navController.navigate("scholarships") },
                onUpdatesClick = { /* Implement updates navigation if needed */ },
                onProfileClick = { /* Implement profile navigation if needed */ }
            )
        }
        composable("scholarships") {
            ScholarshipsRegistration(
                onBack = { navController.navigate("dashboard") },
                onApplicationRegistrationSuccess = { navController.navigate("dashboard") }
            )
        }
    }
}