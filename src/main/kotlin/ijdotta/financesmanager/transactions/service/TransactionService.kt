package ijdotta.financesmanager.transactions.service

import ijdotta.financesmanager.transactions.model.Transaction
import ijdotta.financesmanager.transactions.repository.TransactionsRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(
    private val transactionsRepository: TransactionsRepository,
) {
    fun create(transaction: Transaction) = transactionsRepository.save(transaction)
}