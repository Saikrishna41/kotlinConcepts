package koans

import java.util.*

// Java program to print DFS
// traversal from a given
// graph


// This class represents a
// directed graph using adjacency
// list representation
internal class Graph(  // No. of vertices
    private val V: Int
) {
    // Array  of lists for
    // Adjacency List Representation
    private val adj: Array<LinkedList<Int>?>

    // Function to add an edge into the graph
    fun addEdge(v: Int, w: Int) {
        adj[v]!!.add(w) // Add w to v's list.
    }

    // A function used by DFS
    fun DFSUtil(v: Int, visited: BooleanArray) {
        // Mark the current node as visited and print it
        visited[v] = true
        print("$v ")

        // Recur for all the vertices adjacent to this
        // vertex
        val i: Iterator<Int> = adj[v]!!.listIterator()
        while (i.hasNext()) {
            val n = i.next()
            if (!visited[n]) DFSUtil(n, visited)
        }
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    fun DFS(v: Int) {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        val visited = BooleanArray(V)

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited)
    }

    companion object {
        // Driver's Code
        @JvmStatic
        fun main(args: Array<String>) {
            val g = Graph(4)
            g.addEdge(0, 1)
            g.addEdge(0, 2)
            g.addEdge(1, 2)
            g.addEdge(2, 0)
            g.addEdge(2, 3)
            g.addEdge(3, 3)
            println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)"
            )

            // Function call
            g.DFS(2)
        }
    }

    // Constructor
    init {
        adj = arrayOfNulls<LinkedList<Int>>(V)
        for (i in 0 until V) adj[i] = LinkedList<Int>()
    }
}