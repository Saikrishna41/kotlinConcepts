package queue

interface Queue<T> {

    fun enqueue(element: T)
    fun dequeue(): T?
    fun peek(): T?
    val count: Int
    val isEmpty: Boolean
        get() = count == 0
}