package chap06.section2.bylazyobj

class Person(val name: String, val age: Int)

fun main() {
    var isPersonInstantiated: Boolean = false
    val person : Person by lazy {
        isPersonInstantiated = true
        Person("Kim", 23)
    }
    val personDelegate = lazy { Person("Hong", 40)}

    println("person Init = ${isPersonInstantiated}")
    println("personDelegate Init: ${personDelegate.isInitialized()}")

    println("person.name = ${person.name}")
    println("personDelegate = ${personDelegate.value.name}")

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")
}