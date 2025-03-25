package ijdotta.financesmanager.transactions.dto

import java.time.LocalDate

data class TransactionDTO(
    val id: Long?,
    val amount: Double?,
    val currency: String?,
    val date: LocalDate?,
    val type: String?,
    val accountId: Long?,
)