package com.example.Model

data class Activity(
    val id: Int,
    val name: String,
    val category: String, // e.g., "Running", "Yoga", "HIIT"
    val date: String, // format "yyyy-MM-dd" or "yyyy-MM-dd HH:mm:ss"
    val durationMinutes: Int, // duration in minutes
    val steps: Int? = null, // optional, relevant for walking/running
    val distanceKm: Double? = null, // optional, relevant for activities like running/cycling
    val caloriesBurned: Int? = null, // optional
    val heartRate: Int? = null // optional, relevant if integrating with wearables
)
