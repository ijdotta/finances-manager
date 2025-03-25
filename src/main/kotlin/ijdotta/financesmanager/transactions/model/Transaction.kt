package ijdotta.financesmanager.transactions.model

import ijdotta.financesmanager.accounts.model.Account
import jakarta.persistence.*
import java.time.LocalDate

enum class TransactionType {
    EXPENSE,
    INCOME,
}

enum class Currency {
    ARS,
    USD_OFFICIAL,
    USD_MEP,
    USD_CRYPTO,
    USD_BLUE,
}

@Entity
class Transaction(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var amount: Double = 0.0,
    var currency: Currency = Currency.ARS,
    var date: LocalDate = LocalDate.now(),
    var type: TransactionType = TransactionType.EXPENSE,
    @ManyToOne
    @JoinColumn(name = "account_id")
    var account: Account? = null
)

