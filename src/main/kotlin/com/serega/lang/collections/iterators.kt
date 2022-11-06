package com.serega.lang.collections

fun main() {

    val nums = listOf(1, 4, 6, 3, 7)

    val it = nums.reversed().listIterator()
    for (i in it) {
        println(i)
    }

    val mutableNums = mutableListOf(1, 2, 3, 4, 5)
    val mutIt = mutableNums.listIterator()
    mutIt.next()
    mutIt.next()
    mutIt.set(66)

    println(mutableNums)
}