package com.artemklymenko.mybankingapp.ui.screens.notifications.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Notification(
    val title: String,
    val description: String,
    val hasSeen: Boolean,
    val image: ImageVector
)
