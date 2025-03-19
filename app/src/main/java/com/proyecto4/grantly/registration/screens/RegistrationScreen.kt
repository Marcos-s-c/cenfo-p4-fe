@file:OptIn(ExperimentalMaterial3Api::class)

package com.proyecto4.grantly.registration.screens

import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.proyecto4.grantly.R
import com.proyecto4.grantly.ui.theme.Cenfop4feTheme

@Composable
fun RegistrationScreen(
    userType: String?,
    onBack: () -> Unit,
    onRegistrationSuccess: () -> Unit
) {
    Cenfop4feTheme {
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
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // App Logo
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .size(120.dp)
                        .padding(vertical = 32.dp)
                )

                Text(
                    text = "Create Account",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                when (userType?.uppercase()) {
                    "GOVERNMENT" -> GovernmentRegistrationForm(onRegistrationSuccess)
                    "STUDENT" -> StudentRegistrationForm(onRegistrationSuccess)
                    "EDUCATIONAL_INSTITUTION" -> InstitutionRegistrationForm(onRegistrationSuccess)
                    else -> ErrorScreen()
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Sign In Prompt
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
private fun GovernmentRegistrationForm(onRegistrationSuccess: () -> Unit) {
    var agencyName by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        FormTextField("Agency Name", agencyName) { agencyName = it }
        FormTextField("Department", department) { department = it }
        FormTextField("Country", country) { country = it }
        FormTextField("Email", email) { email = it }
        FormTextField("Phone Number", phone, KeyboardOptions(keyboardType = KeyboardType.Phone)) { phone = it }

        SubmitButton("Register Agency") {
            // Handle registration then navigate to the dashboard
            onRegistrationSuccess()
        }
    }
}

@Composable
private fun StudentRegistrationForm(onRegistrationSuccess: () -> Unit) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var degree by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        FormTextField("Full Name", fullName) { fullName = it }
        FormTextField("Email", email) { email = it }
        FormTextField("Phone Number", phone, KeyboardOptions(keyboardType = KeyboardType.Phone)) { phone = it }
        FormTextField(
            label = "Password",
            value = password,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        ) { password = it }
        FormTextField("Age", age, KeyboardOptions(keyboardType = KeyboardType.Number)) { age = it }
        FormTextField("Current Degree", degree) { degree = it }
        FormTextField("Location", location) { location = it }

        SubmitButton("Create Account") {
            // Handle registration then navigate to the dashboard
            onRegistrationSuccess()
        }
    }
}

@Composable
private fun InstitutionRegistrationForm(onRegistrationSuccess: () -> Unit) {
    var institutionName by remember { mutableStateOf("") }
    var institutionType by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        FormTextField("Institution Name", institutionName) { institutionName = it }
        FormTextField("Institution Type", institutionType) { institutionType = it }
        FormTextField("Address", address) { address = it }
        FormTextField("Email", email) { email = it }
        FormTextField("Phone Number", phone, KeyboardOptions(keyboardType = KeyboardType.Phone)) { phone = it }

        SubmitButton("Register Institution") {
            // Handle registration then navigate to the dashboard
            onRegistrationSuccess()
        }
    }
}

@Composable
private fun FormTextField(
    label: String,
    value: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation
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

@Composable
private fun ErrorScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Invalid registration type",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}
