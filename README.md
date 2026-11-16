# CodingQuestions

Personal Java practice set for coding interview / algorithm questions.

> Formerly **JavaPractice**. Same history and exercises; name updated to match the purpose.

## How to run an exercise

From the repo root (requires a JDK):

```bash
# Example: Rotate Image
javac "Rotate Image/src/com/company/Main.java"
java -cp "Rotate Image/src" com.company.Main
```

Or open the exercise folder in IntelliJ IDEA (each folder has its own `.iml` / `.idea` project) and run `Main`.

Some programs read from stdin; others use hard-coded sample inputs in `main`.

## Problems

| Folder | One-liner |
| --- | --- |
| [Basic Calculator](Basic%20Calculator/) | Evaluate `+` / `-` expressions with parentheses. |
| [Basic Calculator2](Basic%20Calculator2/) | Evaluate `+` `-` `*` `/` expressions (no parentheses). |
| [Count Palindrome](Count%20Palindrome/) | Count distinct and total palindromic substrings. |
| [Divide String](Divide%20String/) | Split on a delimiter char and pick the Nth group. |
| [Longest Consecutive Sequence](Longest%20Consecutive%20Sequence/) | Longest run of consecutive integers in an array. |
| [Longest Palindromic Substring](Longest%20Palindromic%20Substring/) | Find the longest palindromic substring. |
| [Multiply Strings](Multiply%20Strings/) | Multiply two non-negative integers given as strings. |
| [Pick Number](Pick%20Number/) | Extract digits from a string and print them sorted. |
| [Remove Invalid Parentheses](Remove%20Invalid%20Parentheses/) | Remove fewest parentheses to make the string valid. |
| [Reverse Number](Reverse%20Number/) | Reverse digits of a 32-bit integer (overflow → 0). |
| [Rotate Image](Rotate%20Image/) | Rotate an n×n matrix 90° clockwise in-place. |
| [Sort List](Sort%20List/) | Sort a singly linked list (merge sort). |
| [Word Search](Word%20Search/) | Search for a word on a 2D letter board (DFS). |

See [NOTE.md](NOTE.md) for a short statement of purpose.
