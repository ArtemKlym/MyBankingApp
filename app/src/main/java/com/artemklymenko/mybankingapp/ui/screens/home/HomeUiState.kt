package com.artemklymenko.mybankingapp.ui.screens.home

import com.artemklymenko.mybankingapp.ui.screens.home.data.Currency
import com.artemklymenko.mybankingapp.ui.screens.home.data.ExchangeRate

data class HomeUiState (
    val currenciesInDepartments: List<Currency> = emptyList(),
    val currenciesInCards: List<Currency> = emptyList(),
    val exchangeRates: List<ExchangeRate> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)