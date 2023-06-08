package com.serega.patterns.err

/*
This is why the rule is that we should prefer
returning null or Failure when an error is expected, and
throwing an exception when an error is not expected
*/

inline fun <reified T> String.readObject(default: T): Result<T> {
    //...
    var incorrectSign = false // ...
    if(incorrectSign) {
        return Failure(JsonParsingException())
    }
    //...
    return Success(default)
}

sealed class Result<out T>
class Success<out T>(val result: T): Result<T>()
class Failure(val throwable: Throwable): Result<Nothing>()

class JsonParsingException: Exception()

fun main() {

}