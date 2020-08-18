package chap09.section4

fun main() {
    val list1 = listOf(1, 2, 3, 4, 5, 6)
    val list2 = listOf(2, 2, 3, 4, 5, 5, 6, 7)

    println(list1.union(list2))
    println(list1.plus(list2))

    val part = list1.partition { it % 2 == 0}
    println(part)

    val zip = list1.zip(listOf(7, 8))
    println(zip)
}