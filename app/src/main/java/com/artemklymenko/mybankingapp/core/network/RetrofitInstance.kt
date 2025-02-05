package com.artemklymenko.mybankingapp.core.network

import com.artemklymenko.mybankingapp.core.network.home.BankApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.privatbank.ua/"

    val api: BankApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BankApi::class.java)
    }
}