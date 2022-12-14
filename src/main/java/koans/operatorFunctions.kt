package koans


operator fun Int.times(str : String) = str.repeat(this)

operator fun Int.plus(str : String) = str.plus(this)


fun main() {
    println(3 * "Hello")
    println(45 + "hello")
}


//output
//HelloHelloHello
//hello45


