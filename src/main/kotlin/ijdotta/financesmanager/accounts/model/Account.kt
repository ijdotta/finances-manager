package ijdotta.financesmanager.accounts.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

enum class AccountType {
    CREDIT,
    CHECKING,
}

@Entity
class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var name: String? = null
    var balance: Double = 0.0
    var type: AccountType = AccountType.CREDIT
}