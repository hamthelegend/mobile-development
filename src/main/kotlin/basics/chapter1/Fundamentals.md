# Fundamentals

> For more in-depth information:\
> [Basic syntax | Kotlin Documentation](https://kotlinlang.org/docs/basic-syntax.html)

## Program entry point

A Kotlin program starts running from your main function.

```kotlin
fun main() {
    // Your program starts here
    println("Hey, bitches!")
}
```

## Comments

You can add comments/documentation to your code by
writing `//` in front of it. The compiler will
ignore everything you write after `//`. You can also
write comments in between `/*` and `*/`.

```kotlin
// You can write a comment here
val a = 7 // You can also write a comment here
println("a + b" /* Even inside your code */) // This will only print "a + b"
```

## Input/Output

`println` prints the arguments you provide inside it.

```kotlin
println("Hey, bitches!")
println("What's up?")

// Output:
// Hey, bitches!
// What's up?
```

Use `print` if you don't want a line break after.

```kotlin
print("Hey, ")
print("bitches!")

// Output:
// Hey, bitches!
```

Use `readln` to get a `String` from the user.

```kotlin
val input = readln()
// User input: 
// Fuck you!
println(input)
// Output: 
// Fuck you!
```

## Variables

Variables declared with the `val` keyword are immutable,
meaning they cannot be modified once you have already set them.

```kotlin
val a = 1
a = 2 // will not compile
```

Variables declared with the `var`, on the other hand keyword are mutable.

```kotlin
var b = 1
println(b) // 1
b = 2
println(b) // 2
```

> **Note:** You should always declare a variable with the `val` keyword
> unless you are sure that you have to mutate it later.

## Data types

> For more in-depth information:\
> [Basic types | Kotlin Documentation](https://kotlinlang.org/docs/basic-types.html)

Here are some of Kotlin's basic data types:

| Type    | Description              | Example |
|---------|--------------------------|---------|
| Int     | whole numbers (integers) | `32`    |
| Double  | fractional numbers       | `7.5`   |
| Boolean | `true` or `false`        | `true`  |
| Char    | a single character       | `'a'`   |
| String  | a string of characters   | `Bitch` |

Kotlin automatically assigns a variable a data type
based on the value you assigned to it. You can write
a variable's data type explicitly, but most of the time,
you don't need to.

```kotlin
val a = 7 // Int
val b = "Hello" // String

// These also work just fine:
val a: Int = 7
val b: String = "Hello"
```

> **Note**: Kotlin has some built-in functions that
> allow you to convert a data type to another.
> For example, `String.toInt()` converts a `String`
> to an `Int`.
> ```kotlin
> val a = "7" // String
> val b = a.toInt() // Int
> ```

## Conditional statements

### if-else

`if-else` statements in `Kotlin` have the exact syntax as in C.

```kotlin
val a = readln().toInt()
val b = readln().toInt()
if (a > b) {
    println("a is greater than b.")
} else if (a == b) {
    println("a equals b.")
} else {
    println("a is less than b.")
}
```

### when

`when` statements are similar to C's `switch` statements.
They allow you to compare a value against multiple
possible values.

```kotlin
val monthNumber = readln().toInt()
when (monthNumber) {
    1 -> println("January")
    2 -> println("February")
    3 -> println("March")
    else -> println("Sorry, I only know January, February, and March.")
}

// That when statement is equivalent to this if-else
if (monthNumber == 1) {
    println("January")
} else if (monthNumber == 2) {
    println("February")
} else if (monthNumber == 3) {
    println("March")
} else {
    println("Sorry, I only know January, February, and March.")
}
```

You can also use `when` as a complete substitute to `if-else` statements.

```kotlin
// length represents the length of a charging cable
val length = readln().toInt()
if (length < 4) {
    println("That's too short!")
} else if (length < 8) {
    println("That's ehh, but fine.")
} else if (length >= 8) {
    println("That's what I want.")
}

// That if-else can be replaced by this when
when {
    length < 4 -> println("That's too short!")
    length < 8 -> println("That's ehh, but fine.")
    length >= 8 -> println("That's what I want.")
}
```

## Relational operators

Relational operators allow you to compare two values and return either
`true` or `false` (a `Boolean`).

| Operator | Description              |
|----------|--------------------------|
| `==`     | equal to                 |
| `!=`     | not equal to             |
| `<`      | less than                |
| `>`      | greater than             |
| `<=`     | less than or equal to    |
| `>=`     | greater than or equal to |

Example: `7 < 5` returns `false`

## Conditional operators

Conditional operators, also known as boolean operators,
returns a `Boolean` based on the `Boolean` values you used it for.

| Operator | Name | Description                                                  |
|----------|------|--------------------------------------------------------------|
| `\|\|`   | OR   | `true` when either operands is `true`, `false` if otherwise. |
| `&&`     | AND  | `true` when both operands are `true`, `false` if otherwise.  |
| `!`      | NOT  | `true` if its operand is `false`, `false` if it is `true`.   |

```kotlin
5 > 7 || 7 == 7 // true
!(5 > 7 || 7 == 7) // false
```

## Collections

### Lists

A list stores an ordered collection of values.
You can access its elements by their indices.

```kotlin
val fruits = listOf("apple", "banana", "kiwi", "apple")
println(fruits) // [apple, banana, kiwi, apple]
println(fruits[0]) // "apple"
println(fruits[1]) // "banana"
println(fruits[2]) // "kiwi"
println(fruits[3]) // "apple"
```

### Sets

A set stores an unordered collection of values.
Unlike lists, sets automatically remove duplicates,
and they do not allow you to access its elements
by their indices.

```kotlin
val fruits = setOf("apple", "banana", "kiwi", "apple")
println(fruits) // [apple, banana, kiwi]
println(fruits[0]) // will not compile
```

### Maps

A map stores a collection of key-value pairs.
You can access a map's value by its key.

```kotlin
val fruitColors = mapOf("apple" to "red", "banana" to yellow)
println(fruitColors["apple"]) // "red"
println(fruitColors["banana"]) // "yellow"
```

## Loops

### for loops

A for loop iterates through the elements of
an iterable collection.

```kotlin
val fruits = listOf("apple", "banana", "kiwi", "apple")
for (fruit in fruits) {
    println(fruit)
}

// Output:
// apple
// banana
// kiwi
// apple
```

### while loops

A while loop runs the code block inside it repeatedly
as long as the condition inside it is `true`.

```kotlin
val fruits = listOf("apple", "banana", "kiwi", "apple")
var index = 0
while (index < fruits.size) {
    println(fruits[index])
    index++
}

// Output:
// apple
// banana
// kiwi
// apple
```

## Ranges

A range is a data type that represents a range between two numbers.
Mostly used for looping over a range of integers.

```kotlin
for (number in 1..5) {
    println(number)
}

// Output:
// 1
// 2
// 3
// 4
// 5
```

## Functions

Kotlin allows you to separate some of the logic of your program
into reusable functions. This will simplify your other code by
hiding that function's complexity from the place it was called.

```kotlin
// Defining a function
fun printDivider() {
    println("----------------------------------------------")
}

// Defining a function with parameters
fun greet(name: String) {
    println("Hey, $name")
}

// Defining a function with a return value
fun isEven(x: Int): Boolean {
    return x % 2 == 0
}

fun main() {
    printDivider()
    // ----------------------------------------------

    greet("bitch")
    // Hey, bitch

    println(isEven(2))
    // true

    println(isEven(1))
    // false
}
```

## String templates

This allows you to substitute values into a `String`,
so you don't have to do verbose concatenations.

```kotlin
val a = readln().toInt()
println("$a is ${if (isEven(a)) "even" else "odd"}")
// You can use $name for simple variable names
// You can use ${expression} for anything else that's more complicated that a single variable
```

## Nullability

`null` is a common concept in programming. A variable set to `null`
means it does not have any value. An integer set to null is not
the same as it being set to 0. We can compare the difference
between a 0 and a null to having a 0 score for a test and not
having a score for the test at all.

Unlike in languages like Java and C++, Kotlin
does not allow you to assign `null` values to variables by default.
This is to prevent you from trying to get a property or running
a function to a null value, crashing your program.

If you want to make a variable nullable, you must explicitly
set its data type to be nullable with the symbol `?`.

```kotlin
// This will not compile
var numberA = 7
numberA = null // This ain't allowed babe

// This will compile
var numberB: Int? = 7 // This is how you do nulls bb
numberB = null
```

Kotlin is very strict with nulls. It will not allow you to
access properties or call functions to a nullable variable
unless you make the call optional.

```kotlin
val myInt: Int? = null
val myFloat = myInt.toFloat() // Nah, bitch. This ain't allowed.

val myFloat = myInt?.toFloat() // Now, this is okay, but myFloat is also nullable
```

Kotlin can automatically cast a nullable variable
to a non-nullable variable by using a null check.

```kotlin
val myInt: Int? = null

if (myInt != null) {
    val myFloat = myInt.toFloat()
    // This will run just fine since Kotlin is already sure that myInt is not a null.
    // In other words, it smart-casted myInt from Int? to Int because of the null check.
}
```