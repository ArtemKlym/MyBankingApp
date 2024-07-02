package com.artemklymenko.mybankingapp.ui.screens.home.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemklymenko.mybankingapp.R
import com.artemklymenko.mybankingapp.data.Card
import com.artemklymenko.mybankingapp.ui.theme.BlueEnd
import com.artemklymenko.mybankingapp.ui.theme.BlueStart
import com.artemklymenko.mybankingapp.ui.theme.GreenEnd
import com.artemklymenko.mybankingapp.ui.theme.GreenStart
import com.artemklymenko.mybankingapp.ui.theme.OrangeEnd
import com.artemklymenko.mybankingapp.ui.theme.OrangeStart
import com.artemklymenko.mybankingapp.ui.theme.PurpleEnd
import com.artemklymenko.mybankingapp.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "1233 2321 3213 3214",
        cardName = "Business",
        cardBalance = 46.345,
        cardColor = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "3312 2123 1332 1432",
        cardName = "Savings",
        cardBalance = 23.754,
        cardColor = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "1323 2231 3123 3214",
        cardName = "Deposit",
        cardBalance = 543.323,
        cardColor = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "1221 2333 3214 3213",
        cardName = "Debit",
        cardBalance = 36.435,
        cardColor = getGradient(GreenStart, GreenEnd)
    ),
)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}


@Preview
@Composable
fun CardsSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(cards[index], index)
        }
    }
}

@Composable
fun CardItem(card: Card, index: Int) {
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD")
        image = painterResource(id = R.drawable.ic_mastercard)

    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(card.cardColor)
                .width(250.dp)
                .height(150.dp)
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .clickable { },
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = image,
                contentDescription = card.cardType,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = card.cardName,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "$ ${card.cardBalance}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            ShowTextWithToggle(fullText = card.cardNumber)
        }
    }
}


@Composable
fun ShowTextWithToggle(fullText: String) {
    var showFullText by remember { mutableStateOf(false) }
    val displayedText = if (showFullText) {
        fullText
    } else {
        if (fullText.length >= 8) {
            fullText.take(4)+ " **** **** " + fullText.takeLast(4)
        } else {
            fullText
        }
    }

    Text(
        text = displayedText,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        modifier = Modifier
            .clickable { showFullText = !showFullText }
            .padding(bottom = 8.dp)
    )
}












