package com.artemklymenko.mybankingapp.core.network

import com.artemklymenko.mybankingapp.ui.screens.home.data.Currency
import com.artemklymenko.mybankingapp.ui.screens.exchange_rate.domain.ExchangeRate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BankApi {
    @GET("/p24api/pubinfo?exchange&coursid=5")
    suspend fun getCurrenciesInDepartments(): Response<List<Currency>>

    @GET("/p24api/pubinfo?exchange&coursid=11")
    suspend fun getCurrenciesInCards(): Response<List<Currency>>

    @GET("/p24api/exchange_rates?")
    suspend fun getExchangeRates(@Query("date") date:String): Response<ExchangeRate>
}