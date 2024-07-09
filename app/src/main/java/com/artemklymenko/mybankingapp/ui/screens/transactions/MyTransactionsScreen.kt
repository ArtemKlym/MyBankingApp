package com.artemklymenko.mybankingapp.ui.screens.transactions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.artemklymenko.mybankingapp.ui.screens.wallet.sections.CardsHistory

@Composable
fun MyTransactionsScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CardsHistory()
    }
}