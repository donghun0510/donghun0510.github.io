package chap11.section3

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun CoroutineScope.producer(): ReceiveChannel<Int> = produce {
    var total: Int = 0
    for(x in 1..5) {
        total += x
        send(total)
    }
}

fun main() = runBlocking {
    val result = producer()
    result.consumeEach { print(" $it ")}
}