package com.artemklymenko.mybankingapp.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigation(
    val title: String,
    val icon: ImageVector,
    val unselected: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
) {
    object Home : BottomNavigation(
        title = "Home",
        icon = Icons.Filled.Home,
        unselected = Icons.Outlined.Home,
        hasNews = false,
    )

    object Wallet : BottomNavigation(
        title = "Wallet",
        icon = Icons.Filled.AccountBalanceWallet,
        unselected = Icons.Outlined.AccountBalanceWallet,
        hasNews = false
    )

    object Notifications : BottomNavigation(
        title = "Notifications",
        icon = Icons.Filled.Notifications,
        unselected = Icons.Outlined.Notifications,
        hasNews = true,
        badgeCount = 3
    )

    object Profile : BottomNavigation(
        title = "Profile",
        icon = Icons.Filled.AccountCircle,
        unselected = Icons.Outlined.AccountCircle,
        hasNews = true
    )
}