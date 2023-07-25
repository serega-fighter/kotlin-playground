package com.serega.advent

import java.io.File

data class PasswordWithPolicy(
        val password: String,
        val range: IntRange,
        val letter: Char
) {
    companion object {
        fun parse(line: String) = PasswordWithPolicy(
                password = line.substringAfter(": "),
                letter = line.substringAfter(" ").substringBefore(":").single(),
                range = line.substringBefore(" ").let {
                    val (start, end) = it.split("-")
                    start.toInt()..end.toInt()
                },
        )
    }

    fun validatePartTwo() =
            (password[range.first - 1] == letter) xor (password[range.last - 1] == letter)

    fun validatePartOne() =
            password.count { it == letter } in range
}

fun main() {
    val passwords = File("data/advent/day2.txt")
            .readLines()
            .map(PasswordWithPolicy::parse)
    println(passwords.count { it.validatePartOne() })
    println(passwords.count { it.validatePartTwo() })
}