package com.proyecto4.grantly.bottomnavbar

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.IndeterminateCheckBox
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person

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
