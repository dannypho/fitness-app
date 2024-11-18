package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.phftv1.GeneralUser
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.Model.TrackingData
import com.example.backend.DataBaseHelper
import org.w3c.dom.Text

class Tracking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tracking)


        val stepsInput = findViewById<TextView>(R.id.steps_input)
        val distanceInput = findViewById<TextView>(R.id.distance_input)
        val caloriesBurnedInput = findViewById<TextView>(R.id.calories_burned_input)
        val heartRateInput = findViewById<TextView>(R.id.heart_rate_input)
        val activityInput = findViewById<TextView>(R.id.activity_input)
        val dateInput = findViewById<TextView>(R.id.date_input)
        val addButton = findViewById<Button>(R.id.add_button)
        val importDataButton = findViewById<Button>(R.id.import_data_button)
        val metricView = findViewById<ListView>(R.id.metric_view)

        addButton.setOnClickListener {
            // Declare metricModel here, outside the try-catch block
            val metricModel: TrackingData



            try {
                val date = dateInput.text.toString()
                val activity = activityInput.text.toString()
                if (date.isEmpty()) {
                    Toast.makeText(this, "Date is required", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (activity.isEmpty()) {
                    Toast.makeText(this, "Activity is required", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                metricModel = TrackingData(
                    -1,
                    userid,
                    activityInput.text.toString(),
                    dateInput.text.toString(),
                    stepsInput.text.toString().toIntOrNull() ?: 0,
                    distanceInput.text.toString().toDoubleOrNull() ?: 0.0,
                    caloriesBurnedInput.text.toString().toDoubleOrNull() ?: 0.0,
                    heartRateInput.text.toString().toIntOrNull() ?: 0
                )
                Toast.makeText(this, metricModel.toString(), Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, "Error creating metric", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Now this is in the correct scope
            val dataBaseHelper = DataBaseHelper(this)
            dataBaseHelper.addMetric(metricModel)
            val allMetrics = dataBaseHelper.getMetric(userid)

            val metricArrayAdapter = ArrayAdapter<String>(this, R.layout.list_item_white_text, R.id.text_view_item, allMetrics.map { it.toString() })
            metricView.adapter = metricArrayAdapter
        }

        findViewById<Button>(R.id.dash_button).setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.progress_button).setOnClickListener {
            val intent = Intent(this, ProgressMonitoring::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.share_button).setOnClickListener {
            val intent = Intent(this, SocialFeatures::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.back_buttonTRACKING).setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
}
