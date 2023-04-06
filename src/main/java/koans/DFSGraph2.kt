package koans

import java.util.*

internal class Graph2(private val V : Int) {

    val adj : Array<LinkedList<Int>?>


    init {
        adj = arrayOfNulls<LinkedList<Int>>(V)
        for (i in 0 until V) {
            adj[i] = LinkedList<Int>()
        }
    }
}