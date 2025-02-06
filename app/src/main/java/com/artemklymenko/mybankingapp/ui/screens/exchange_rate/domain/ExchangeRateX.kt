package com.artemklymenko.mybankingapp.ui.screens.exchange_rate.domain

data class ExchangeRateX(
    val baseCurrency: String,
    val currency: String,
    val purchaseRate: Double,
    val purchaseRateNB: Double,
    val saleRate: Double,
    val saleRateNB: Double
)