# CodingQuestions

Personal practice set for coding-interview / algorithm questions.

> Formerly **JavaPractice**. Each problem has a **Java** solution (original) and a **Kotlin** rewrite for side-by-side comparison.

## Layout

```text
<Problem Name>/src/com/company/Main.java   # original Java
problems/<slug>/Solution.kt                # idiomatic Kotlin (+ demo checks)
scripts/run.sh <slug>                      # compile & run Kotlin
scripts/run-all.sh                         # run every Kotlin problem
scripts/run-java.sh "<Problem Name>"       # compile & run Java
```

IntelliJ `.idea` / `.iml` clutter and compiled `out/` artifacts are intentionally not kept.

## Prerequisites

- JDK 17+ (`java` / `javac` on `PATH`)
- For Kotlin: [Kotlin compiler](https://kotlinlang.org/docs/command-line.html) (`kotlinc` on `PATH`)

```bash
# macOS
brew install kotlin
```

## How to run

### Kotlin (primary demos)

```bash
./scripts/run.sh rotate-image
./scripts/run-all.sh
```

Or manually:

```bash
kotlinc problems/rotate-image/Solution.kt -include-runtime -d /tmp/rotate-image.jar
java -jar /tmp/rotate-image.jar
```

### Java (original)

```bash
./scripts/run-java.sh "Rotate Image"
```

Or manually:

```bash
javac "Rotate Image/src/com/company/Main.java"
java -cp "Rotate Image/src" com.company.Main
```

Some Java mains read from stdin; Kotlin mains use hard-coded samples and assertions.

## Problems (Java ↔ Kotlin)

| Java folder | Kotlin slug | Description |
| --- | --- | --- |
| [Basic Calculator](Basic%20Calculator/) | [basic-calculator](problems/basic-calculator/) | Evaluate `+` / `-` with parentheses. |
| [Basic Calculator2](Basic%20Calculator2/) | [basic-calculator-ii](problems/basic-calculator-ii/) | Evaluate `+` `-` `*` `/` (no parentheses). |
| [Count Palindrome](Count%20Palindrome/) | [count-palindrome](problems/count-palindrome/) | Count distinct and total palindromic substrings. |
| [Divide String](Divide%20String/) | [divide-string](problems/divide-string/) | Split on a delimiter and pick the Nth group. |
| [Longest Consecutive Sequence](Longest%20Consecutive%20Sequence/) | [longest-consecutive-sequence](problems/longest-consecutive-sequence/) | Longest run of consecutive integers. |
| [Longest Palindromic Substring](Longest%20Palindromic%20Substring/) | [longest-palindromic-substring](problems/longest-palindromic-substring/) | Longest palindromic substring. |
| [Multiply Strings](Multiply%20Strings/) | [multiply-strings](problems/multiply-strings/) | Multiply two non-negative integers as strings. |
| [Pick Number](Pick%20Number/) | [pick-number](problems/pick-number/) | Extract digits and print them sorted. |
| [Remove Invalid Parentheses](Remove%20Invalid%20Parentheses/) | [remove-invalid-parentheses](problems/remove-invalid-parentheses/) | Remove fewest parentheses to make valid. |
| [Reverse Number](Reverse%20Number/) | [reverse-number](problems/reverse-number/) | Reverse digits of a 32-bit int (overflow → 0). |
| [Rotate Image](Rotate%20Image/) | [rotate-image](problems/rotate-image/) | Rotate an n×n matrix 90° clockwise in-place. |
| [Sort List](Sort%20List/) | [sort-list](problems/sort-list/) | Sort a singly linked list (merge sort). |
| [Word Search](Word%20Search/) | [word-search](problems/word-search/) | Search for a word on a 2D board (DFS). |

## Notes

- Solutions are for practice and study, not a library.
- Prefer Kotlin for new work; keep Java for comparison / history.
