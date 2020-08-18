package chap10.section3

import java.io.*

fun main() {
    val path = "C:\\Users\\user\\Desktop\\Over the Rainbow.txt"

    try {
        val read = FileReader(path)
        println(read.readText())
    } catch (e: Exception) {
        println(e.message)
    }
}