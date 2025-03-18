package com.proyecto4.grantly.dashboard.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.proyecto4.grantly.bottomnavbar.BottomNavBar
import com.proyecto4.grantly.topnavbar.TopBar
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

