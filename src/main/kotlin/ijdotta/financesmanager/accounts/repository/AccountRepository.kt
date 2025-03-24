package ijdotta.financesmanager.accounts.repository

import ijdotta.financesmanager.accounts.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Long>