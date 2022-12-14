open class BaseClass(name: String) {

    init {
        println("Base class initialized")
    }

    open val size: Int = name.length.also { println("Initializing size in base class $it") }
}

class DerivedClass(name: String, val lastName: String) : BaseClass(name.replaceFirstChar { it.uppercase() }.also {

    println("Argument for baseclass $it")
}) {
    init {
        println("Derived class initialized")
    }
    override val size: Int = (super.size + lastName.length).also { println("Initializing size in derived class $it") }
}

fun main() {

    println("Constructing derived class (\"hello\" , \"world\")")
    DerivedClass("hello","world")

}