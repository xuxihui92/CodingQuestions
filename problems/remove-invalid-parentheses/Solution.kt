/**
 * Remove Invalid Parentheses
 *
 * Remove the minimum number of parentheses so the string is valid.
 * Return all possible results (BFS by removal count).
 */
fun removeInvalidParentheses(s: String): List<String> {
    if (s.isEmpty()) return listOf("")

    val result = mutableListOf<String>()
    val visited = mutableSetOf(s)
    val queue = ArrayDeque<String>()
    queue.add(s)
    var found = false

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        if (isValid(current)) {
            result.add(current)
            found = true
        }
        if (found) continue

        for (i in current.indices) {
            if (current[i] != '(' && current[i] != ')') continue
            val next = current.removeRange(i, i + 1)
            if (visited.add(next)) queue.add(next)
        }
    }
    return result
}

fun isValid(s: String): Boolean {
    var balance = 0
    for (c in s) {
        when (c) {
            '(' -> balance++
            ')' -> {
                if (balance == 0) return false
                balance--
            }
        }
    }
    return balance == 0
}

fun main() {
    val samples = listOf(
        "()())()" to setOf("(())()", "()()()"),
        "(a)())()" to setOf("(a())()", "(a)()()"),
        ")(" to setOf(""),
    )
    for ((input, expected) in samples) {
        val actual = removeInvalidParentheses(input).toSet()
        check(actual == expected) { "removeInvalidParentheses(\"$input\") = $actual, expected $expected" }
        println("\"$input\" => $actual")
    }
    println("All remove-invalid-parentheses checks passed.")
}
