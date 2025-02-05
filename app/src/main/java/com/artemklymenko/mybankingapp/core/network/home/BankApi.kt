package com.artemklymenko.mybankingapp.core.network.home

import com.artemklymenko.mybankingapp.ui.screens.home.data.Currency
import com.artemklymenko.mybankingapp.ui.screens.home.data.ExchangeRate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BankApi {
    @GET("/p24api/pubinfo?exchange&coursid=5")
    suspend fun getCurrenciesInDepartments(): Response<List<Currency>>

    @GET("/p24api/pubinfo?exchange&coursid=11")
    suspend fun getCurrenciesInCards(): Response<List<Currency>>


}