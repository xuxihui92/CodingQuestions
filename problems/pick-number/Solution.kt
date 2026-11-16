/**
 * Pick Number
 *
 * Extract all digit characters from a string and return them sorted ascending.
 */
fun pickNumbers(s: String): List<Int> {
    if (s.isEmpty() || s.length > 65535) return emptyList()
    return s.filter { it.isDigit() }
        .map { it - '0' }
        .sorted()
}

fun main() {
    val samples = listOf(
        "a1b2c0" to listOf(0, 1, 2),
        "987" to listOf(7, 8, 9),
        "no digits" to emptyList(),
        "" to emptyList(),
    )
    for ((input, expected) in samples) {
        val actual = pickNumbers(input)
        check(actual == expected) { "pickNumbers(\"$input\") = $actual, expected $expected" }
        println("\"$input\" => ${actual.joinToString("")}")
    }
    println("All pick-number checks passed.")
}
