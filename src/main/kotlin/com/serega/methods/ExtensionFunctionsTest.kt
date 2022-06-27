package com.serega.methods


/**
 * Extension functions are dispatched statically, which means they are not virtual by receiver type.
 * An extension function being called is determined by the type of the expression on which the function
 * is invoked, not by the type of the result from evaluating that expression at runtime. For example:
 */
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

class X {}

fun Any?.toStringExt(): String {
    if (this == null) return "null"
    // after the null check, 'this' is autocast to a non-null type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}

fun main() {
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2)
    println(list)

    val z = X()
    println(z.toStringExt())
    val z2 = null
    println(z2.toStringExt())
}