import kotlin.system.measureTimeMillis

fun main() {
    var sum:Long = 0
    var bin:Int = 0
    for(i in 1..10000){
        val elapsed: Long = measureTimeMillis {
            for(j in 1..100000) {
                if(bin == 0) {
                    bin++
                }
                else {
                    bin--
                }
            }
        }
        sum += elapsed
    }
    println("수행 시간 합: $sum")
}