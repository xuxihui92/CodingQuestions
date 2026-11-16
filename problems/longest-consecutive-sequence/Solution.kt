/**
 * Longest Consecutive Sequence
 *
 * Given an unsorted array of integers, return the length of the longest
 * consecutive elements sequence. Target O(n) time.
 */
fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    val remaining = nums.toMutableSet()
    var best = 1

    for (n in nums) {
        if (n !in remaining) continue
        remaining.remove(n)
        var left = n - 1
        var right = n + 1
        var count = 1
        while (left in remaining) {
            remaining.remove(left)
            left--
            count++
        }
        while (right in remaining) {
            remaining.remove(right)
            right++
            count++
        }
        best = maxOf(best, count)
    }
    return best
}

/** O(n log n) alternative: sort then scan. */
fun longestConsecutiveSorted(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val sorted = nums.sorted()
    var count = 1
    var best = 1
    for (i in 0 until sorted.lastIndex) {
        when {
            sorted[i] == sorted[i + 1] -> Unit
            sorted[i] + 1 == sorted[i + 1] -> {
                count++
                best = maxOf(best, count)
            }
            else -> count = 1
        }
    }
    return best
}

fun main() {
    val nums = intArrayOf(100, 4, 5, 200, 1, 3, 2) // 1..5 → length 5
    val a = longestConsecutive(nums)
    val b = longestConsecutiveSorted(nums.copyOf())
    check(a == 5 && b == 5) { "expected 5, got a=$a b=$b" }
    println("nums=${nums.toList()} => $a (hash), $b (sorted)")
    check(longestConsecutive(intArrayOf()) == 0)
    check(longestConsecutive(intArrayOf(1, 2, 0, 1)) == 3)
    println("All longest-consecutive-sequence checks passed.")
}
