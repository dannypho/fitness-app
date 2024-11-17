package com.example.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.phftv1.MultiPieChartScreen
import com.example.phftv1.R
import com.example.phftv1.pieChart.CustomPieChartJCTheme

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MonitoringFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MonitoringFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monitoring, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val composeView =
            view.findViewById<androidx.compose.ui.platform.ComposeView>(R.id.compose_view)
        composeView.setContent {
            ProgressMonitoringScreen()
        }
    }

    @Composable
    fun ProgressMonitoringScreen() {
        CustomPieChartJCTheme {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                val pieChartDataList = listOf(
                    mapOf("Steps_Goal" to 5, "Steps_completed" to 3, "chart_name" to 0),
                    mapOf("Steps_Goal" to 10, "Steps_completed" to 6, "chart_name" to 1),
                    mapOf("Steps_Goal" to 15, "Steps_completed" to 8, "chart_name" to 2),
                    mapOf("Steps_Goal" to 15, "Steps_completed" to 9, "chart_name" to 3),
                    mapOf("Steps_Goal" to 90, "Steps_completed" to 30, "chart_name" to 4),
                    mapOf("Steps_Goal" to 600, "Steps_completed" to 500, "chart_name" to 5)
                )

                MultiPieChartScreen(pieChartDataList = pieChartDataList)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MonitoringFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MonitoringFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
