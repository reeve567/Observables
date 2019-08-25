package pw.xwy.observables

import java.util.*
import kotlin.collections.HashSet

class Observable<T> {
	private val set: HashSet<Subscriber<T>> = HashSet()

	fun unsubscribe(subscriber: Subscriber<T>) {
		set.remove(subscriber)
	}

	fun subscribe(te: (T) -> Unit): Subscriber<T> {
		val sub: Subscriber<T> = Subscriber(UUID.randomUUID(), te)
		set.add(sub)
		return sub
	}

	fun update(value: T) {
		for (subscriber in set) {
			subscriber.run(value)
		}
	}
}