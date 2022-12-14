package koans


fun strLength(str: String?): Int? {
    return str?.let { it.length }
}


fun main() {
    var neverNull : String? = "This cant be null"
    neverNull = null
    var nullableString : String? = "you can keep a null here"
    nullableString = null
    var inferredNotNull : String?  =  "the compiled assumes not null"
    inferredNotNull = null
    strLength(neverNull)
    strLength(nullableString)
}