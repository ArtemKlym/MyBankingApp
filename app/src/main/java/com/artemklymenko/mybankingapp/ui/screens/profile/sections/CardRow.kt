package com.artemklymenko.mybankingapp.ui.screens.profile.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardDoubleArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemklymenko.mybankingapp.ui.theme.BlueStart

@Composable
fun CardRow(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "My Cards",
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W600,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "All Cards",
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W600,
            textAlign = TextAlign.End
        )
        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable { },
            imageVector = Icons.Default.KeyboardDoubleArrowRight,
            contentDescription = "Show all cards",
            tint = BlueStart
        )
    }
}