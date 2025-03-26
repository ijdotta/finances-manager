package ijdotta.financesmanager.events.publisher.impl

import ijdotta.financesmanager.events.publisher.DomainEventPublisher
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class SpringDomainEventPublisher<T: Any>(
    private val applicationEventPublisher: ApplicationEventPublisher,
): DomainEventPublisher<T> {
    override fun publish(event: T) {
        applicationEventPublisher.publishEvent(event)
    }
}