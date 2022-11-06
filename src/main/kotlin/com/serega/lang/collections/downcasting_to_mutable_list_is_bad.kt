package com.serega.lang.collections

fun main() {

    // returns Arrays.ArrayList
    val list = listOf(1,2,3)

    if (list is MutableList) {
        list.add(4)
    }

    /*
    Exception in thread "main" java.lang.UnsupportedOperationException
	at java.base/java.util.AbstractList.add(AbstractList.java:153)
	at java.base/java.util.AbstractList.add(AbstractList.java:111)
	at com.serega.lang.collections.FKt.main(f.kt:8)
    */
}