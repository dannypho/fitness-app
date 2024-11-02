data class Leaderboard(
    val id: Int,
    val month: String, // Month for this leaderboard, e.g., "October 2024"
    val users: List<LeaderboardUser> // List of users and their points for the leaderboard
)

data class LeaderboardUser(
    val userId: Int,
    val userName: String,
    val points: Int,
    val rank: Int // User's rank in the leaderboard
)
