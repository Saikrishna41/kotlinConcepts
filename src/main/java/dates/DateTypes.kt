package dates

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun DateType1() {
    val dateTime = LocalDateTime.now()
    val format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    val curr = format.format(dateTime)
    println(curr)
}

fun DateType2() {
    val calendar = Calendar.getInstance()
    val curr = calendar.time
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm")
    val date = format.format(curr)
    println(date)
}

fun main() {
    DateType1()
    DateType2()
}