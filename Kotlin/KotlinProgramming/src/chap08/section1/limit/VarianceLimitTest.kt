package chap08.section1.limit

open class Animal(val size: Int) {
    fun feed() = println("Feeding...")
}
class Cat(val jump: Int): Animal(50)
class Spider(val poison: Boolean): Animal(1)

class Box<out T: Animal>(val element: T) {
    fun getAnimal(): T = element
}

fun main() {
    val c1: Cat = Cat(10)
    val s1: Spider = Spider(true)

    var a1: Animal = c1
    a1 = s1
    println("a1.size = ${a1.size}")

    val c2: Box<Animal> = Box<Cat>(Cat(10))
    println("c2.element.size = ${c2.element.size}")
}