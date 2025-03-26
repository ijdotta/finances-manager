package ijdotta.financesmanager.events.listener

interface DomainEventListener<T: Any> {
    fun handle(event: T)
}