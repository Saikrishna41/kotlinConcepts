package stack

class StackImpl<T> : Stack<T> {

    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        return storage.removeLastOrNull()
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }
}

private fun String.isValidParanthesis(): Boolean {
    val stack = StackImpl<Char>()
    for (c in this) {
        when (c) {
            '(' -> stack.push(c)
            ')' -> {
                if (stack.isEmpty) {
                    return false
                }
                stack.pop()
            }
        }
    }
    return stack.count == 0
}

fun main() {
    println("((()))".isValidParanthesis())
}