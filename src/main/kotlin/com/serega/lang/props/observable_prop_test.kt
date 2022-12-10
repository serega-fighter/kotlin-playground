package com.serega.lang.props

import kotlin.properties.Delegates

data class Item(val name: String) {

}

class X {

    var items: List<Item> by
    Delegates.observable(listOf()) { _, from, to ->
        println("data $from changed to $to")
    }

}

fun main() {
    val x = X()
    x.items += Item("ABC")
    x.items = listOf()
}