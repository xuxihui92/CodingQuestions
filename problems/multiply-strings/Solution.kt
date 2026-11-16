/**
 * Multiply Strings
 *
 * Multiply two non-negative integers given as decimal strings.
 * Do not use built-in BigInteger conversion for the core multiplication.
 */
fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") return "0"

    val product = IntArray(num1.length + num2.length)
    for (i in num1.lastIndex downTo 0) {
        for (j in num2.lastIndex downTo 0) {
            product[i + j + 1] += (num1[i] - '0') * (num2[j] - '0')
        }
    }

    var carry = 0
    for (i in product.lastIndex downTo 0) {
        val total = product[i] + carry
        product[i] = total % 10
        carry = total / 10
    }

    val sb = StringBuilder()
    for (digit in product) {
        if (sb.isEmpty() && digit == 0) continue
        sb.append(digit)
    }
    return if (sb.isEmpty()) "0" else sb.toString()
}

fun main() {
    data class Case(val a: String, val b: String, val expected: String)
    val samples = listOf(
        Case("2", "3", "6"),
        Case("123", "456", "56088"),
        Case("0", "999", "0"),
        Case("999", "999", "998001"),
    )
    for ((a, b, expected) in samples) {
        val actual = multiply(a, b)
        check(actual == expected) { "multiply($a, $b) = $actual, expected $expected" }
        println("$a * $b => $actual")
    }
    println("All multiply-strings checks passed.")
}
