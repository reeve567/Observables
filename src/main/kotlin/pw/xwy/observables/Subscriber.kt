package pw.xwy.observables

import java.util.*

class Subscriber<T>(val id: UUID, private val action: (T) -> Unit) {
	fun run(value: T) {
		action.invoke(value)
	}
}