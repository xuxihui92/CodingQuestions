/**
 * Count Palindrome
 *
 * Count distinct and total palindromic substrings of a string.
 * Comparison ignores case and skips non-letter/digit characters inside a candidate.
 */
fun isPalindrome(s: String): Boolean {
    if (s.length <= 1) return true
    val normalized = s.lowercase()
    var left = 0
    var right = normalized.lastIndex
    while (left < right) {
        when {
            !normalized[left].isLetterOrDigit() -> left++
            !normalized[right].isLetterOrDigit() -> right--
            normalized[left] != normalized[right] -> return false
            else -> {
                left++
                right--
            }
        }
    }
    return true
}

fun palindromicSubstrings(s: String): List<String> {
    val found = mutableListOf<String>()
    for (i in s.indices) {
        for (j in i + 1..s.length) {
            val sub = s.substring(i, j)
            if (isPalindrome(sub)) found += sub
        }
    }
    return found
}

fun main() {
    val input = "ababa"
    val all = palindromicSubstrings(input)
    val distinct = all.toSet()
    println("Input: \"$input\"")
    println("Distinct palindromes (${distinct.size}): $distinct")
    println("Total palindromic substrings: ${all.size}")

    check(isPalindrome("aba"))
    check(isPalindrome("Aba"))
    check(!isPalindrome("abc"))
    check(palindromicSubstrings("aaa").size == 6) // a,a,a,aa,aa,aaa
    check(distinct.containsAll(listOf("a", "b", "aba", "bab", "ababa")))
    println("All count-palindrome checks passed.")
}
