data class Notification(
    val id: Int,
    val title: String,
    val message: String,
    val timestamp: String, // Date and time when the notification is generated, e.g., "yyyy-MM-dd HH:mm:ss"
    val type: NotificationType, // Enum for notification type (e.g., ACTIVITY_REMINDER, PROGRESS_UPDATE)
    val isRead: Boolean = false, // Flag to indicate if the notification has been read
    val userId: Int // ID of the user receiving the notification
)

enum class NotificationType {
    ACTIVITY_REMINDER,
    PROGRESS_UPDATE,
    SOCIAL_INTERACTION,
    PAYMENT_CONFIRMATION,
    REWARD_EARNED,
    SUBSCRIPTION_RENEWAL
}
