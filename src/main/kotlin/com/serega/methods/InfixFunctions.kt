package com.serega.methods

infix fun Int.mult(x: Int): Int {
    return this * x
}

fun main() {
    val pair = 1 to 2
    println(pair)

    val map = mapOf(1 to 2, 3 to 4)
    println(map)

    println(7 mult 9)
}