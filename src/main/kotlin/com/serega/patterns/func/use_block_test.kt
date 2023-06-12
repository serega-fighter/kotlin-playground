package com.serega.patterns.func

import java.io.BufferedReader
import java.io.Closeable
import java.io.File
import java.io.FileReader

/*
 * An example of custom block method for reader using extension functions
 */

inline fun <T : Closeable?, R> T.useCustom(block: (T) -> R): R {
    return block(this)
}

fun main() {

    val reader = BufferedReader(FileReader("data/advent/day1.txt"))
    val s: String? = reader.useCustom {
        it.readLine()
    }
    println(s)

    val sum = File("data/advent/day1.txt").useLines { lines ->
        lines.sumBy { it.length }
    }
    println("Sum of lines: $sum")
}