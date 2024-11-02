data class Payment(
    val id: Int,
    val userId: Int, // ID of the user making the payment
    val amount: Double, // Payment amount
    val paymentDate: String, // Date of payment in "yyyy-MM-dd HH:mm:ss" format
    val paymentMethod: PaymentMethod, // Enum for payment method
    val transactionId: String, // Unique transaction ID
    val status: PaymentStatus // Enum to indicate payment status (e.g., SUCCESS, FAILED)
)

enum class PaymentMethod {
    CREDIT_CARD,
    DEBIT_CARD,
    PAYPAL
}

enum class PaymentStatus {
    SUCCESS,
    PENDING,
    FAILED
}
