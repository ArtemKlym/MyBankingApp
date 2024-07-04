package com.artemklymenko.mybankingapp.ui.screens.wallet.data

import androidx.compose.ui.graphics.vector.ImageVector

data class CardHistory(
    val type: String,
    val amountChanged: Double,
    val date: String,
    val time: String,
    val icon: ImageVector
)
