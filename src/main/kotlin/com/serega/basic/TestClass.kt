package com.serega.basic

class TestClass {

    var stringRepresentation: String
        get() = this.toString()
        set(value) {
            println("Setter is called $value")
        }
}

fun main() {

    val f = TestClass()
    f.stringRepresentation = "a"

    println("This is a string repr ${f.stringRepresentation}")
}