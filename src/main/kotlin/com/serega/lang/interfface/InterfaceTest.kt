package com.serega.lang.interfface

interface Element {
    val active: Boolean
}

class ActualElement: Element {
    override var active: Boolean = false
}

fun main() {

}