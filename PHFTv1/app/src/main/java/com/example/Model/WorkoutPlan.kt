data class WorkoutPlan(
    val id: Int,
    val userId: Int, // ID of the user for whom the plan is created
    val title: String, // Title of the workout plan
    val description: String?, // Optional description of the workout plan
    val exercises: List<Exercise>, // List of exercises included in the plan
    val duration: Int, // Total duration of the workout plan in minutes
    val frequencyPerWeek: Int, // Number of times the plan should be followed each week
    val createdDate: String, // Date when the workout plan was created in "yyyy-MM-dd" format
    val modifiedDate: String? = null, // Optional: Last modified date
    val trainerId: Int? = null // Optional: ID of the trainer who created the plan (if applicable)
)

data class ExerciseWorkoutPlan(
    val name: String, // Name of the exercise (e.g., "Push-Up")
    val sets: Int, // Number of sets
    val reps: Int, // Number of repetitions per set
    val duration: Int? = null // Optional: Duration in seconds (if applicable)
)
