package com.serega.lang.basic

import java.io.File
import javax.sql.DataSource

sealed interface Error

sealed class IOError(): Error

class FileReadError(val f: File): IOError()
class DatabaseError(val source: DataSource): IOError()

fun main() {

    fun log(e: Error) = when(e) {
        is FileReadError -> { println("Error while reading file ${e.f}") }
        is DatabaseError -> { println("Error while reading from database ${e.source}") }
        // the `else` clause is not required because all the cases are covered
    }
}