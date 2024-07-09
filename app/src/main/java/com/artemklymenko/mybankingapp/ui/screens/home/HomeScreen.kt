package com.artemklymenko.mybankingapp.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.artemklymenko.mybankingapp.ui.screens.home.sections.CardsSection
import com.artemklymenko.mybankingapp.ui.screens.home.sections.CurrenciesSection
import com.artemklymenko.mybankingapp.ui.screens.home.sections.FinanceSection
import com.artemklymenko.mybankingapp.ui.screens.home.sections.WalletSection



@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        WalletSection()
        CardsSection()
        Spacer(modifier = Modifier.height(16.dp))
        FinanceSection(navController)
        CurrenciesSection()
    }
}