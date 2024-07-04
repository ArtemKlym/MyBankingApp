package com.artemklymenko.mybankingapp.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.artemklymenko.mybankingapp.ui.screens.home.sections.CardsSection
import com.artemklymenko.mybankingapp.ui.screens.profile.sections.CardRow
import com.artemklymenko.mybankingapp.ui.screens.profile.sections.FinanceOverview
import com.artemklymenko.mybankingapp.ui.screens.profile.sections.UserSection

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        UserSection()
        Spacer(modifier = Modifier.height(8.dp))
        FinanceOverview()
        Spacer(modifier = Modifier.height(16.dp))
        CardRow()
        CardsSection()
    }
}