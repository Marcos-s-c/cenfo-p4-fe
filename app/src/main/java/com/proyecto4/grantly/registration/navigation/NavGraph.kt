package com.proyecto4.grantly.registration.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.proyecto4.grantly.dashboard.screens.MainDashboardScreen
import com.proyecto4.grantly.registration.screens.LoginScreen
import com.proyecto4.grantly.registration.screens.RegistrationScreen
import com.proyecto4.grantly.registration.screens.UserSelectionScreen

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
                onUserTypeSelected = { route ->
                    // route should be built in the UserSelectionScreen as "registration/<USER_TYPE>"
                    navController.navigate(route)
                },
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
            MainDashboardScreen()
        }
    }
}
