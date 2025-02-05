package com.artemklymenko.mybankingapp.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.artemklymenko.mybankingapp.ui.screens.home.sections.CardsSection
import com.artemklymenko.mybankingapp.ui.screens.home.sections.CurrenciesSection
import com.artemklymenko.mybankingapp.ui.screens.home.sections.FinanceSection
import com.artemklymenko.mybankingapp.ui.screens.home.sections.WalletSection


@Composable
fun HomeScreen(
    navController: NavHostController,
    state: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit
) {
    LaunchedEffect(Unit) {
        onEvent(HomeUiEvent.LoadCurrencies)
    }

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (state.error != null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Error: ${state.error}",
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                color = Color.Red
            )
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            WalletSection()
            CardsSection()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSection(navController)
            CurrenciesSection(
                currenciesInDepartments = state.currenciesInDepartments,
                currenciesInCards = state.currenciesInCards,
            )
        }
    }
}