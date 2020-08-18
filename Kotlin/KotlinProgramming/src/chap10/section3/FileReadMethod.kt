package chap10.section3

import java.io.*

fun main() {
    val path = "C:\\Users\\user\\Desktop\\Over the Rainbow"
    /*
    val file = File(path)
    val inputStream: InputStream = file.inputStream()
    val inputStreamReader = InputStreamReader(inputStream)
    val sb = StringBuilder()
    var line: String?
    val br = BufferedReader(inputStreamReader)
    try {
        line = br.readLine()
        while(line != null) {
            sb.append(line, '\n')
            line = br.readLine()
        }
        println(sb)
    } catch (e: Exception) {

    }finally {
        br.close()
    }*/
    val file = File(path)
    val inputStream: InputStream = file.inputStream()
    val text = inputStream.bufferedReader().use {it.readText()}
    println(text)
}