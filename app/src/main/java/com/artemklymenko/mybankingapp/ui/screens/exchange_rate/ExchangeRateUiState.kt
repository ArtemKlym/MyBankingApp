package com.artemklymenko.mybankingapp.ui.screens.exchange_rate

import com.artemklymenko.mybankingapp.ui.screens.exchange_rate.domain.ExchangeRate

data class ExchangeRateUiState(
    val exchangeRate: ExchangeRate? = null,
    val selectedYear: String = "2014",
    val isLoading: Boolean = false,
    val error: String? = null
)
