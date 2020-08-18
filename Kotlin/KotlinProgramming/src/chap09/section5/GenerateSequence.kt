package chap09.section5

fun main() {
    val nums: Sequence<Int> = generateSequence(1) {it +1}

    println(nums.take(10).toList())

    val squares = generateSequence(1) {it + 1}.map {it * it}
    println(squares.take(10).toList())

    val oddSquares = squares.filter {it % 2 != 0}
    println(oddSquares.take(5).toList())
}