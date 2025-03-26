package ijdotta.financesmanager.settlements.listener

import ijdotta.financesmanager.events.listener.DomainEventListener
import ijdotta.financesmanager.events.model.TransactionCreated
import ijdotta.financesmanager.events.model.TransactionDeleted
import ijdotta.financesmanager.events.model.TransactionEvent
import ijdotta.financesmanager.events.model.TransactionUpdated
import org.springframework.stereotype.Component

@Component
class TransactionEventListener: DomainEventListener<TransactionEvent> {
    override fun handle(event: TransactionEvent) {
        when (event) {
            is TransactionCreated -> TODO()
            is TransactionDeleted -> TODO()
            is TransactionUpdated -> TODO()
        }
    }
}