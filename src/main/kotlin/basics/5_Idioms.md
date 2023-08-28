# Idioms

> For more in-depth information:\
> [Idioms | Kotlin Documentation](https://kotlinlang.org/docs/idioms.html)

Learning to write Kotlin fluently includes learning its idioms. It is not necessary to learn all of them, but learning a
few will make your code easier to write and read.

## Conditional expressions

A statement is a piece of code that does not return any values.

```kotlin
// A while-loop is a statement
while (true) { /* ... */ }
```

An expression, on the other hand, is a piece of code that does return a value. An expression can be assigned to a
variable or passed as a function argument.

```kotlin
// Sample expressions:
val a = 7
val b = "hello".uppercase()
val c = readln()
println(8.0)
```

If-else and when statements can also be used as expressions, as long as you exhaust all the possible cases, usually with
an else clause.

```kotlin
val number = readln().toInt()

// Assigning an if-else expression to a variable
val parity = if (number % 2 == 0) "Even" else "Odd"

// Printing a when expression
println(
    when (number % 2) {
        0 -> "Even"
        else -> "Odd"
    }
)
```

## Named arguments

You can provide arguments to your functions in any order you want as long as you write which argument corresponds to
which parameter.

```kotlin
fun getRectangleArea(length: Double, width: Double): Double { /* ... */ }

fun main() {
    val rectangleArea = getRectangleArea(width = 2.0, length = 3.0)
}
```

## Default arguments

You can provide default arguments to function parameters.
These arguments will then be used if you did not provide arguments to these parameters.

```kotlin
fun greet(name: String, allCaps: Boolean = true) {
    val greeting = "Hello, $name!"
    println(if (allCaps) greeting.uppercase() else greeting)
}

fun main() {
    greet("Carl") // HELLO, CARL!
    greet("Carl", false) // Hello, Carl!
    greet("Carl", true) // HELLO, CARL!
}
```

## Single-expression functions

If your function is very simple, you can omit the curly braces, return type, and the return keyword and just write it all in one line.

```kotlin
fun isEven(number: Double) = if (number % 2 == 0) Parity.Even else Parity.Odd

// is equivalent to
fun isEven(number: Double): Double {
    return if (number % 2 == 0) Parity.Even else Parity.Odd
}
```

## in operator

You can check if an element is in a collection using `collection.contains(element)` or `element in collection`.

```kotlin
fun main() {
    val fruits = listOf("apple", "grapes", "kiwi")
    if ("banana" in fruits) {
        println("Let's go!")
    } else {
        println("Me wants banana :(")
    }
}
```

## is operator

You can check if a variable is a certain type using the `is` operator.

```kotlin
fun printNumberType(number: Number) {
    println(
        when (number) {
            is Int -> "$number is an Int."
            is Double -> "$number is a Double."
            else -> "$number is neither an Int nor a Double."
        }
    )
}
```

## Extension functions

You can write functions for classes you didn't write with extension functions. However, you can only access the public properties of that class in your extension function.

```kotlin
fun Int.getParity() = if (this % 2 == 0) Parity.Even else Parity.Odd

fun main() {
    val number = readln().toInt()
    val parity = number.getParity()
}
```

## Elvis operator

You can use the elvis operator `?:` to specify the default value of a nullable expression in case it is null.

```kotlin
val numbers = listOf(1, 2, 3)

// getOrNull returns null if the index is out of bounds
val tenthElement = numbers.getOrNull(9) ?: 0 // if number.getOrNull(9) returns null, return 0 instead
println(tenthElement) // 0

println(null ?: "Hey") // Hey
```