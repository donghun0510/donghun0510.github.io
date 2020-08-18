package chap11.section3

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }finally {
            withContext(NonCancellable) {
                println("I'm runnung finally")
                delay(1000L)
            }
            println("Non-Cancellable")
            println("Bye!")
        }
    }
    delay(1300L)
    job.cancelAndJoin()
    println("main: Quit!")
}