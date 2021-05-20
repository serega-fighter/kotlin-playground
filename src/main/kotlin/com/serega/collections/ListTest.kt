package com.serega.collections

fun main() {

    val immutableList: List<Int> = listOf(1, 5, 5)
    println(immutableList.javaClass)

    val testList: MutableList<Int> = mutableListOf(1, 2, 3)
    println(testList.javaClass)
    println(testList.filter { x -> x > 5 })
    println(testList.filter { x -> x > 5 }.javaClass)

    println(testList.any {x -> x == 2})
}