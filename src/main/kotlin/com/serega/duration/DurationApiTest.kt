package com.serega.duration

import kotlin.time.*

@OptIn(ExperimentalTime::class)
fun main() {

    val tenDays: Duration = 10.days
    println(tenDays)

    val fiveDays = 5.days
    println(tenDays > fiveDays)

}