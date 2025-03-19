@file:OptIn(ExperimentalMaterial3Api::class)

package com.proyecto4.grantly.scholarships.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.proyecto4.grantly.R
import com.proyecto4.grantly.ui.theme.Cenfop4feTheme

@Composable
fun ScholarshipsRegistration(
    onBack: () -> Unit,
    onApplicationRegistrationSuccess: () -> Unit
) {
    Cenfop4feTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Create Scholarship") },
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
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Optional: App Logo for consistency
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .size(120.dp)
                        .padding(vertical = 32.dp)
                )

                Text(
                    text = "Register Application",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                // Input fields for the application registration.
                // Note: Fields like "id", "postedByUserId", "createdAt", and "updatedAt" are usually managed server-side.
                var title by remember { mutableStateOf("") }
                var description by remember { mutableStateOf("") }
                var level by remember { mutableStateOf("") }
                var requirements by remember { mutableStateOf("") } // Comma-separated list
                var location by remember { mutableStateOf("") }
                var tags by remember { mutableStateOf("") }         // Comma-separated list

                FormTextField(label = "Title", value = title, onValueChange = { title = it })
                Spacer(modifier = Modifier.height(8.dp))
                FormTextField(label = "Description", value = description, onValueChange = { description = it })
                Spacer(modifier = Modifier.height(8.dp))
                FormTextField(label = "Level", value = level, onValueChange = { level = it })
                Spacer(modifier = Modifier.height(8.dp))
                FormTextField(
                    label = "Requirements (comma separated)",
                    value = requirements,
                    onValueChange = { requirements = it },
                    keyboardOptions = KeyboardOptions.Default
                )
                Spacer(modifier = Modifier.height(8.dp))
                FormTextField(label = "Location", value = location, onValueChange = { location = it })
                Spacer(modifier = Modifier.height(8.dp))
                FormTextField(
                    label = "Tags (comma separated)",
                    value = tags,
                    onValueChange = { tags = it },
                    keyboardOptions = KeyboardOptions.Default
                )
                Spacer(modifier = Modifier.height(16.dp))

                SubmitButton(text = "Create") {
                    // Here, you could create your JSON payload using the input values.
                    // For example, you might build a data class instance and serialize it.
                    // Once done, call onApplicationRegistrationSuccess() to navigate to the dashboard.
                    onApplicationRegistrationSuccess()
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Optional: Sign In Prompt (if applicable)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text("Already have an account? ")
                    Text(
                        text = "Sign In",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { onBack() }
                    )
                }
            }
        }
    }
}

@Composable
private fun FormTextField(
    label: String,
    value: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyboardOptions
    )
}

@Composable
private fun SubmitButton(text: String, onSubmit: () -> Unit) {
    Button(
        onClick = onSubmit,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        )
    ) {
        Text(text)
    }
}
