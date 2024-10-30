data class User(
    var id: Int,
    var name: String,
    var email: String,
    var password: String,
    var level: String,
    var points: Int,
    var role: String,
    var attributes: HashMap<String, Any> = hashMapOf(),
    var goals: HashMap<String, Any> = hashMapOf()
)