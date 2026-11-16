/**
 * Basic Calculator II
 *
 * Evaluate an expression with non-negative integers, '+', '-', '*', '/', and spaces.
 * Integer division truncates toward zero. No parentheses.
 *
 * Approach: stack of signed terms; apply '*'/' immediately, sum at the end.
 */
fun calculate(expression: String): Int {
    if (expression.isBlank()) return 0

    val stack = ArrayDeque<Int>()
    var num = 0
    var sign = '+'

    fun apply(op: Char, value: Int) {
        when (op) {
            '+' -> stack.addLast(value)
            '-' -> stack.addLast(-value)
            '*' -> stack.addLast(stack.removeLast() * value)
            '/' -> stack.addLast(stack.removeLast() / value)
            else -> throw IllegalArgumentException("Unexpected operator: '$op'")
        }
    }

    for (i in expression.indices) {
        val c = expression[i]
        if (c.isDigit()) {
            num = num * 10 + (c - '0')
        }
        val isOperator = !c.isDigit() && c != ' '
        val isLast = i == expression.lastIndex
        if (isOperator || isLast) {
            apply(sign, num)
            if (isOperator) sign = c
            num = 0
        }
    }
    return stack.sum()
}

fun main() {
    val samples = listOf(
        "3+2*2" to 7,
        " 3/2 " to 1,
        " 3+5 / 2 " to 5,
        "14-3/2" to 13,
        "1*2-3/4+5*6-7*8+9/10" to -24,
    )
    for ((expr, expected) in samples) {
        val actual = calculate(expr)
        check(actual == expected) { "calculate(\"$expr\") = $actual, expected $expected" }
        println("\"$expr\" => $actual")
    }
    println("All basic-calculator-ii checks passed.")
}
