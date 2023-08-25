package challenges.activity1.overengineered

val vowels = setOf('a', 'e', 'i', 'o', 'u')
val consonants = ('a'..'z').filter { it !in vowels }.toSet()

enum class CharacterType {
    Vowel,
    Consonant,
    NonAlphabetical,
}

val Char.type get() = when (lowercase().first()) {
    in vowels -> CharacterType.Vowel
    in consonants -> CharacterType.Consonant
    else -> CharacterType.NonAlphabetical
}

fun main() {
    print("Enter a letter: ")
    val string = readln()
    if (string.length != 1) {
        println("Only one character is allowed.")
    } else {
        val character = string.first()
        println(
            when (character.type) {
                CharacterType.Vowel -> "'$character' is a vowel."
                CharacterType.Consonant -> "'$character' is a consonant."
                else -> "'$character' is not a letter."
            }
        )
    }
}