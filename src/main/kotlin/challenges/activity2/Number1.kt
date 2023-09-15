package challenges.activity2

import java.time.Instant
import java.time.ZoneId

import java.time.format.DateTimeFormatter


val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy, hh:mm a")
    .withZone(ZoneId.systemDefault())

data class Post(
    val username: String,
    val content: String,
    var likes: Int = 0,
    val instantPosted: Instant = Instant.now(),
) {
    override fun toString() = """
        $username | ${formatter.format(instantPosted)}
        $content
        ❤️ $likes
    """.trimIndent()
}

fun main() {
    val posts = listOf(
        Post(
            username = "jerjerking",
            content = "This playground is so fun!",
            likes = -25,
            instantPosted = Instant.parse("2023-12-03T05:39:00Z"),
        ),
        Post(
            username = "jerjerking",
            content = "I love miners!",
            likes = -7,
            instantPosted = Instant.parse("2007-12-03T05:39:00Z"),
        ),
        Post(
            username = "ju",
            content = "im a piss connoisseur!",
            likes = 102,
            instantPosted = Instant.parse("2023-01-05T05:20:30Z"),
        ),
        Post(
            username = "fish",
            content = "in a relationship with goldfish",
            likes = 1035,
            instantPosted = Instant.parse("2023-06-05T06:20:30Z"),
        ),
        Post(
            username = "folly_and_jolly",
            content = "inemobullets!",
            likes = 20,
            instantPosted = Instant.parse("2023-07-05T06:20:30Z"),
        ),
        Post(
            username = "merc",
            content = "meow",
            instantPosted = Instant.parse("2023-09-05T06:00:00Z"),
        )
    )

    println("Posts sorted by date: \n")
    println(posts.sortedByDescending { it.instantPosted }.joinToString(separator = "\n\n"))

    printHorizontalDivider()

    println("Posts sorted by likes: \n")
    println(posts.sortedByDescending { it.likes }.joinToString(separator = "\n\n"))

    printHorizontalDivider()

    println("Posts sorted by user: \n")
    println(posts.sortedBy { it.username }.joinToString(separator = "\n\n"))
}