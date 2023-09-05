package challenges.activity2

import kotlin.random.Random

enum class CoinFace { Heads, Tails }

fun flipCoin() = CoinFace.entries.random()

const val DIE_FACES = 6
fun rollDie() = Random.nextInt(DIE_FACES - 1) + 1

fun Int.normalize(min: Int, max: Int) = when {
    this < min -> min
    this > max -> max
    else -> this
}

class Player(val name: String) {
    companion object {
        const val MAX_HP = 100
        const val MAX_DAMAGE = 50
    }
    var hp = 100
        private set(value) {
            field = value.normalize(min = 0, max = MAX_HP)
        }

    val dead get() = hp <= 0

    var incomingDamage = 0
        private set

    fun attack(defender: Player, dieRoll: Int): Int {
        val damageMultiplier = dieRoll.toDouble() / DIE_FACES
        val damage = (MAX_DAMAGE * damageMultiplier).toInt()
        defender.incomingDamage = damage
        return damage
    }

    fun takeDamage(guessedCoinFace: CoinFace, flippedCoinFace: CoinFace): Int {
        val damageMultiplier = if (guessedCoinFace == flippedCoinFace) 0.5  else 0.0
        val damageTaken = (incomingDamage * damageMultiplier).toInt()
        hp -= incomingDamage
        return damageTaken
    }
}

class Game {
    val player1 = Player(name = "P1")
    val player2 = Player(name = "P2")

    var attacker = player1
    val defender get() = when (attacker) {
        player1 -> player2
        else -> player1
    }

    val winner: Player? get() = when {
        player1.dead -> player2
        player2.dead -> player1
        else -> null
    }

    val over get() = winner != null

    fun attack(dieRoll: Int) = attacker.attack(defender, dieRoll)
    fun defend(guessedCoinFace: CoinFace, flippedCoinFace: CoinFace): Int {
        val damageTaken = defender.takeDamage(guessedCoinFace, flippedCoinFace)
        attacker = defender
        return damageTaken
    }
}

fun main() {
    val game = Game()
    while (!game.over) {
        readln()
        val dieRoll = rollDie()
        println("${game.attacker.name} rolled a $dieRoll")
        val incomingDamage = game.attack(dieRoll)
        println("${game.attacker.name} is about to deal $incomingDamage hp of damage to ${game.defender.name}.")

        println("0 - Heads")
        println("1 - Tails")
        print("${game.defender.name}, what coin face are you expecting? ")
        val guessedCoinFace = if (readln().toIntOrNull() == 0) CoinFace.Heads else CoinFace.Tails
        println("${game.defender.name} chose $guessedCoinFace")
        val flippedCoinFace = flipCoin()
        println("${game.defender.name} got a $flippedCoinFace")
        game.defend(guessedCoinFace, flippedCoinFace)
    }
}