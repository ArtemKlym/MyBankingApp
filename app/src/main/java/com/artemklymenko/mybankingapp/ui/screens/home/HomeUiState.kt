package com.artemklymenko.mybankingapp.ui.screens.home

import com.artemklymenko.mybankingapp.ui.screens.home.data.Currency

data class HomeUiState (
    val currenciesInDepartments: List<Currency> = emptyList(),
    val currenciesInCards: List<Currency> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)