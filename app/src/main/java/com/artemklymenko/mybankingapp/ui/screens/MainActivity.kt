package com.artemklymenko.mybankingapp.ui.screens

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.navigation.compose.rememberNavController
import com.artemklymenko.mybankingapp.ui.navigation.BottomNavigationBar
import com.artemklymenko.mybankingapp.data.BottomNavigation
import com.artemklymenko.mybankingapp.ui.theme.MyBankingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MyBankingAppTheme {
                setBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val bottomBarItems = listOf(BottomNavigation.Home, BottomNavigation.Wallet, BottomNavigation.Notifications, BottomNavigation.Profile)
                    BottomNavigationBar(navController, bottomBarItems)
                }
            }
        }
    }

    @Composable
    private fun setBarColor(color: Color) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                val window = (view.context as Activity).window
                window.statusBarColor = color.toArgb()
            }
        }
    }
}

