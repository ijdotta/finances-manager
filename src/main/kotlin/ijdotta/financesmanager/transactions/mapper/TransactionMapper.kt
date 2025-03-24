package ijdotta.financesmanager.transactions.mapper

import ijdotta.financesmanager.accounts.service.AccountService
import ijdotta.financesmanager.transactions.dto.TransactionDTO
import ijdotta.financesmanager.transactions.model.Transaction
import ijdotta.financesmanager.transactions.model.Currency
import ijdotta.financesmanager.transactions.model.TransactionType

class TransactionMapper(
    private val accountService: AccountService,
) {
    fun mapToEntity(transaction: TransactionDTO) = with(transaction) {
        Transaction(
            id = id,
            amount = amount,
            currency = currency.toCurrency(),
            date = date,
            type = type.toType(),
            account = accountId.toAccount()
        )
    }

    private fun Long.toAccount() = accountService.findAccount(this) ?: throw AccountNotFoundException(this.toString())
}

class AccountNotFoundException(message: String) : RuntimeException("Account not found: $message")

private fun String.toCurrency() = try {
    Currency.valueOf(this)
} catch (e: IllegalArgumentException) {
    throw InvalidCurrencyException("Invalid currency: $this")
}

class InvalidCurrencyException(message: String) : RuntimeException(message)

private fun String.toType() = try {
    TransactionType.valueOf(this)
} catch (e: IllegalArgumentException) {
    throw InvalidTransactionTypeException("Invalid transaction type: $this")
}

class InvalidTransactionTypeException(message: String) : RuntimeException(message)
