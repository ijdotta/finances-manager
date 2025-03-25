package ijdotta.financesmanager.accounts.service

import ijdotta.financesmanager.accounts.model.Account
import ijdotta.financesmanager.accounts.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository) {
    fun findAccount(id: Long): Account? = accountRepository.findById(id).orElse(null)
}