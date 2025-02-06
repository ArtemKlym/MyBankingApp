package com.artemklymenko.mybankingapp.ui.screens.exchange_rate

sealed interface ExchangeRateUiEvent {
    object LoadDefaultExchangeRates: ExchangeRateUiEvent
    data class ChangeExchangeRatesYear(val year: String): ExchangeRateUiEvent
}