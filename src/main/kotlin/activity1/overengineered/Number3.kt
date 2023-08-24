package activity1.overengineered

val Int.divisors get() = (1..this).filter { this % it == 0 }

fun gcd(n1: Int, n2: Int): Int {
    val commonDivisors = n1.divisors.filter { it in n2.divisors }
    return commonDivisors.max()
}

fun main() {
    print("Enter your first number: ")
    val stringA = readln()
    val numberA = stringA.toIntOrNull()
    if (numberA != null) {
        print("Enter your second number: ")
        val stringB = readln()
        val numberB = stringB.toIntOrNull()
        if (numberB != null) {
            println("The GCD of $numberA and $numberB is ${gcd(numberA, numberB)}")
        } else {
            println("$stringB is not a number.")
        }
    } else {
        println("$stringA is not a number.")
    }
}