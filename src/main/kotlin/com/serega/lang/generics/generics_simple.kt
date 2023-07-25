package com.serega.lang.generics

import kotlin.reflect.typeOf

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

inline fun <reified T> renderType(): String {
    val type = typeOf<T>()
    return type.toString()
}

fun main() {
    val fromExplicitType = typeOf<Int>()
    println(fromExplicitType)
    val fromReifiedType = renderType<List<Int>>()
    println(fromReifiedType)
}