package com.proyecto4.grantly.registration.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.proyecto4.grantly.registration.model.UserType
import com.proyecto4.grantly.registration.screens.components.UserTypeCard


@Composable
fun UserSelectionScreen(navController: NavController) {
    val userTypes = listOf(
        UserType.Government,
        UserType.Student,
        UserType.EducationalInstitution
    )

    Scaffold { innerPadding ->
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
                                navController.navigate("registration/${userType.title.uppercase().replace(" ", "_")}")
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
                        .clickable { /* Handle contact */ }
                )
            }
        }
    }
}