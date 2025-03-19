package com.proyecto4.grantly.dashboard.screens

import ScholarshipCard.ScholarshipCard
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.proyecto4.grantly.dashboard.bottomnavbar.BottomNavBar
import com.proyecto4.grantly.dashboard.topnavbar.TopBar
import com.proyecto4.grantly.ui.theme.backgroundColor

@Composable
fun MainDashboardScreen(
    onHomeClick: () -> Unit,
    onScholarshipsClick: () -> Unit,
    onUpdatesClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Scaffold(
        containerColor = backgroundColor,
        topBar = { TopBar() },
        bottomBar = {
            BottomNavBar(
                onHomeClick = onHomeClick,
                onScholarshipsClick = onScholarshipsClick,
                onUpdatesClick = onUpdatesClick,
                onProfileClick = onProfileClick
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                ScholarshipCard()
            }
            // Additional dashboard content can be placed here
        }
    }
}
