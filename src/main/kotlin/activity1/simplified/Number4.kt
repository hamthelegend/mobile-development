package activity1.simplified

val vowels = setOf('a', 'e', 'i', 'o', 'u')
val consonants = ('a'..'z').filter { it !in vowels }.toSet()
fun main() {
    print("Enter a letter: ")
    val string = readln()
    if (string.length == 1) {
        val character = string.first()
        when (character.lowercase().first()) {
            in vowels -> println("$character is a vowel.")
            in consonants -> println("$character is a consonant.")
            else -> println("$character is not a letter.")
        }
    } else {
        println("Only one character is allowed.")
    }
}