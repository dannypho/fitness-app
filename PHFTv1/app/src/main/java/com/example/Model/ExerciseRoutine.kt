data class ExerciseRoutine(
    val id: Int,
    val name: String,
    val description: String,
    val targetMuscles: List<String>, // List of target muscle groups (e.g., "Arms", "Legs", "Core")
    val durationMinutes: Int, // Total duration of the routine in minutes
    val intensityLevel: Int, // Scale 1–5 for intensity level
    val exercises: List<Exercise>, // List of exercises in the routine
    val isPersonalized: Boolean = false // Indicates if routine is customized for a user
)

data class Exercise(
    val id: Int,
    val name: String,
    val reps: Int? = null, // Optional: repetitions for the exercise
    val sets: Int? = null, // Optional: sets for the exercise
    val durationSeconds: Int? = null // Optional: duration if it's a timed exercise
)
