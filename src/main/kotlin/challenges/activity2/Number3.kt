package challenges.activity2

import kotlin.math.PI
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

abstract class Shape {
    abstract val perimeter: Double
    abstract val area: Double
    abstract fun printShape()
}

class Circle(val radius: Double): Shape() {
    override val perimeter = 2 * PI * radius
    override val area = PI * radius.pow(2)
    override fun printShape() {
        println("Circle(radius = $radius, circumference = $perimeter, area = $area)")
    }
}

open class Rectangle(val sideA: Double, val sideB: Double): Shape() {
    override val perimeter = 2 * sideA + 2 * sideB
    override val area = sideA * sideB
    override fun printShape() {
        println("Rectangle(length = ${max(sideA, sideB)}, width = ${min(sideA, sideB)}, perimeter = $perimeter, area = $area)")
    }
}

class Square(val side: Double): Rectangle(sideA = side, sideB = side) {
    override fun printShape() {
        println("Square(side = $side, perimeter = $perimeter, area = $area)")
    }
}