package chap11.section3

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking<Unit> {
    val channel = Channel<Int>(3)
    val sender = launch(coroutineContext) {
        repeat(10) {
            println("Sending $it")
            channel.send(it)
        }
    }
    delay(1000)
    sender.cancel()
}