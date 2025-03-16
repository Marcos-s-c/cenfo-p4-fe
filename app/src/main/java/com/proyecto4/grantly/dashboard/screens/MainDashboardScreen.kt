package com.proyecto4.grantly.dashboard.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.outlined.IndeterminateCheckBox
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.proyecto4.grantly.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.proyecto4.grantly.ui.theme.backgroundColor


@Composable
fun MainDashboardScreen() {
    Scaffold(
        containerColor = backgroundColor,
        topBar = { TopBar() },
        bottomBar = { BottomNavBar() }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
        ) {
            // Your screen content goes here
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.White),
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Logo
                Image(
                    painter = painterResource(id = R.drawable.logo2),
                    contentDescription = "Logo",
                    modifier = Modifier.width(65.dp).height(50.dp)
                )

                // Search Bar
                Row(
                    modifier = Modifier
                        .weight(2f)
                        .height(40.dp)
                        .background(Color.LightGray, RoundedCornerShape(12.dp))
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    var searchText by remember { mutableStateOf("") }
                    // Create a FocusRequester to request focus programmatically
                    //val focusRequester = remember { FocusRequester() }
                    // Get a controller to manage the software keyboard
                    //val keyboardController = LocalSoftwareKeyboardController.current

                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                            // When the Box is clicked, request focus for the text field.
                            //.clickable { focusRequester.requestFocus() },
                        contentAlignment = Alignment.CenterStart
                    ) {
                        // Show placeholder when empty
                        if (searchText.isEmpty()) {
                            Text(
                                text = "Buscar...",
                                style = TextStyle(fontSize = 16.sp, color = Color.Gray)
                            )
                        }
                        BasicTextField(
                            value = searchText,
                            onValueChange = { searchText = it },
                            textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                // Attach the focusRequester to the text field
                                //.focusRequester(focusRequester)
                                // Detect focus changes to trigger keyboard display
                                /**.onFocusChanged { focusState ->
                                    if (focusState.isFocused) {
                                        keyboardController?.show()
                                    }
                                }**/
                        )
                    }
                }

                // Message Icon
                Icon(Icons.Filled.Inbox, contentDescription = "Inbox", modifier = Modifier.size(50.dp).padding(start = 12.dp), tint = Color.Black)

            }
        }
    )
}


@Composable
fun BottomNavBar() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        NavigationBarItem(
            icon = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.IndeterminateCheckBox,
                        contentDescription = "Home",
                        modifier = Modifier.size(50.dp), // Removed the extra start padding
                        tint = Color.Black
                    )
                }
            },
            label = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Home")
                }
            },
            selected = false,
            onClick = { /* Handle click */ }
        )

        NavigationBarItem(
            icon = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Language,
                        contentDescription = "Scolarships",
                        modifier = Modifier.size(50.dp),
                        tint = Color.Black
                    )
                }
            },
            label = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Scolarships")
                }
            },
            selected = false,
            onClick = { /* Handle click */ }
        )

        NavigationBarItem(
            icon = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = "Updates",
                        modifier = Modifier.size(50.dp),
                        tint = Color.Black
                    )
                }
            },
            label = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Updates")
                }
            },
            selected = false,
            onClick = { /* Handle click */ }
        )

        NavigationBarItem(
            icon = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Profile",
                        modifier = Modifier.size(50.dp),
                        tint = Color.Black
                    )
                }
            },
            label = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Profile")
                }
            },
            selected = false,
            onClick = { /* Handle click */ }
        )
    }
}

