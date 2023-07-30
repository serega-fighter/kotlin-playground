package com.serega.idioms

sealed interface User {
    val a: Long
    val b: String

    companion object {
        operator fun invoke(a: Long, b: String): User {
            return UserModel.create(a, b)
        }
    }

    private data class UserModel private constructor(
        override val a: Long,
        override val b: String
    ) : User {
        companion object {
            fun create(a: Long, b: String): User {
                return UserModel(a, b)
            }
        }
    }
}

fun main() {
    println(User(5, "ABC"))
}