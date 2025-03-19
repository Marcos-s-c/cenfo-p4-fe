@file:OptIn(ExperimentalMaterial3Api::class)

package com.proyecto4.grantly.registration.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.proyecto4.grantly.registration.model.UserType
import com.proyecto4.grantly.registration.screens.components.UserTypeCard

@Composable
fun UserSelectionScreen(
    onUserTypeSelected: (String) -> Unit, // Callback when a user type is selected
    onBack: () -> Unit                    // Callback for the back button
) {
    val userTypes = listOf(
        UserType.Government,
        UserType.Student,
        UserType.EducationalInstitution
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Title
                Text(
                    text = "How do you want to register?",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                // Registration Options
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    userTypes.forEach { userType ->
                        UserTypeCard(
                            userType = userType,
                            onSelect = {
                                // Construct a route in the form "registration/<USER_TYPE>"
                                val route = "registration/${userType.title.uppercase().replace(" ", "_")}"
                                onUserTypeSelected(route)
                            }
                        )
                    }
                }

                // Contact Text
                Text(
                    text = "Don't identify with any? Contact us",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .clickable { /* Handle contact action */ }
                )
            }
        }
    }
}
