data class Advertisement(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String, // URL or resource ID for the ad image
    val type: AdvertisementType, // Enum to define INTERNAL or EXTERNAL
    val targetUrl: String? = null, // Optional URL to redirect (e.g., external sites or product pages)
    val startDate: String, // e.g., "yyyy-MM-dd"
    val endDate: String, // e.g., "yyyy-MM-dd"
    val isActive: Boolean = true // Indicates if the ad is currently active
)

enum class AdvertisementType {
    INTERNAL,
    EXTERNAL
}
