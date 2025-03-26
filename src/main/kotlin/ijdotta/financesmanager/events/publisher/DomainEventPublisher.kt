package ijdotta.financesmanager.events.publisher

interface DomainEventPublisher<T: Any> {
    fun publish(event: T)
}