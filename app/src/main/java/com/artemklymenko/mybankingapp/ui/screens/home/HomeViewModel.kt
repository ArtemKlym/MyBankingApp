package com.artemklymenko.mybankingapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemklymenko.mybankingapp.core.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class HomeViewModel : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state
        .onStart {
            loadCurrencies()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            HomeUiState()
        )

    fun onEvent(uiEvent: HomeUiEvent){
        when(uiEvent){
            HomeUiEvent.LoadCurrencies -> loadCurrencies()
        }
    }



    private fun loadCurrencies() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                val currenciesInDepartments = RetrofitInstance.api.getCurrenciesInDepartments()
                val currenciesInCards = RetrofitInstance.api.getCurrenciesInCards()

                if(currenciesInDepartments.isSuccessful && currenciesInCards.isSuccessful) {
                    val departments = currenciesInDepartments.body()
                    val cards = currenciesInCards.body()

                    if(departments != null && cards != null) {
                        _state.update {
                            it.copy(
                                currenciesInDepartments = departments,
                                currenciesInCards = cards,
                                isLoading = false
                            )
                        }
                    }
                } else {
                    _state.update { it.copy(error = "Something went wrong", isLoading = false) }
                }
            } catch (e: IOException) {
                _state.update { it.copy(error = e.message, isLoading = false) }
            } catch (e: HttpException) {
                _state.update { it.copy(error = e.message, isLoading = false) }
            }
        }
    }
}