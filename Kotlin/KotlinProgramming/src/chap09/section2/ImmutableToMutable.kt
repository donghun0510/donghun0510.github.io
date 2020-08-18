package chap09.section2

fun main() {
    val names: List<String> = listOf("one", "two", "three")
    val mutableNames = names.toMutableList()
    mutableNames.add("four")
    println(mutableNames)
}