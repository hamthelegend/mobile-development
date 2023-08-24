package activity1.simplified

fun main() {
    print("Enter a number: ")
    val number = readln().toInt()
    var factorial = 1
    for (n in 5 downTo 1) {
        factorial *= n
    }
    println("$number! is $factorial")
}