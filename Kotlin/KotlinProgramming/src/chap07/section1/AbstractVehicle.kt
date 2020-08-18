package chap07.section1

abstract class Vehicle(val name: String, val color: String, val weight: Double) {

    abstract var maxSpeed: Double

    var year = "2018"

    abstract fun start()
    abstract fun stop()

    fun displaySpecs() {
        println("Name: $name, Color = $color, Weight: $weight, Year: $year, Max Speed: $maxSpeed")
    }
}

class Car(name: String, color: String, weight: Double, override var maxSpeed: Double) : Vehicle(name, color, weight) {
    override fun start() {
        println("Car Started")
    }

    override fun stop() {
        println("Car stopped")
    }
}

class Motorcycle(name: String, color: String, weight: Double, override var maxSpeed: Double): Vehicle(name, color, weight) {
    override fun start() {
        println("Bike Started")
    }

    override fun stop() {
        println("Bike Stopped")
    }
}

fun main() {
    val car = Car("SuperMatiz", "yellow", 1110.0, 270.0)
    val motor = Motorcycle("DreamBike", "red", 173.0, 100.0)

    car.year = "2013"

    car.displaySpecs()
    car.start()
    motor.displaySpecs()
    motor.start()
}