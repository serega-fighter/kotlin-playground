package com.serega.basic

private data class Box(val x: Int) {

}

fun main() {

    val nullRef: Box? = null
    println(nullRef?.x)

    val nonNullRef: Box? = Box(5)
    println(nonNullRef?.x)
}