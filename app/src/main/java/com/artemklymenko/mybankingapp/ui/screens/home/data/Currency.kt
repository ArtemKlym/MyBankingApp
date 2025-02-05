package com.artemklymenko.mybankingapp.ui.screens.home.data

import com.google.gson.annotations.SerializedName
import java.math.RoundingMode

data class Currency(
    val ccy: String,
    @SerializedName("base_ccy")
    val baseCcy: String,
    val buy: String,
    val sale: String
)

fun String.toFloatWithTwoDecimals(): Float {
    return this.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toFloat()
}
