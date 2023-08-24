package activity1.overengineered

fun Int.factorial() = (this downTo 1).reduce { product, i -> product * i }

fun main() {
    print("Enter a number: ")
    val string = readln()
    val number = string.toIntOrNull()
    if (number != null) {
        println("$number! is ${number.factorial()}")
    } else {
        println("$string is not a number.")
    }
}