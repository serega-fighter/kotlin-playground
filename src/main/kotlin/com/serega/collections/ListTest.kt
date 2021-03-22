package com.serega.collections

fun main() {

    val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)
    println(systemUsers.javaClass)
    println(systemUsers.filter { x -> x > 5 })
    println(systemUsers.filter { x -> x > 5 }.javaClass)
}