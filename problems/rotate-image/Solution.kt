/**
 * Rotate Image
 *
 * Rotate an n×n matrix 90° clockwise in-place.
 * Approach: transpose, then reverse each row.
 */
fun rotate(matrix: Array<IntArray>) {
    if (matrix.isEmpty()) return
    val n = matrix.size

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = tmp
        }
    }

    for (row in matrix) {
        var left = 0
        var right = n - 1
        while (left < right) {
            val tmp = row[left]
            row[left] = row[right]
            row[right] = tmp
            left++
            right--
        }
    }
}

fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        println(row.joinToString(" "))
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )
    println("Before:")
    printMatrix(matrix)
    rotate(matrix)
    println("After (90° clockwise):")
    printMatrix(matrix)
    check(matrix.map { it.toList() } == listOf(listOf(7, 4, 1), listOf(8, 5, 2), listOf(9, 6, 3)))

    val matrix2 = arrayOf(
        intArrayOf(5, 1, 9, 11),
        intArrayOf(2, 4, 8, 10),
        intArrayOf(13, 3, 6, 7),
        intArrayOf(15, 14, 12, 16),
    )
    rotate(matrix2)
    check(
        matrix2.map { it.toList() } == listOf(
            listOf(15, 13, 2, 5),
            listOf(14, 3, 4, 1),
            listOf(12, 6, 8, 9),
            listOf(16, 7, 10, 11),
        )
    )
    println("All rotate-image checks passed.")
}
