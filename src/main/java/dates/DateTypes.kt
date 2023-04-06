package dates

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun Type1() : String {
    val dateTime = LocalDateTime.now()
    val format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    val res = dateTime.format(format)
    return res
}

fun Type2() : String {
    val date  = Date()
    val format = SimpleDateFormat("yyyy-MM-dd")
    val res = format.format(date)
    return res

}

fun type3() : String {
    val calendar = Calendar.getInstance()
    val time = calendar.time
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm")
    val res = format.format(time)
    return res

}

fun main() {
    val t1 = Type1()
    println(t1)
    val t2 = Type2()
    println(t2)
    val t3 = type3()
    print(t3)
}
