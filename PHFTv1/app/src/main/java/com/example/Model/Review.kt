data class Review(
    val id: Int,
    val userId: Int, // ID of the user who submitted the review
    val reviewedItemId: Int, // ID of the item being reviewed (e.g., trainer, workout plan)
    val rating: Double, // Rating out of 5.0
    val comment: String?, // Optional comment for the review
    val reviewDate: String, // Date of the review in "yyyy-MM-dd" format
    val reviewType: ReviewType // Enum to specify type (e.g., TRAINER, APP)
)

enum class ReviewType {
    TRAINER,
    WORKOUT_PLAN,
    APP
}
