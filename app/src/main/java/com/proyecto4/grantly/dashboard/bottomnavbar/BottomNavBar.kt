package com.proyecto4.grantly.dashboard.bottomnavbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.IndeterminateCheckBox
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavBar(
    onHomeClick: () -> Unit,
    onScholarshipsClick: () -> Unit,
    onUpdatesClick: () -> Unit,
    onProfileClick: () -> Unit
) {
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
                        modifier = Modifier.size(50.dp),
                        tint = Color.Black
                    )
                }
            },
            label = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text("Home")
                }
            },
            selected = false,
            onClick = onHomeClick
        )

        NavigationBarItem(
            icon = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Outlined.Language,
                        contentDescription = "Scholarships",
                        modifier = Modifier.size(50.dp),
                        tint = Color.Black
                    )
                }
            },
            label = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text("Scholarships")
                }
            },
            selected = false,
            onClick = onScholarshipsClick
        )

        NavigationBarItem(
            icon = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = "Updates",
                        modifier = Modifier.size(50.dp),
                        tint = Color.Black
                    )
                }
            },
            label = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text("Updates")
                }
            },
            selected = false,
            onClick = onUpdatesClick
        )

        NavigationBarItem(
            icon = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Profile",
                        modifier = Modifier.size(50.dp),
                        tint = Color.Black
                    )
                }
            },
            label = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text("Profile")
                }
            },
            selected = false,
            onClick = onProfileClick
        )
    }
}
