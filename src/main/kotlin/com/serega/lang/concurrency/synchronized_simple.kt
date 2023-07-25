package com.serega.lang.concurrency

import kotlin.concurrent.thread

fun main() {
    val lock = Any()
    var num = 0

    for (i in 1..10000) {
        thread {
            Thread.sleep(10)
            synchronized(lock) {
                num += 1
            }
        }
    }

    Thread.sleep(1000)
    print(num) // 1000
}