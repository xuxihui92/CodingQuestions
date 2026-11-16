/**
 * Word Search
 *
 * Given a 2D board and a word, return true if the word exists in the grid.
 * Letters must be adjacent (up/down/left/right) and not reused in one path.
 */
fun exist(board: Array<CharArray>, word: String): Boolean {
    if (board.isEmpty() || word.isEmpty()) return false
    val rows = board.size
    val cols = board[0].size
    val visited = Array(rows) { BooleanArray(cols) }

    fun dfs(index: Int, row: Int, col: Int): Boolean {
        if (index == word.length) return true
        if (row !in 0 until rows || col !in 0 until cols) return false
        if (visited[row][col] || board[row][col] != word[index]) return false

        visited[row][col] = true
        val found = dfs(index + 1, row - 1, col) ||
            dfs(index + 1, row + 1, col) ||
            dfs(index + 1, row, col - 1) ||
            dfs(index + 1, row, col + 1)
        visited[row][col] = false
        return found
    }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (dfs(0, r, c)) return true
        }
    }
    return false
}

fun main() {
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E'),
    )
    val samples = listOf(
        "ABCCED" to true,
        "SEE" to true,
        "ABCB" to false,
        "ABCDEF" to false,
    )
    for ((word, expected) in samples) {
        val actual = exist(board, word)
        check(actual == expected) { "exist(\"$word\") = $actual, expected $expected" }
        println("\"$word\" => $actual")
    }
    println("All word-search checks passed.")
}
