data class Achievement(
    val id: Int,
    val name: String,
    val description: String,
    val pointsEarned: Int,
    val isCompleted: Boolean = false,
    val dateAchieved: String? = null
)
