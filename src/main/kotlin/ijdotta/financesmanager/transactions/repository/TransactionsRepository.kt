package ijdotta.financesmanager.transactions.repository

import ijdotta.financesmanager.transactions.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionsRepository: JpaRepository<Transaction, Long> {
    fun deleteTransactionsById(id: Long): Transaction
}