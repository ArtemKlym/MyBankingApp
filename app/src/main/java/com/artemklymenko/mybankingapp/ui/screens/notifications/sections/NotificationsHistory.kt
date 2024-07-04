package com.artemklymenko.mybankingapp.ui.screens.notifications.sections

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.LocalGroceryStore
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemklymenko.mybankingapp.ui.screens.notifications.data.Notification
import com.artemklymenko.mybankingapp.ui.theme.BlueStart

val notificationsList = listOf(
    Notification(
        title = "Promotion",
        description = "When purchasing goods in the MyStore using a Business card, receive 2.5% cashback.",
        hasSeen = false,
        image = Icons.Outlined.LocalGroceryStore
    ),
    Notification(
        title = "Promotion",
        description = "When purchasing goods in the MyWheelStore using a Business card, receive 1.5% cashback.",
        hasSeen = false,
        image = Icons.Outlined.LocalGroceryStore
    ),
    Notification(
        title = "Take part in the nokia 3310 raffle",
        description = "To participate, you need to top up your phone with more than \$5, the higher the amount topped up, the greater the chance to win.",
        hasSeen = false,
        image = Icons.Outlined.Phone
    ),
    Notification(
        title = "Promotion",
        description = "When purchasing goods in the My Store using a Business card, receive 2.5% cashback.",
        hasSeen = true,
        image = Icons.Outlined.LocalGroceryStore
    ),
    Notification(
        title = "Deposit",
        description = "The deposit rate was changed from 14% to 12.5% per annum.",
        hasSeen = true,
        image = Icons.Outlined.LocalGroceryStore
    ),
)

@Composable
fun NotificationsHistory() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
    ) {
        LazyColumn {
            items(notificationsList) { notification ->
                ExpandableCard(notification)
            }
        }
    }
}

@Composable
fun ExpandableCard(
    notification: Notification
) {
    var expandedState by remember {
        mutableStateOf(false)
    }
    var hasSeen by remember {
        mutableStateOf(notification.hasSeen)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .animateContentSize(
                animationSpec = TweenSpec(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing))
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                hasSeen = true
                expandedState = !expandedState
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = notification.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(0.3f)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                        hasSeen = true
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow"
                    )
                }
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(
                            if (hasSeen) {
                                Color.Transparent
                            } else BlueStart
                        )
                )
            }
            if (expandedState) {
                Text(
                    text = notification.description,
                    fontSize = 14.sp,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
