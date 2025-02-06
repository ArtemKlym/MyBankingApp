package com.artemklymenko.mybankingapp.ui.screens.exchange_rate

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.artemklymenko.mybankingapp.ui.screens.exchange_rate.domain.ExchangeRate

private val years = listOf("2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024")

@Composable
fun ExchangeRateScreen(
    modifier: Modifier,
    state: ExchangeRateUiState,
    onEvent: (ExchangeRateUiEvent) -> Unit
) {

    LaunchedEffect(Unit) {
        onEvent(ExchangeRateUiEvent.ChangeExchangeRatesYear(state.selectedYear))
    }

    if (state.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

    } else if (state.error != null) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Error: ${state.error}")
        }
    } else {
        state.exchangeRate?.let { exchangeRate ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Currency exchange rate archive",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(years) { year ->
                        val isSelected = state.selectedYear == year
                        Text(
                            text = year,
                            modifier = Modifier
                                .clickable {
                                    if(state.selectedYear != year) {
                                        onEvent(ExchangeRateUiEvent.ChangeExchangeRatesYear(year))
                                    }
                                }
                                .background(if (isSelected) Color.Gray else Color.Transparent)
                                .padding(8.dp),
                            color = if (isSelected) Color.White else Color.Black,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                val pointsData: List<Point> = mapExchangeRateToPoints(exchangeRate)
                val maxY = pointsData.maxOfOrNull { it.y } ?: 50f
                val steps = 5
                val yScale = maxY / steps

                val xAxisData = AxisData.Builder()
                    .axisStepSize(50.dp)
                    .backgroundColor(Color.Transparent)
                    .steps(pointsData.size - 1)
                    .labelData { i ->
                        exchangeRate.exchangeRate.getOrNull(i)?.currency ?: ""
                    }
                    .labelAndAxisLinePadding(15.dp)
                    .build()

                val yAxisData = AxisData.Builder()
                    .steps(steps)
                    .backgroundColor(Color.Transparent)
                    .labelAndAxisLinePadding(20.dp)
                    .labelData { i ->
                        "${(i * yScale).toInt()} hrn"
                    }
                    .build()

                val lineChartData = LineChartData(
                    linePlotData = LinePlotData(
                        lines = listOf(
                            Line(
                                dataPoints = pointsData,
                                lineStyle = LineStyle(),
                                intersectionPoint = IntersectionPoint(),
                                selectionHighlightPoint = SelectionHighlightPoint(),
                                shadowUnderLine = ShadowUnderLine(),
                                selectionHighlightPopUp = SelectionHighlightPopUp()
                            )
                        ),
                    ),
                    xAxisData = xAxisData,
                    yAxisData = yAxisData,
                    gridLines = GridLines(),
                    backgroundColor = Color.White
                )
                LineChart(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    lineChartData = lineChartData
                )
            }
        }
    }
}

fun mapExchangeRateToPoints(exchangeRate: ExchangeRate): List<Point> {
    return exchangeRate.exchangeRate.mapIndexed { index, rate ->
        Point(x = index.toFloat(), y = rate.saleRate.toFloat()) // Using saleRate as y-axis
    }
}