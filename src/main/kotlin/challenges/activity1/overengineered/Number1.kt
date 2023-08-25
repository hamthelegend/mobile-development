package challenges.activity1.overengineered

enum class Parity {
    Odd,
    Even,
}

val Int.parity get() = if (this % 2 == 0) Parity.Even else Parity.Odd

fun main() {
    print("Enter a number: ")
    val string = readln()
    val number = string.toIntOrNull()
    if (number != null) {
        println("$number is ${if (number.parity == Parity.Odd) "odd" else "even"}.")
    } else {
        println("$string is not a number.")
    }
}
