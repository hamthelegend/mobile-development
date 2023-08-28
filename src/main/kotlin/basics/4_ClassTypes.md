# Class types

## Data class

> For more in-depth information:\
> [Data classes | Kotlin Documentation](https://kotlinlang.org/docs/data-classes.html)

In Kotlin, a data class is a class that is designed to hold data.

```kotlin
class Player(var hp: Int, var armor: Int)

fun main() {
    val player1 = Player(100, 0)
    
    // Printing a regular class instance will return its address.
    println(player1) // Player@404b9385 (or something similar)
    
    val player2 = Player(100, 0)
    
    // Even tho player1 and player2 have the exact same values, player1 still does not equal player2.
    // This is because regular classes do not implement the equals function.
    // Without an implementation of equals, Kotlin will check if they are the same object instead.
    // In this case, they aren't the same object. They just happen to have the same values.
    println(player1 == player2) // false
    
    // Example of being the same object
    val player3 = player2
    println(player2 == player3) // true
    
    // Since player2 and player3 are the same object, modifying the properties of player3 will also change player2.
    player3.hp = 50
    println(player3.hp) // 50
    println(player2.hp) // 50
}
```

```kotlin
data class Player(var hp: Int, var armor: Int)

fun main() {
    val player1 = Player(100, 0)
    
    // println calls the class's toString function to convert the object to a String.
    // A regular class doesn't have its own implementation of toString,
    // that's why printing an instance of it only returns its address.
    // However, a data class implements the toString function based on the properties declared in its primary constructor.
    println(player1) // Player(hp = 100, armor = 0)
    
    val player2 = Player(100, 0)
    
    // Data classes also implement the equals function.
    // dataObjectA == dataObjectB if the properties declared in their primary constructors are the same.
    println(player1 == player2) // true
    
    val player3 = player2
    // If you want to check if two variables reference the same object, use the referential equality operator ===
    println(player1 === player2) // false
    println(player2 === player3) // true
}
```

## Object

> For more in-depth information:\
> [Object expressions and declarations | Kotlin Documentation](https://kotlinlang.org/docs/object-declarations.html)

An object is an instance of a class, as we have discussed before. In Kotlin, you can declare a class with only one instance known as a singleton.

```kotlin
// This is how you declare a singleton
object Game {
    var highScore = 10
    var topPlayer = "Lemuel"
}

fun main() {
    // You do not create instances of Game; it is already an object by itself.
    val game = Game() // This will not compile
    
    // Instead, you call its properties directly.
    Game.highScore = 100
    Game.topPlayer = "Andrey"
}
```

## Enum class

> For more in-depth information:\
> [Enum classes | Kotlin Documentation](https://kotlinlang.org/docs/enum-classes.html)

An enum class is a class that defines all its instances inside itself; you cannot instantiate it outside itself.

```kotlin
// For example, you want to create a function to check if a device is a phone or a tablet.
// We can represent the return value as a Boolean, true if it's a phone, false if it's a tablet.
fun isPhone(sizeInInches: Double): Boolean {
    return sizeInInches < 7
}

// However, what if we want to classify laptops separately?
// We cannot do that with a Boolean, since a Boolean only has 2 states.
// We can represent it as Ints.
fun getDeviceCategory(sizeInInches: Double): Int {
    when {
        sizeInInches < 7 -> return 0 // 0 for phones
        sizeInInches < 13 -> return 1 // 1 for tablets
        else -> return 2 // 2 for laptops
    }
}

fun main() {
    val deviceCategory = getDeviceCategory(5)
    
    // The problem with this solution is it gets confusing which integer corresponds to what device category.
    if (deviceCategory != 0) {
        println("I don't want that. I want a phone.")
    }
}
```

```kotlin
// To fix this, we can return an instance of an enum class instead.
enum class DeviceCategory {
    Phone, Tablet, Laptop
}

fun getDeviceCategory(sizeInInches: Double): DeviceCategory {
    when {
        sizeInInches < 7 -> return DeviceCategory.Phone
        sizeInInches < 13 -> return DeviceCategory.Tablet
        else -> return DeviceCategory.Laptop
    }
}

fun main() {
    val deviceCategory = getDeviceCategory(5)
    
    // This code is much more readable.
    if (deviceCategory != DeviceCategory.Phone) {
        println("I don't want that. I want a phone.")
    }
}
```

## Sealed classes and interfaces

> If you want to learn about sealed classes and interfaces, read more from the link below. However, it is not absolutely necessary to learn these for now.\
> [Sealed classes and interfaces | Kotlin Documentation](https://kotlinlang.org/docs/sealed-classes.html)\