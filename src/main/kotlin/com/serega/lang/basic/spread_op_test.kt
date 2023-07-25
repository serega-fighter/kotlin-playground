package com.serega.lang.basic

fun <T> printAll(vararg ts: T) {
    ts.forEach { println(it) }
}

// Kotlin will use the Arrays.copyOf(array, length) method to first create a copy of the spreading array.
// Then it will pass the new array as the vararg parameter:

fun main() {
    val arr = arrayOf("ABC", "CDE")

    printAll(arr)

    printAll(*arr)

}