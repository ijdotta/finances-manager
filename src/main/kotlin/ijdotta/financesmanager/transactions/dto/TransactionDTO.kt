package ijdotta.financesmanager.transactions.dto

data class TransactionDTO(
    val id: Long,
    val amount: Double,
    val currency: String,
    val balance: Double,
    val accountId: Long
)