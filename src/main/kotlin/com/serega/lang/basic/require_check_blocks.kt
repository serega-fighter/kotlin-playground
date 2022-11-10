package com.serega.lang.basic

fun factorial(n: Int): Int {
    require(n >= 0)
    return 5
}

fun safeToString(obj: Any?) {
    requireNotNull(obj)
    println(obj)
}

fun main() {

}