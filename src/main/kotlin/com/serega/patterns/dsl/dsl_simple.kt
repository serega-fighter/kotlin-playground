package com.serega.patterns.dsl

interface Element {

}

class HTML {

    private val children: MutableList<Element> = mutableListOf()

    fun head(init: Head.() -> Unit) = initTag(Head(), init)

    fun body(init: Body.() -> Unit) = initTag(Body(), init)

    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }
}

class Head : Element {

}

class Body : Element {

}

fun html(initMethod: HTML.() -> Unit): HTML {
    val html = HTML()
    html.initMethod()
    return html
}

fun main() {

    html {
        head {

        }
        body {

        }
    }
}