package chap09.section4

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100))
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")

    println(list.all { it < 10})
    println(list.all { it % 2 == 0})

    println(list.any { it % 2 == 0})
    println(list.any { it > 10})

    println("contains: " + list.contains(2))
    println(2 in list)
    println(map.contains(11))
    println(11 in map)

    println("containsAll: " + list.containsAll(listOf(1, 2, 3)))

    println("none: " + list.none())
    println("none: " + list.none { it > 6})

    println(list.isEmpty())
    println(list.isNotEmpty())
}