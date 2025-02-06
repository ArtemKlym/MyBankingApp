package com.artemklymenko.mybankingapp.ui.screens.exchange_rate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemklymenko.mybankingapp.core.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ExchangeRateViewModel : ViewModel() {

    private val _state = MutableStateFlow(ExchangeRateUiState())
    val state = _state

    fun onEvent(uiEvent: ExchangeRateUiEvent) {
        when (uiEvent) {
            is ExchangeRateUiEvent.LoadDefaultExchangeRates -> loadDefaultExchangeRates()
            is ExchangeRateUiEvent.ChangeExchangeRatesYear -> changeExchangeRatesYear(uiEvent.year)
        }
    }

    private fun changeExchangeRatesYear(year: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, selectedYear = year) }
            try {
                val response = RetrofitInstance.api.getExchangeRates("01.12.$year")
                if (response.isSuccessful) {
                    _state.update { it.copy(exchangeRate = response.body(), isLoading = false) }
                }
            } catch (e: IOException) {
                _state.update { it.copy(error = e.message, isLoading = false) }
            } catch (e: HttpException) {
                _state.update { it.copy(error = e.message, isLoading = false) }
            }
        }
    }

    private fun loadDefaultExchangeRates() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                val response = RetrofitInstance.api.getExchangeRates("01.12.2014")
                if (response.isSuccessful) {
                    response.body().let { exchangeRate ->
                        _state.update { it.copy(exchangeRate = exchangeRate, isLoading = false) }
                    }
                }
            } catch (e: IOException) {
                _state.update {
                    it.copy(
                        error = e.message,
                        isLoading = false
                    )
                }
            } catch (e: HttpException) {
                _state.update {
                    it.copy(
                        error = e.message,
                        isLoading = false
                    )
                }
            }
        }
    }
}
