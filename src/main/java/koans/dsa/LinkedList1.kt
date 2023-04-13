package koans.dsa

data class Node1<T>(val value: T, var next: Node1<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value ----> $next"
        } else {
            "$value"
        }
    }
}

class LinkedList1<T> {
    private var head: Node1<T>? = null
    private var tail: Node1<T>? = null
    private var size = 0
    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

    fun prepend(value: T) : LinkedList1<T> {
        head = Node1(value = value, next = head)
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
        tail?.next = Node1(value = value)
        tail = tail?.next
    }
}

fun main(args : Array<String>) {
    val list = LinkedList1<Int>()
    list.prepend(1)
    list.prepend(2)
    list.prepend(32)

    println(list)

    list.append(21212)

    println(list)
}

internal class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val curColor = image[sr][sc]
        if (curColor != color) DFS(image, sr, sc, curColor, color)
        return image
    }

    fun DFS(image: Array<IntArray>, r: Int, c: Int, curColor: Int, newColor: Int) {
        if (image[r][c] != curColor) return
        image[r][c] = newColor
        if (r >= 1) DFS(image, r - 1, c, curColor, newColor)
        if (c >= 1) DFS(image, r, c - 1, curColor, newColor)
        if (r + 1 < image.size) DFS(image, r + 1, c, curColor, newColor)
        if (c + 1 < image[0].size) DFS(image, r, c + 1, curColor, newColor)
    }
}