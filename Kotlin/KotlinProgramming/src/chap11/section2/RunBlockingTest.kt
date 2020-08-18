package chap11.section2

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch {
        delay(1000L)
        println("WOrld!")
    }
    println("Hello")
}