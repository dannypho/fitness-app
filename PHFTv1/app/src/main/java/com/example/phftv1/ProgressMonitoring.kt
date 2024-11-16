package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.os.DropBoxManager
import android.widget.Button
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.phftv1.pieChart.CustomPieChartJCTheme
import java.security.KeyStore
import java.util.Map
import androidx.compose.ui.Modifier
import com.example.phftv1.pieChart.Black
import com.example.phftv1.pieChart.Blue
import com.example.phftv1.pieChart.LightGray
import com.example.phftv1.pieChart.Purple700
import com.example.phftv1.pieChart.step1Color
import com.example.phftv1.pieChart.step2Color
import com.example.phftv1.pieChart.step3Color


class ProgressMonitoring : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CustomPieChartJCTheme {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {

                    // Preview with sample data
                    val pieChartDataList = listOf(
                        mapOf(
                            "Steps_Goal" to 5,
                            "Steps_completed" to 3,
                            "chart_name" to 0
                        ),
                        mapOf(
                            "Steps_Goal" to 10,
                            "Steps_completed" to 6,
                            "chart_name" to 1
                        ),
                        mapOf(
                            "Steps_Goal" to 15,
                            "Steps_completed" to 8,
                            "chart_name" to 2
                        ),
                        mapOf(
                                "Steps_Goal" to 15,
                        "Steps_completed" to 9,
                            "chart_name" to 3
                    ),
                        mapOf(
                        "Steps_Goal" to 90,
                        "Steps_completed" to 30,
                            "chart_name" to 4

                    ),
                        mapOf(
                            "Steps_Goal" to 600,
                            "Steps_completed" to 500,
                            "chart_name" to 5
                        )
                    )

                    MultiPieChartScreen(pieChartDataList = pieChartDataList)

                }

            }
        }

    }
}