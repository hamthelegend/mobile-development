# Object-oriented programming

Object-oriented programming is the concept of using objects to organize a program's logic. For example, you're making a first-person shooter. Your players can be represented by `Player` objects. Their guns can be their own objects as well. Then, you can call functions on your player and gun objects like `shoot()` or `useAbility()` to modify their behaviors and stats.

# Class

> For more in-depth information:\
> [Classes | Kotlin Documentation](https://kotlinlang.org/docs/classes.html)

A class is a blueprint for an object. It defines what properties and functions an object has. The contents of a class (properties, functions, etc.) are also known as class members.

```kotlin
// Declaring an empty class with no properties
class Player
```

An object is an instance of a class. When you create an instance of a class, that object will have all the properties of its class along with their default values. Creating an object is also referred to as instantiating a class.

```kotlin
// This is how you instantiate a class
val player = Player()
```

## Properties

Properties are just variables inside a class. A property can either be mutable or immutable, declared using the `var` and `val` keywords.

```kotlin
// This is a sample Player class with the properties hp, armor, and credits.
class Player {
    var hp = 100 // Mutable property
    var armor = 50
    var credits = 800
}
```

```kotlin
val player1 = Player()
val player2 = Player()

// You access the properties of an object using the dot operator (.)
println(player1.hp) // 100
println(player2.hp) // 100

// This is how you modify the mutable properties of an object.
player1.hp = 50
player2.hp = 25
println(player1.hp) // 50
println(player2.hp) // 25
```

## Constructor

We can think of constructors as special types of functions used to create objects. By default, if you did not declare any constructor for a class, Kotlin creates one for you with no parameters.

```kotlin
class Player {
    var name = ""
}

fun main() {
    val player = Player() // "Player()" is the default constructor
    player.name = "Andrea"
    println(player.name) // Andrea
}
```

We can provide parameters to a constructor, so we can immediately initialize its properties as soon as we create the object.

```kotlin
// Here, we are making our custom constructor for the Player class that requires a String parameter
class Player(name: String) {
    val name = name
}

fun main() {
    val player = Player("Andrea")
    println(player.name) // Andrea
}
```

If you are need a parameter just to set the value of a property directly, you can move the property declaration to the constructor. 

```kotlin
class Player(val name: String)

fun main() {
    val player = Player("Andrea")
    println(player.name) // Andrea
}
```

## Functions

Functions define the behaviors of a class.

```kotlin
class Player {
    var armor = 0
    var credits = 800
    
    fun buyShields() {
        armor += 25
        credits -= 400
    }
}

fun main() {
    val player = Player()
    println(player.armor) // 0
    println(player.credits) // 800
    
    player.buyShields() // Calling a function on an object
    println(player.armor) // 25
    println(player.credits) // 400
}
```

## Visibility

We can set a class member's visibility by appending a visibility modifier in front of the member's declaration. There are four visibility modifiers available for class members, but we will only talk about two for now:

`public` - the member is accessible anywhere, i.e., inside and outside the class. By default, all members are declared as public, so you don't need to append the `public` modifier.

`private` - the member is only accessible inside the class declaration.

```kotlin
class Player {
    var credits = 800 // public property
    private var charisma = 20 // private property
}

fun main() {
    val player = Player()
    println(player.credits) // 800
    println(player.charisma) // will not run, since charisma is private
    
    player.credits = 400 // will run
    player.charisma = 0 // will not run
}
```

## Encapsulation

Encapsulation is the concept of hiding access to members that do not need to be visible outside the class. This is to prevent anyone using the class from accidentally fucking up the objects they are dealing with.

```kotlin
// In Valorant, the damage done to a player is split 34%|66% between the hp and the armor.
// We do not want to accidentally put all the damage towards the hp, without touching the armor.
// We can set both hp and armor to private, so we cannot modify them outside the class.
// Then, we can make a function that handles the damage division for us.
class Player {
    private var hp = 100
    private var armor = 50
    
    fun takeDamage(damage: Int) {
        val damageToArmor = damage.toDouble() * 0.66
        armor -= damageToArmor
        
        val damageToHp = damage - damageToArmor
        hp -= damageToHp
    }
}

fun main() {
    val player = Player()
    player.hp -= 100 // will not run, since hp is private
    player.armor -= 50 // will not run, since armor is private
    
    // Instead, we should call the takeDamage function
    player.takeDamage(100)
    
    // However, since both hp and armor are private, we cannot get their values.
    println(player.hp) // will not run, since hp is private
    println(player.armor) // will not run, since armor is private
}
```

We can make a property publicly readable, yet only mutable inside its class by using the `private set` modifier.

```kotlin
class Player {
    var hp = 100
        private set
    var armor = 50
        private set

    fun takeDamage(damage: Int) {
        val damageToArmor = damage.toDouble() * 0.66
        armor -= damageToArmor

        val damageToHp = damage - damageToArmor
        hp -= damageToHp
    }
}

fun main() {
    val player = Player()
    player.hp -= 100 // will not run, since hp's setter is private
    player.armor -= 50 // will not run, since armor's setter is private

    player.takeDamage(100)

    // These will now work since hp and armor's getters are public.
    println(player.hp)
    println(player.armor)
}
```