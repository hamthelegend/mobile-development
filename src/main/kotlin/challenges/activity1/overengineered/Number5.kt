package challenges.activity1.overengineered

fun pascalsTriangle(rowCount: Int): List<List<Int>> {
    val triangle = mutableListOf(listOf(1))
    (1..<rowCount).forEach { index ->
        val previousRow = triangle[index - 1]
        val currentRow = mutableListOf<Int>()
        (0..previousRow.size).forEach { previousRowIndex ->
            val numberToTheLeft = previousRow.getOrNull(previousRowIndex - 1) ?: 0
            val number = previousRow.getOrNull(previousRowIndex) ?: 0
            currentRow.add(numberToTheLeft + number)
        }
        triangle.add(currentRow)
    }
    return triangle
}

fun main() {
    print("Enter the number of rows: ")
    val input = readln()
    val rowCount = input.toIntOrNull()
    if (rowCount != null) {
        val triangle = pascalsTriangle(rowCount)
        triangle.forEach { row -> println(row.joinToString("\t")) }
    } else {
        println("$input is not a number.")
    }
}