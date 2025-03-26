package ijdotta.financesmanager.settlements.listener.adapter

import ijdotta.financesmanager.events.model.TransactionEvent
import ijdotta.financesmanager.settlements.listener.TransactionEventListener
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class SpringTransactionEventAdapter(
    private val transactionEventListener: TransactionEventListener
) {
    @EventListener
    fun onEvent(event: TransactionEvent) {
        transactionEventListener.handle(event)
    }
}