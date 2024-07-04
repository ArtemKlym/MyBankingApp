package com.artemklymenko.mybankingapp.ui.screens.profile.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.PriceCheck
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemklymenko.mybankingapp.ui.screens.profile.data.FinanceItem
import com.artemklymenko.mybankingapp.ui.theme.BlueStart

val financeItemList = listOf(
    FinanceItem(
        title = "My Balance",
        amount = 567.43,
        icon = Icons.Filled.Balance
    ),
    FinanceItem(
        title = "Income",
        amount = 550.00,
        icon = Icons.Filled.Money
    ),
    FinanceItem(
        title = "Expense",
        amount = 429.32,
        icon = Icons.Filled.PriceCheck
    ),
    FinanceItem(
        title = "Total Saving",
        amount = 2104.65,
        icon = Icons.Filled.Savings
    ),
)

@Composable
fun FinanceOverview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 0..1)
                    CardItem(financeItemList[i])
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 2..3)
                    CardItem(financeItemList[i])
            }
        }
    }
}

@Composable
private fun CardItem(financeItem: FinanceItem) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.background),

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
                    .padding(2.dp),
                imageVector = financeItem.icon,
                contentDescription = financeItem.title,
                tint = BlueStart
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = financeItem.title,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W600,
                    color = if(isSystemInDarkTheme()){
                        Color.LightGray
                    }else Color.DarkGray
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "$${financeItem.amount}",
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = BlueStart
                )
            }
        }
    }
}