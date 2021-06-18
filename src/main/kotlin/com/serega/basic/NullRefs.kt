package com.serega.basic

private data class IntBox(val x: Int) {

}

fun main() {

    val nullRef: IntBox? = null
    println(nullRef?.x)

    val nonNullRef: IntBox? = IntBox(5)
    println(nonNullRef?.x)
}