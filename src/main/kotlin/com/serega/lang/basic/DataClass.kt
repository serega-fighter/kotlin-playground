package com.serega.lang.basic

data class DataClass(val name: String, val age: Int) {

}

fun main() {

    println(DataClass("A", 25) == DataClass("B", 26))
    println(DataClass("A", 25))
    println(DataClass("A", 25).copy())
}