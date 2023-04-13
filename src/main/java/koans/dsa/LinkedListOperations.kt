package koans.dsa



data class Node<T>(var value : T, var next : Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value --> ${next.toString()}"
        }
        else {
            "$value"
        }
    }
}
class ListNode<T> {
   private var head : Node<T>? = null
    private var tail : Node<T>? = null
    private var size = 0
    fun isEmpty() : Boolean {
        return size == 0
    }
    override fun toString(): String {
       return if (isEmpty()) {
             "Empty List"
        }
        else {
            head.toString()
        }
    }

    fun push(value : T) {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }
}