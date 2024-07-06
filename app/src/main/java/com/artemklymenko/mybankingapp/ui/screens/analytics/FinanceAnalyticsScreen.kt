package com.artemklymenko.mybankingapp.ui.screens.analytics

import android.graphics.Typeface
import android.text.TextUtils
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.DonutPieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import com.artemklymenko.mybankingapp.ui.screens.home.sections.CardsSection
import com.artemklymenko.mybankingapp.ui.screens.profile.sections.financeItemList
import com.artemklymenko.mybankingapp.ui.theme.BlueStart
import com.artemklymenko.mybankingapp.ui.theme.GreenStart
import com.artemklymenko.mybankingapp.ui.theme.OrangeStart
import com.artemklymenko.mybankingapp.ui.theme.PurpleStart


@Composable
fun FinanceAnalyticsScreen() {

    val donutChartData = PieChartData(
        slices = listOf(
            PieChartData.Slice("Balance", financeItemList[0].amount.toFloat(), PurpleStart),
            PieChartData.Slice("Income", financeItemList[1].amount.toFloat(), BlueStart),
            PieChartData.Slice("Expense", financeItemList[2].amount.toFloat(), OrangeStart),
            PieChartData.Slice("Total Saving", financeItemList[3].amount.toFloat(), GreenStart)
        ),
        plotType = PlotType.Donut
    )

    val donutChartConfig = PieChartConfig(
        strokeWidth = 40f,
        activeSliceAlpha = .9f,
        showSliceLabels = true,
        sliceLabelTextColor = Color.Black,
        sliceLabelTypeface = Typeface.SANS_SERIF,
        sliceLabelEllipsizeAt = TextUtils.TruncateAt.END,
        isAnimationEnable = true,
        isClickOnSliceEnabled = true,
        isSumVisible = true,
        labelVisible = true,
        labelColor = Color.Black
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            text = "Your Cards Statistic",
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W600
        )
        Spacer(modifier = Modifier.height(16.dp))
        CardsSection()
        HintForChart(donutChartData, 0, 1)
        HintForChart(donutChartData, 2, 3)
        DonutPieChart(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(260.dp),
            donutChartData,
            donutChartConfig
        )
    }
}

@Composable
private fun HintForChart(donutChartData: PieChartData, startIndex: Int, endIndex: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp)
    ) {
        for (i in startIndex..endIndex) {
            Box(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(donutChartData.slices[i].color)

            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = donutChartData.slices[i].label
            )
        }
    }
}