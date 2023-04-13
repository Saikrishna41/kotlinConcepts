package koans.dsa


data class NodeDemo<T>(val value: T, var next: NodeDemo<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value ----> $next"
        } else {
            "$value"
        }
    }
}

class LinkedListDemo<T> {
    private var head : NodeDemo<T>? = null
    private var tail : NodeDemo<T>? = null
    private var size = 0

    fun isEmpty() : Boolean {
        return size == 0
    }

    fun prepend(value : T) : LinkedListDemo<T> {
        head = NodeDemo(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T) {
        if (isEmpty()) {
            prepend(value)
            return
        }
        tail?.next = NodeDemo(value = value)
        tail = tail?.next
    }

    fun nodeAt(pos : Int) : NodeDemo<T>? {
        //1
        var curNode = head
        var curIndex = 0
        //2
        while (curNode != null && curIndex < pos) {
            curNode = curNode.next
            curIndex++
        }
        return curNode
    }

    fun insert(value : T, afterNode : NodeDemo<T>?) : NodeDemo<T>? {
        if (tail == afterNode) {
            append(value)
            return tail
        }
        val newNode = NodeDemo(value = value, next = afterNode?.next)
        afterNode?.next = newNode
        size++
        return newNode
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        }
        else {
            head.toString()
        }
    }
}

fun main() {
    val list = LinkedListDemo<Int>()
    list.append(1)
    list.append(2)
    list.append(3)
    list.insert(323,list.nodeAt(0))
    println(list)
}