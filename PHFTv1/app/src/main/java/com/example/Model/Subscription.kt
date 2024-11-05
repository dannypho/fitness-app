package com.example.Model

data class Subscription(
    val id: Int,
    val userId: Int, // ID of the user holding the subscription
    val startDate: String, // Start date of the subscription in "yyyy-MM-dd" format
    val endDate: String, // End date of the subscription in "yyyy-MM-dd" format
    val type: SubscriptionType, // Enum for subscription type
    val price: Double, // Cost of the subscription
    val status: SubscriptionStatus, // Enum to represent subscription status (e.g., ACTIVE, EXPIRED)
    val paymentId: Int // ID of the payment transaction associated with this subscription
)

enum class SubscriptionType {
    MONTHLY,
    ANNUAL
}

enum class SubscriptionStatus {
    ACTIVE,
    PENDING,
    EXPIRED,
    CANCELED
}
