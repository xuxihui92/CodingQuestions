/**
 * Basic Calculator
 *
 * Evaluate an expression with non-negative integers, '+', '-', parentheses, and spaces.
 *
 * Approach: single pass with a stack to save result/sign when entering '('.
 */
fun calculate(expression: String): Int {
    if (expression.isBlank()) return 0

    val stack = ArrayDeque<Int>()
    var result = 0
    var sign = 1
    var number = 0

    for (c in expression) {
        when {
            c.isDigit() -> number = number * 10 + (c - '0')
            c == '+' -> {
                result += sign * number
                number = 0
                sign = 1
            }
            c == '-' -> {
                result += sign * number
                number = 0
                sign = -1
            }
            c == '(' -> {
                stack.addLast(result)
                stack.addLast(sign)
                result = 0
                sign = 1
                number = 0
            }
            c == ')' -> {
                result += sign * number
                number = 0
                val prevSign = stack.removeLast()
                val prevResult = stack.removeLast()
                result = prevResult + prevSign * result
            }
            c == ' ' -> Unit
            else -> throw IllegalArgumentException("Unexpected character: '$c'")
        }
    }
    return result + sign * number
}

fun main() {
    val samples = listOf(
        "1 + 1" to 2,
        " 2-1 + 2 " to 3,
        "(1+(4+5+2)-3)+(6+8)" to 23,
        "-(2+3)" to -5,
    )
    for ((expr, expected) in samples) {
        val actual = calculate(expr)
        check(actual == expected) { "calculate(\"$expr\") = $actual, expected $expected" }
        println("\"$expr\" => $actual")
    }
    println("All basic-calculator checks passed.")
}
