package com.serega.lang.collections

fun main() {
    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6)

    for ((index, value) in mutableList.withIndex()) {
        println("the element at $index is $value")
    }
}