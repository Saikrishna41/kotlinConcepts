package queue

class QueueImpl<T> : Queue<T> {

    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun enqueue(element: T) {
      storage.add(0,element)
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else storage.removeAt(0)
    }

    override fun peek(): T? {
        return storage.getOrNull(0)
    }
}

