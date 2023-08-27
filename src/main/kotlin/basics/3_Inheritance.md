# Inheritance

> For more in-depth information:\
> [Inheritance | Kotlin Documentation](https://kotlinlang.org/docs/inheritance.html)

Inheritance is another concept in object-oriented programming where you create a class based on another class.

```kotlin
// You need to declare your class as "open" to be inheritable.
open class Rectangle(val length: Double, val width: Double) {
    // You also need to declare a member as open to be overridable
    open val shapeName = "Rectangle" 
    
    fun getPerimeter(): Double {
        return 2 * (length + width)
    }

    fun getArea(): Double {
        return length * width
    }
}

// Since squares are a special type of rectangle with the same length and width,
// we can just inherit from Rectangle, so we don't need to reimplement getPerimeter and getArea.
// Here, we are initializing the rectangle to have the same length and width as the property side.
class Square(val side: Double) : Rectangle(side, side) {
    // Overriding an open property of Rectangle
    override val shapeName = "Square"
}

fun main() {
    val rectangle = Rectangle(3.0, 2.0)
    println(rectangle.shapeName) // Rectangle
    println(rectangle.length) // 3.0
    println(rectangle.width) // 2.0
    println(rectangle.getPerimeter()) // 10.0
    println(rectangle.getArea()) // 6.0
    
    val square = Square(3.0)
    println(square.shapeName) // Square
    println(square.side) // 3.0
    println(square.length) // 3.0
    println(square.width) // 3.0
    println(square.getPerimeter()) // 12.0
    println(square.getArea()) // 9.0
}
```

You can also declare a class and its members as abstract. An abstract class does not implement some or all of its members, thus you are not allowed to instantiate an abstract class directly. Instead, you should instantiate a class that implements the abstract class.
```kotlin
import kotlin.math.PI
import kotlin.math.pow

// An abstract class
abstract class Shape {
    abstract fun getPerimeter(): Double
    abstract fun getArea(): Double

    open fun printShape() {
        println("Perimeter = ${getPerimeter()}; Area = ${getArea()}")
    }
}

class Circle(val radius: Double) : Shape() {
    override fun getPerimeter(): Double {
        return 2.0 * PI * radius
    }

    override fun getArea(): Double {
        return PI * radius.pow(2)
    }

    override fun printShape() {
        println("Circumference = ${getPerimeter()}; Area = ${getArea()}")
    }
}

// Another class implementing an abstract class
open class Rectangle(val length: Double, val width: Double): Shape() {

    override fun getPerimeter(): Double {
        return 2 * (length + width)
    }

    override fun getArea(): Double {
        return length * width
    }
}

// A class inheriting from a concrete class
class Square(val side: Double) : Rectangle(side, side)

fun main() {
    val shape = Shape() // will not run since Shape is abstract
    
    val circle = Circle(3.0)
    circle.printShape() // Circumference = 18.85; Area = 28.27 (Doubles rounded off)

    val rectangle = Rectangle(3.0, 2.0)
    rectangle.printShape() // Perimeter = 10.0; Area = 6.0

    val square = Square(3.0)
    square.printShape() // Perimeter = 12.0; Area = 9.0
}
```