package com.serega.lang.collections

class Test(val value: Int) {

    operator fun plus(other: Test): Test {
        return Test(this.value + other.value)
    }

    override fun toString(): String {
        return "Test(value=$value)"
    }
}

fun main() {

    println(Test(5) + Test(6))
}