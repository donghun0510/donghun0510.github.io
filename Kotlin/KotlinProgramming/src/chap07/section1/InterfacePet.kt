package chap07.section1

interface Pet {
    var category: String
    val msgTags: String
        get() = "I'm your lovely pet!"

    var species: String
    fun feeding()
    fun patting() {
        println("Keep patting!")
    }
}

class Cat (name: String, override var category: String) : Pet, Animal(name) {
    override var species: String = "dog"
    override fun feeding() {
        println("Feed the cat a tuna can!")
    }
}

fun main() {
    val obj = Cat("Coco", "BigFat")
    println("Pet Category: ${obj.category}")
    obj.feeding()
    obj.patting()
}