package com.artemklymenko.mybankingapp.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artemklymenko.mybankingapp.ui.screens.exchange_rate.ExchangeRateScreen
import com.artemklymenko.mybankingapp.ui.screens.exchange_rate.ExchangeRateViewModel
import com.artemklymenko.mybankingapp.ui.theme.MyBankingAppTheme

class ExchangeRateActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            MyBankingAppTheme {
                Scaffold {
                    val viewModel: ExchangeRateViewModel = viewModel()
                    val state by viewModel.state.collectAsState()
                    ExchangeRateScreen(
                        modifier = Modifier.padding(it),
                        state = state,
                        onEvent = viewModel::onEvent
                    )
                }
            }
        }
    }
}