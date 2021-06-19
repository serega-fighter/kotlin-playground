package com.serega.collections

fun main() {

    val nums = listOf(1, 4, 6, 3, 7)

    val it = nums.reversed().listIterator()
    for (i in it) {
        println(i)
    }
}