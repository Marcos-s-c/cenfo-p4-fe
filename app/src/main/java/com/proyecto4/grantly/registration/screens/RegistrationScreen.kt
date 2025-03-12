package com.proyecto4.grantly.registration.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.proyecto4.grantly.ui.theme.Cenfop4feTheme
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController: NavController, userType: String?) {
    Cenfop4feTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Register as ${userType?.replace("_", " ")}") },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            BackHandler {
                navController.popBackStack()
            }

            when (userType) {
                "GOVERNMENT" -> GovernmentRegistrationForm(innerPadding, navController)
                "STUDENT" -> StudentRegistrationForm(innerPadding, navController)
                "EDUCATIONAL_INSTITUTION" -> InstitutionRegistrationForm(innerPadding, navController)
                else -> ErrorScreen(innerPadding)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GovernmentRegistrationForm(padding: PaddingValues, navController: NavController) {
    var agencyName by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    RegistrationFormTemplate(padding) {
        // Common Fields
        FormTextField("Agency Name", agencyName) { agencyName = it }
        FormTextField("Email", email) { email = it }
        FormTextField("Phone Number", phone) { phone = it }

        // Government Specific
        FormTextField("Department", department) { department = it }
        FormTextField("Country", country) { country = it }

        SubmitButton("Register Agency") {
            // Create government user object
            navController.popBackStack()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun StudentRegistrationForm(padding: PaddingValues, navController: NavController) {
    var fullName by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var parentName by remember { mutableStateOf("") }
    var level by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    RegistrationFormTemplate(padding) {
        // Common Fields
        FormTextField("Full Name", fullName) { fullName = it }
        FormTextField("Email", email) { email = it }
        FormTextField("Phone Number", phone) { phone = it }

        // Student Specific
        FormTextField("Birth Date (YYYY-MM-DD)", birthDate) { birthDate = it }
        FormTextField("Education Level", level) { level = it }
        FormTextField("Parent/Guardian Name", parentName) { parentName = it }

        SubmitButton("Register Student") {
            // Create student user object
            navController.popBackStack()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InstitutionRegistrationForm(padding: PaddingValues, navController: NavController) {
    var institutionName by remember { mutableStateOf("") }
    var institutionType by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    RegistrationFormTemplate(padding) {
        // Common Fields
        FormTextField("Institution Name", institutionName) { institutionName = it }
        FormTextField("Email", email) { email = it }
        FormTextField("Phone Number", phone) { phone = it }

        // Institution Specific
        FormTextField("Institution Type", institutionType) { institutionType = it }
        FormTextField("Address", address) { address = it }

        SubmitButton("Register Institution") {
            // Create institution user object
            navController.popBackStack()
        }
    }
}

// Reusable Components
@Composable
private fun FormTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun RegistrationFormTemplate(
    paddingValues: PaddingValues,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        content()
    }
}

@Composable
private fun SubmitButton(text: String, onSubmit: () -> Unit) {
    Spacer(modifier = Modifier.height(24.dp))
    Button(
        onClick = onSubmit,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text)
    }
}

@Composable
private fun ErrorScreen(padding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Invalid registration type selected",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.error
        )
    }
}