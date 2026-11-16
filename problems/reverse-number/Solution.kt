/**
 * Reverse Number
 *
 * Reverse digits of a 32-bit signed integer. Return 0 on overflow.
 */
fun reverse(x: Int): Int {
    var n = x
    var result = 0L
    while (n != 0) {
        result = result * 10 + n % 10
        n /= 10
    }
    return if (result !in Int.MIN_VALUE..Int.MAX_VALUE) 0 else result.toInt()
}

fun main() {
    val samples = listOf(
        123 to 321,
        -123 to -321,
        120 to 21,
        0 to 0,
        1534236469 to 0, // overflow
    )
    for ((input, expected) in samples) {
        val actual = reverse(input)
        check(actual == expected) { "reverse($input) = $actual, expected $expected" }
        println("$input => $actual")
    }
    println("All reverse-number checks passed.")
}
