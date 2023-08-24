@file:Suppress("DuplicatedCode") // Ignore this. It's just for my IDE.

package activity1.simplified

fun pascalsTriangle(rowCount: Int): List<List<Int>> {
    val triangle = mutableListOf(listOf(1))
    for (index in 1..<rowCount) {
        val previousRow = triangle[index - 1]
        val currentRow = mutableListOf<Int>()
        for (previousRowIndex in 0..previousRow.size) {
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
    val rowCount = readln().toInt()
    val triangle = pascalsTriangle(rowCount)
    triangle.forEach { row -> println(row.joinToString("\t")) }
}