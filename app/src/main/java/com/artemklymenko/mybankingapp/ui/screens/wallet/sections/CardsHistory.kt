package com.artemklymenko.mybankingapp.ui.screens.wallet.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalGroceryStore
import androidx.compose.material.icons.outlined.LocalTaxi
import androidx.compose.material.icons.outlined.Money
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemklymenko.mybankingapp.data.CardHistory
import com.artemklymenko.mybankingapp.ui.theme.GreenStart
import kotlin.math.abs

val cardHistory = listOf(
    CardHistory(
        type = "Grocery",
        amountChanged = -24.32,
        date = "July 02",
        time = "12:31",
        icon = Icons.Outlined.LocalGroceryStore
    ),
    CardHistory(
        type = "Taxi",
        amountChanged = -24.32,
        date = "July 01",
        time = "19:31",
        icon = Icons.Outlined.LocalTaxi
    ),
    CardHistory(
        type = "Entertainment",
        amountChanged = -67.32,
        date = "July 01",
        time = "10:23",
        icon = Icons.Outlined.MusicNote
    ),
    CardHistory(
        type = "Salary",
        amountChanged = 550.00,
        date = "June 30",
        time = "9:15",
        icon = Icons.Outlined.Money
    ),
    CardHistory(
        type = "Internet",
        amountChanged = -8.00,
        date = "June 29",
        time = "20:17",
        icon = Icons.Outlined.Wifi
    ),
    CardHistory(
        type = "Mobile top-up",
        amountChanged = -4.32,
        date = "June 29",
        time = "20:04",
        icon = Icons.Outlined.Phone
    ),
)

@Composable
fun CardsHistory() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp),
        text = "History",
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily.SansSerif,
        color = MaterialTheme.colorScheme.onBackground
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)

    ) {
        LazyColumn {
            items(cardHistory) { operation ->
                HistoryItem(operation)
            }
        }
    }

}

@Composable
fun HistoryItem(operation: CardHistory) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(top = 16.dp, start = 8.dp, end = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.background),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Icon(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .size(40.dp),
                imageVector = operation.icon,
                contentDescription = operation.type
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = operation.type,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                    Text(
                        text = if (operation.amountChanged > 0) {
                            "+ $${operation.amountChanged}"
                        } else {
                            "- $${abs(operation.amountChanged)}"
                        },
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600,
                        color = if (operation.amountChanged > 0) {
                            GreenStart
                        } else {
                            Color.Red
                        }
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = operation.date,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.LightGray
                    )

                    Text(
                        text = operation.time,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.LightGray
                    )
                }
            }
        }
    }
}
