package com.example.Model

data class TrackingData(
    val id: Int,
    val userId: Int, // ID of the user whose data is being tracked
    val activityType: String, // Type of activity (e.g., "running", "walking", "cycling")
    val date: String, // Date of the tracking data in "yyyy-MM-dd" format
    val steps: Int? = null, // Optional: Number of steps taken
    val distance: Double? = null, // Optional: Distance covered in kilometers or miles
    val caloriesBurned: Double? = null, // Optional: Calories burned
    val heartRate: Int? = null, // Optional: Average heart rate during the activity
    val durationMinutes: Int? = null // Optional: Duration of the activity in minutes
)
