package com.proyecto4.grantly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.proyecto4.grantly.dashboard.screens.MainDashboardScreen
import com.proyecto4.grantly.registration.screens.LoginScreen
import com.proyecto4.grantly.registration.screens.RegistrationScreen
import com.proyecto4.grantly.registration.screens.UserSelectionScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Use a mutable state variable to track which screen to display.
                // Possible values: "Login", "UserSelection", "Dashboard", or "registration/<USER_TYPE>"
                var currentScreen by remember { mutableStateOf("Login") }

                when {
                    currentScreen == "Login" -> {
                        LoginScreen(
                            onSignInSuccess = { currentScreen = "Dashboard" },
                            onNavigateToUserSelection = { currentScreen = "UserSelection" }
                        )
                    }
                    currentScreen == "UserSelection" -> {
                        UserSelectionScreen(
                            onUserTypeSelected = { route ->
                                // Route is built in UserSelectionScreen, e.g. "registration/GOVERNMENT"
                                currentScreen = route
                            },
                            onBack = { currentScreen = "Login" }
                        )
                    }
                    currentScreen.startsWith("registration/") -> {
                        val userType = currentScreen.removePrefix("registration/")
                        RegistrationScreen(
                            userType = userType,
                            onBack = { currentScreen = "UserSelection" },
                            onRegistrationSuccess = { currentScreen = "Dashboard" }
                        )
                    }
                    currentScreen == "Dashboard" -> {
                        MainDashboardScreen()
                    }
                }
            }
        }
    }
}
