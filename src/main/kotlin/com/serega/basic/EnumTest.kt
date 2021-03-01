package com.serega.basic

enum class State {
    WALKING,
    RUNNING
}

fun main() {
    val state = State.WALKING

    val message = when (state) {
        State.WALKING -> "It's walking"
        State.RUNNING -> "It's running"
    }
    println(message)
}