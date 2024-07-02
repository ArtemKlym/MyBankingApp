package com.artemklymenko.mybankingapp.ui.screens.home.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.SendToMobile
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemklymenko.mybankingapp.data.Finance
import com.artemklymenko.mybankingapp.ui.theme.BlueStart
import com.artemklymenko.mybankingapp.ui.theme.GreenStart
import com.artemklymenko.mybankingapp.ui.theme.OrangeStart
import com.artemklymenko.mybankingapp.ui.theme.PurpleStart

val financeList = listOf(
    Finance(
        icon = Icons.AutoMirrored.Rounded.SendToMobile,
        name = "Mobile top-up",
        backgroundIconContainer = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.Money,
        name = "Charity",
        backgroundIconContainer = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.Analytics,
        name = "Finance\nAnalytics",
        backgroundIconContainer = PurpleStart
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        backgroundIconContainer = GreenStart
    )
)

@Preview
@Composable
fun FinanceSection() {
    Column {
        Text(
            text = "Finance",
            fontSize = 18.sp,
            fontWeight = FontWeight.W600,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyRow {
            items(financeList.size) { index ->
                FinanceItem(index)
            }
        }
    }
}

@Composable
fun FinanceItem(index: Int) {
    val finance = financeList[index]

    var lastItemPaddingEnd = 0.dp
    if (index == financeList.size - 1)
        lastItemPaddingEnd = 16.dp

    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .padding(16.dp)
                .clickable { },
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.backgroundIconContainer)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    modifier = Modifier
                        .size(36.dp)
                        .padding(2.dp),
                    tint = Color.White,
                )
            }
            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}
