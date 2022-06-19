package com.serega.basic


class TestPair(private val field1: Int, private val field2: String) {
    operator fun component1(): Int {
        return field1
    }

    operator fun component2(): String {
        return field2
    }
}

class TestTriple(private val field1: Int, private val field2: String, private val field3: Double) {
    operator fun component1(): Int {
        return field1
    }

    operator fun component2(): String {
        return field2
    }

    operator fun component3(): Double {
        return field3
    }
}

fun main() {
    val p = TestPair(5, "ABC")
    val (f1, f2) = p

    println(f1)
    println(f2)

    val list = listOf(TestPair(5, "A"), TestPair(6, "B"))
    for ((x1, x2) in list) {
        println(x1)
        println(x2)
    }

    val tri = TestTriple(5, "A", 1.0)
    val (y1, y2, y3) = tri
    println(y1)
    println(y2)
    println(y3)
}