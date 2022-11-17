package com.serega.lang.basic

import java.io.BufferedReader
import java.io.Closeable
import java.io.File
import java.io.FileReader

public inline fun <T : Closeable?, R> T.use2(block: (T) -> R): R {
    return block(this)
}

fun main() {

    val reader = BufferedReader(FileReader("data/advent/day1.txt"))
    val s: String? = reader.use2 {
        it.readLine()
    }
    println(s)

    val sum = File("data/advent/day1.txt").useLines { lines ->
        lines.sumBy { it.length }
    }
    println("Sum of lines: $sum")
}