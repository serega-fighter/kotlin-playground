package com.serega.lang.basic

data class Person(val name: String, val age: Int) {

}

fun print(p: Person) {
    println(p)
}

fun main() {

    println(Person("A", 25) == Person("B", 26))

    println(Person("A", 25).copy())

    print(Person("ABC", 40))
}