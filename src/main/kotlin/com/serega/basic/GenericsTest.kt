package com.serega.basic

class Box<T>(t: T) {
    var value = t
}

class Source<out T>(private val value: T) {

    fun produce(): T {
        return value
    }
}

class Producer<in T> {

    fun consume(value: T) {
        println(value)
    }
}

fun main() {
    val strSource = Source("ABC")
    val anySource: Source<Any> = strSource


}