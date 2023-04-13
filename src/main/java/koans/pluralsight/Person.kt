package koans.pluralsight

import java.lang.StringBuilder
import java.net.URL
import java.util.*
fun isUnique2(s : String) : Boolean {
    val cArray = s.toCharArray()
    Arrays.sort(cArray)
    for (i in 0 until s.length-1) {
        if (cArray[i] != cArray[i+1]) {
            continue
        }
        else {
            return false
        }
    }
    return true
}

fun isUnique(str : String) : Boolean {
    // Assuming string can have characters a-z
    // this has 32 bits set to 0
    // Assuming string can have characters a-z
    // this has 32 bits set to 0
    var checker = 0

    for (i in 0 until str.length) {
        val bitAtIndex: Int = str.get(i) - 'a'

        // if that bit is already set in checker,
        // return false
        println("iteration $i ---> checker $checker bitAtIndex $bitAtIndex")
        if (checker and (1 shl bitAtIndex) > 0) return false


        // otherwise update and continue by
        // setting that bit in the checker
        checker = checker or (1 shl bitAtIndex)
        println("iteration $i ---> checker $checker bitAtIndex $bitAtIndex")

    }

    // no duplicates encountered, return true

    // no duplicates encountered, return true
    return true
}

fun isAnagram(s : String, t : String) : Boolean {
    if (s.length != t.length) return false
    val sTable = IntArray(s.length+1)
    val tTable = IntArray(t.length+1)
    for (i in 0 until s.length) {
        sTable[i] += s.get(i) - 'a'
    }

    for (j in 0 until t.length) {
        tTable[j] += t.get(j) - 'a'
    }
    Arrays.sort(sTable)
    Arrays.sort(tTable)
    for (i in 0 until sTable.size) {
        println("sTable ${sTable[i]}")
        println("tTable ${tTable[i]}")
        var res = sTable[i] - tTable[i]
        println(res)
        if (res != 0) return false
    }
    println("anagram result is")
   return true
}

fun URLIfy( s : String) : String {
    var cArr = s.toCharArray()
    val sb = StringBuilder()

    for (i in 0 until s.length) {
        var c = s.get(i)
        if (c == ' ') {
            sb.append("%20")
        }
        else {
            sb.append(c)
        }

    }
    return  sb.toString()
}
fun main(args : Array<String>) {
    val a = "ab"
    println(isUnique2(a))
    var s = "anagram"
    var t = "nagaram"
    println(isAnagram(s,t))
    println("Mr John Smith")
    println(URLIfy("Mr John Smith"))
}