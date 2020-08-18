package chap11.section3

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

fun main() = runBlocking<Unit> {
    val channel = Channel<Int> ()
    launch {
        for(x in 1..5) channel.send(x*x)
        channel.close()
    }
    for(element in channel) println(element)
    println("Done!")
}