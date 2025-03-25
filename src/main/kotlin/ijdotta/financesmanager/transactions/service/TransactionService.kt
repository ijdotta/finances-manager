package ijdotta.financesmanager.transactions.service

import ijdotta.financesmanager.transactions.dto.TransactionDTO
import ijdotta.financesmanager.transactions.mapper.TransactionMapper
import ijdotta.financesmanager.transactions.repository.TransactionsRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class TransactionService(
    private val transactionsRepository: TransactionsRepository,
    private val transactionMapper: TransactionMapper
) {
    fun getAllTransactions(): List<TransactionDTO> = transactionsRepository.findAll()
            .map { transactionMapper.toDTO(it) }

    fun create(transaction: TransactionDTO) = transaction.let { transactionMapper.toEntity(it) }
            .let { transactionsRepository.save(it) }
            .let { transactionMapper.toDTO(it) }

    fun delete(id: Long) = transactionsRepository.deleteTransactionsById(id)
        .let { transactionMapper.toDTO(it) }

    fun update(id: Long, transaction: TransactionDTO): TransactionDTO {
        val existingTransaction = transactionsRepository.findById(id)
            .getOrNull()
            ?.let { transactionMapper.toDTO(it) }
            ?: throw IllegalArgumentException("Transaction with id $id not found")

        return existingTransaction.copyNonNullFields(transaction)
            .let { transactionMapper.toEntity(it) }
            .let { transactionsRepository.save(it) }
            .let { transactionMapper.toDTO(it) }
    }
}

fun TransactionDTO.copyNonNullFields(other: TransactionDTO) = this.copy(
    amount = other.amount ?: amount,
    currency = other.currency ?: currency,
    date = other.date ?: date,
    type = other.type ?: type,
    accountId = other.accountId ?: accountId,
)