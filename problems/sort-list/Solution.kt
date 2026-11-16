/**
 * Sort List
 *
 * Sort a singly linked list in O(n log n) time using merge sort.
 */
class ListNode(var value: Int, var next: ListNode? = null)

fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var slow = head
    var fast = head.next?.next
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    val mid = slow!!.next
    slow.next = null

    return merge(sortList(head), sortList(mid))
}

fun merge(left: ListNode?, right: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var pointer = dummy
    var a = left
    var b = right

    while (a != null && b != null) {
        if (a.value < b.value) {
            pointer.next = a
            a = a.next
        } else {
            pointer.next = b
            b = b.next
        }
        pointer = pointer.next!!
    }
    pointer.next = a ?: b
    return dummy.next
}

fun toList(head: ListNode?): List<Int> {
    val values = mutableListOf<Int>()
    var curr = head
    while (curr != null) {
        values += curr.value
        curr = curr.next
    }
    return values
}

fun fromList(values: List<Int>): ListNode? {
    if (values.isEmpty()) return null
    val dummy = ListNode(0)
    var curr = dummy
    for (v in values) {
        curr.next = ListNode(v)
        curr = curr.next!!
    }
    return dummy.next
}

fun main() {
    val samples = listOf(
        listOf(4, 2, 1, 3) to listOf(1, 2, 3, 4),
        listOf(-1, 5, 3, 4, 0) to listOf(-1, 0, 3, 4, 5),
        emptyList<Int>() to emptyList(),
        listOf(1) to listOf(1),
    )
    for ((input, expected) in samples) {
        val actual = toList(sortList(fromList(input)))
        check(actual == expected) { "sortList($input) = $actual, expected $expected" }
        println("$input => $actual")
    }
    println("All sort-list checks passed.")
}
