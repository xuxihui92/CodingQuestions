/**
 * Divide String
 *
 * Input format: `<parts><delimiter><groupIndex>`
 * Example: `aaa?bbb?ccc?ddd??3` → split on `?`, pick group 3 → `ccc`
 * (1-based index; the second-to-last char is the delimiter, last char is the digit.)
 */
fun divideString(input: String): String? {
    if (input.length < 2) return null

    val delimiter = input[input.length - 2]
    val groupIndex = input.last() - '0'
    if (groupIndex < 1) return null

    val body = input.dropLast(2)
    val groups = mutableListOf<String>()
    var start = 0
    for (i in body.indices) {
        if (body[i] == delimiter) {
            groups += body.substring(start, i)
            start = i + 1
        }
    }

    return groups.getOrNull(groupIndex - 1)
}

fun main() {
    val samples = listOf(
        "aaa?bbb?ccc?ddd??3" to "ccc",
        "aaa?bbb?ccc?ddd??1" to "aaa",
        "aaa?bbb?ccc?ddd??9" to null,
        "one,two,three,,2" to "two",
    )
    for ((input, expected) in samples) {
        val actual = divideString(input)
        check(actual == expected) { "divideString(\"$input\") = $actual, expected $expected" }
        println("\"$input\" => $actual")
    }
    println("All divide-string checks passed.")
}
