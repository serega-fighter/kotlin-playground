package com.serega.lang.basic

// Validate arg

fun factorial(n: Int): Int {
    require(n >= 0)
    return 5
}

fun safeToString(obj: Any?) {
    requireNotNull(obj)
    println(obj)
}

// Validate state

fun doSomething(x: Int) {
    check(x > 2) { "This is a problem" }
}

fun main() {

}