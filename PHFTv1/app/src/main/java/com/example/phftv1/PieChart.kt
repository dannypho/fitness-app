
package com.example.phftv1

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.phftv1.pieChart.Black
import com.example.phftv1.pieChart.LightGray
import com.example.phftv1.pieChart.step1Color
import com.example.phftv1.pieChart.step3Color
import com.example.phftv1.pieChart.uiColor


@Composable
fun MultiPieChartScreen(
    pieChartDataList: List<Map<String, Int>>, // List of data for each pie chart
    radiusOuter: Dp = 140.dp,
    chartBarWidth: Dp = 35.dp,
    animDuration: Int = 1000,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(pieChartDataList) { data ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(16.dp)
            ) {
                PieChart(
                    data = data,
                    radiusOuter = radiusOuter,
                    chartBarWidth = chartBarWidth,
                    animDuration = animDuration
                )
            }
            Spacer(modifier = Modifier.height(30.dp)) // Space between charts
        }
    }
}


@Composable
fun PieChart(
    data: Map<String,Int >,
    radiusOuter: Dp = 140.dp,
    chartBarWidth: Dp = 35.dp,
    animDuration: Int = 1000,
) {
    val totalSum = (data["Steps_Goal"] as? Int)?.toFloat() ?: 1f
    val stepsCompleted = (data["Steps_completed"] as? Int)?.toFloat() ?: 0f
    val progressValue = 360 * stepsCompleted / totalSum // Progress arc based on steps taken

    // Colors for goal and progress arcs
    val goalColor = LightGray
    val progressColor = uiColor

    val percentage = (stepsCompleted / totalSum) * 100
    val percentageText = "${percentage.toInt()}%" // Display percentage

    var lastValue = -90f
    var animationProgress by remember { mutableStateOf(0f) }

    val units = listOf("Distance(miles)  ", "Distance(miles) ", "Distance(miles) ", "Yoga(poses) ", "HIIT(minutes) ","Weightlifting(lbs) ")
    val pieData = mapOf(
        units[data["chart_name"]!!] to stepsCompleted.toInt(),
        "Goal" to totalSum.toInt()
    )

    val pieColors = listOf(goalColor, progressColor )
    val listOfNames = listOf("Running progress: ", "Walking progress: ", "Cycling progress: ", "Yoga progress: ", "HIIT progress: ","Weightlifting progress: ")

    // Animate progress
    val animateProgress by animateFloatAsState(
        targetValue = if (animationProgress == progressValue) progressValue else animationProgress,
        animationSpec = tween(
            durationMillis = animDuration,
            easing = LinearOutSlowInEasing
        )
    )

    LaunchedEffect(key1 = true) {
        while (animationProgress < progressValue) {
            delay(200)
            animationProgress += progressValue / 5f
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(radiusOuter * 2f),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .offset { IntOffset.Zero }
                    .size(radiusOuter * 2f)
            ) {
                // Draw goal arc
                drawArc(
                    color = goalColor,
                    startAngle = lastValue,
                    sweepAngle = 360f, // Full circle for goal
                    useCenter = false,
                    style = Stroke(chartBarWidth.toPx(), cap = StrokeCap.Butt)
                )

                lastValue += 360f

                // Draw progress arc
                drawArc(
                    color = uiColor,
                    startAngle = lastValue,
                    sweepAngle = animateProgress,
                    useCenter = false,
                    style = Stroke(chartBarWidth.toPx(), cap = StrokeCap.Butt)
                )
            }
            val centerText = listOfNames[data["chart_name"]!!]
            Text(
                text =  centerText + percentageText,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = uiColor
                ),

                textAlign = TextAlign.Center
            )
        }
        DetailsPieChart(data = pieData, colors = pieColors)
    }
}





@Composable
fun DetailsPieChart(
    data: Map<String, Any>,
    colors: List<Color>
) {
    Column(
        modifier = Modifier
            .padding(top = 80.dp)
            .fillMaxWidth()
    ) {
        // create the data items
        data.values.forEachIndexed { index, value ->
            DetailsPieChartItem(
                data = Pair(data.keys.elementAt(index), value),
                color = colors[index]
            )
        }

    }
}

@Composable
fun DetailsPieChartItem(
    data: Pair<String, Any>,
    height: Dp = 45.dp,
    color: Color
) {
    Surface(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 40.dp),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = color,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .size(height)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp) // Padding inside the border box
            ) {
                Column {
                    Text(
                        text = data.first,
                        fontWeight = FontWeight.Medium,
                        fontSize = 22.sp,
                        color = uiColor
                    )
                    Text(
                        text = data.second.toString(),
                        fontWeight = FontWeight.Medium,
                        fontSize = 22.sp,
                        color = uiColor
                    )
                }
            }
        }
    }
}
