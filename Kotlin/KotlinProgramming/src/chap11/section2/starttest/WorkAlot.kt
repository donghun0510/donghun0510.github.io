package chap11.section2.starttest

import kotlinx.coroutines.*

fun main() = runBlocking {
    val jobs = List(100_000) {
        launch {
            delay(1000L)
            print(".")
        }
    }
    jobs.forEach { it.join()}
}