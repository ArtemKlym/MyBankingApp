package com.artemklymenko.mybankingapp.ui.screens.exchange_rate.domain

data class ExchangeRate(
    val bank: String,
    val baseCurrency: Int,
    val baseCurrencyLit: String,
    val date: String,
    val exchangeRate: List<ExchangeRateX>
)