package ijdotta.financesmanager.transactions.controller

import ijdotta.financesmanager.transactions.dto.TransactionDTO
import ijdotta.financesmanager.transactions.service.TransactionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

private fun TransactionDTO.validate() {
    check(amount!! >= 0) { "amount $amount must be >= 0" }
}

@RestController
@RequestMapping("/transactions")
class TransactionController(
    val transactionService: TransactionService
) {

    @PostMapping("/")
    fun create(@RequestBody transaction: TransactionDTO) = try {
        transaction.validate()
        transactionService.create(transaction).let { ResponseEntity.ok(it) }
    } catch (e: Exception) {
        ResponseEntity.internalServerError().build()
    }

    @GetMapping("/")
    fun getAllTransactions() = try {
        ResponseEntity.ok(transactionService.getAllTransactions())
    } catch (e: Exception) {
        ResponseEntity.internalServerError().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = try {
        id.toLong().let { transactionService.delete(it) }
    } catch (e: NumberFormatException) {
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.message)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody transaction: TransactionDTO) = try {
        id.toLong().let { transactionService.update(it, transaction) }.let { ResponseEntity.ok(it) }
    } catch (e: Exception) {
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.message)
    }
}