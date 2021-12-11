package com.serega.duration

import kotlin.time.*

@OptIn(ExperimentalTime::class)
fun main() {

    val tenDays: Duration = 10.days
    println(tenDays)

    val fiveDays = 5.days
    println(tenDays > fiveDays)

    println("${(36.hours + 30.minutes - 6.milliseconds).inWholeDays} whole days")

    println(Duration.parseOrNull("11d 19h 18m"))
}