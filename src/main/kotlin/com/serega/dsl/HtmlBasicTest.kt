package com.serega.html

import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun main() {
    val s = createHTML().
        html {
            body {
                div {
                    b {
                        + "AAAA"
                    }
                    br {

                    }
                    a("https://kotlinlang.org") {
                        target = ATarget.blank + "Main site"
                    }
                }
            }
        }

    println(s)
}