package com.serega.lang.functions


class NewCalls {

    // @kotlin.internal.InlineOnly Specifies that this function should not be called directly without inlining
    public inline fun <R> synchronized(lock: Any, block: () -> R): R {
        return block.invoke()
    }
}

fun main() {
    synchronized("ABC") {
        println("ZXVZXAS")
    }

    val result: String = synchronized("ABC") {
        "CZXC"
    }
    println(result)
}