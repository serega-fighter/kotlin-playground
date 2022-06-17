package com.serega.collections

fun main() {

    // class java.util.Arrays$ArrayList
    val immutableList: List<Int> = listOf(1, 5, 5)
    println(immutableList.javaClass)

    // ArrayList
    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6)
    println(mutableList.javaClass)
    println(mutableList.filter { x -> x > 5 })
    println(mutableList.filter { x -> x > 5 }.javaClass)

    println(mutableList.any { x -> x == 2})

    mutableList.removeIf { it == 2 }
    println(mutableList)

    for ((index, value) in mutableList.withIndex()) {
        println("the element at $index is $value")
    }
}