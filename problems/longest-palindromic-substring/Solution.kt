/**
 * Longest Palindromic Substring
 *
 * Find the longest palindromic substring. Assumes a unique longest answer
 * when lengths tie (keeps the first maximal window found by the scan).
 *
 * Approach: expand around the growing window while scanning left-to-right.
 */
fun longestPalindrome(s: String): String {
    if (s.isEmpty()) return ""
    var result = ""
    var length = 0
    for (i in s.indices) {
        when {
            isPalindrome(s, i - length - 1, i) -> {
                result = s.substring(i - length - 1, i + 1)
                length += 2
            }
            isPalindrome(s, i - length, i) -> {
                result = s.substring(i - length, i + 1)
                length += 1
            }
        }
    }
    return result
}

private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
    if (start < 0) return false
    var lo = start
    var hi = end
    while (lo < hi) {
        if (s[lo++] != s[hi--]) return false
    }
    return true
}

fun main() {
    val samples = listOf(
        "babad" to setOf("bab", "aba"), // either is valid for classic problem; this algo returns one
        "cbbd" to setOf("bb"),
        "a" to setOf("a"),
        "ac" to setOf("a", "c"),
        "forgeeksskeegfor" to setOf("geeksskeeg"),
    )
    for ((input, allowed) in samples) {
        val actual = longestPalindrome(input)
        check(actual in allowed) { "longestPalindrome(\"$input\") = \"$actual\", expected one of $allowed" }
        println("\"$input\" => \"$actual\"")
    }
    println("All longest-palindromic-substring checks passed.")
}
