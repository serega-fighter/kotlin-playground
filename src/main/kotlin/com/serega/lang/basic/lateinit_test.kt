package com.serega.lang.basic

class TestClass {

    lateinit var subject: String

    fun init() {
        subject = "subject was initialized"
    }

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

    f.init()
    println(f.subject)
}