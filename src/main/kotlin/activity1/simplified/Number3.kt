package activity1.simplified

import kotlin.math.min

fun main() {
    print("Enter your first number: ")
    val n1 = readln().toInt()
    print("Enter your second number: ")
    val n2 = readln().toInt()

    var gcd = 1

    // We loop from 1 to n1 or n2, which ever is lower,
    // since the divisor cannot be larger than any of the two numbers.
    // The min(p1, p2) function returns whichever is lower between
    // p1 and p2, hence "min" for minimum.
    // We skipped possibleDivisor = 1, since gcd is already set to 1,
    // and all numbers are divisible by 1.
    for (possibleDivisor in 2..min(n1, n2)) {
        if (n1 % possibleDivisor == 0 && n2 % possibleDivisor == 0) {
            gcd = possibleDivisor
        }
    }

    println("The GCD of $n1 and $n2 is $gcd.")
}