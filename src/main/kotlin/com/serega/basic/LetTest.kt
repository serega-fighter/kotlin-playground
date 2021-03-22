package com.serega.basic

fun customPrint(x: String) {
    print("***$x***")
}

fun printNonNull(str: String?) {
    println("Printing \"$str\":")

    str?.let {                         // 4
        print("\t")
        customPrint(it)
        println()
    }
}

fun printIfBothNonNull(strOne: String?, strTwo: String?) {
    strOne?.let { firstString ->       // 5
        strTwo?.let { secondString ->
            customPrint("$firstString : $secondString")
            println()
        }
    }
}

fun main() {
    printNonNull(null)
    printNonNull("my string")
    printIfBothNonNull("First","Second")
}