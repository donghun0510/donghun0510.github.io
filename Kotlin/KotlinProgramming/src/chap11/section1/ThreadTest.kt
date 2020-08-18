package chap11.section1

class SimpleThread: Thread() {
    override fun run() {
        println("Current Thread: ${Thread.currentThread()}")
    }
}

class SimpleRunnable: Runnable {
    override fun run() {
        println("Current Thread: ${Thread.currentThread()}")
    }
}

fun main() {
    val thread = SimpleThread()
    thread.start()

    val runnable = SimpleRunnable()
    val thread1 = Thread(runnable)
    thread1.start()
}