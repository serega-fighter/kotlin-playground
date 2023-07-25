package com.serega.advent

import java.io.File

fun main() {
    val numbers = File("data/advent/day1.txt")
            .readLines()
            .map(String::toInt)

    val complements = numbers.associateBy { 2020 - it }

    println(complements)

    val pair = numbers.mapNotNull { number ->
        val complement = complements[number]
        if (complement != null) Pair(number, complement) else null
    }.firstOrNull()

    println(pair)

    println(pair?.let { (a, b) -> a * b })
}