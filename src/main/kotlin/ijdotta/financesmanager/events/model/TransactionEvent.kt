package ijdotta.financesmanager.events.model

sealed interface TransactionEvent
data class TransactionCreated(val id: Long) : TransactionEvent
data class TransactionUpdated(val id: Long) : TransactionEvent
data class TransactionDeleted(val id: Long) : TransactionEvent