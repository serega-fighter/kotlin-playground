package com.serega.lang.functions

infix fun Int.mult(x: Int): Int {
    return this * x
}

infix fun Int.timesRepeated(operation: ()->Unit) = {
    repeat(this) { operation() }
}

fun main() {
    val pair = 1 to 2
    println(pair)

    val map = mapOf(1 to 2, 3 to 4)
    println(map)

    println(7 mult 9)

    val s = 5 timesRepeated {
        println("this is a test")
    }
    s()
}