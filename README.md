# CodingQuestions

Personal **Kotlin** practice set for coding-interview / algorithm questions.

> Formerly **JavaPractice**. Solutions were migrated from Java to idiomatic Kotlin.

## Layout

```text
problems/<slug>/Solution.kt   # solution + small demo / self-checks
scripts/run.sh <slug>         # compile and run one problem
scripts/run-all.sh            # compile and run every problem
```

Each `Solution.kt` exposes the core function(s) and a `main` that prints sample results and asserts a few cases.

## Prerequisites

- JDK 17+ (`java` / `javac` on `PATH`)
- [Kotlin compiler](https://kotlinlang.org/docs/command-line.html) (`kotlinc` / `kotlin` on `PATH`)

Install Kotlin (example):

```bash
# macOS
brew install kotlin

# or download the compiler zip from JetBrains and add kotlinc/bin to PATH
```

## How to run

From the repo root:

```bash
# one problem
./scripts/run.sh rotate-image

# everything
./scripts/run-all.sh
```

Or manually:

```bash
kotlinc problems/rotate-image/Solution.kt -include-runtime -d /tmp/rotate-image.jar
kotlin -classpath /tmp/rotate-image.jar SolutionKt
# (or: java -jar /tmp/rotate-image.jar)
```

## Problems

| Slug | Description |
| --- | --- |
| [basic-calculator](problems/basic-calculator/) | Evaluate `+` / `-` expressions with parentheses. |
| [basic-calculator-ii](problems/basic-calculator-ii/) | Evaluate `+` `-` `*` `/` expressions (no parentheses). |
| [count-palindrome](problems/count-palindrome/) | Count distinct and total palindromic substrings. |
| [divide-string](problems/divide-string/) | Split on a delimiter char and pick the Nth group. |
| [longest-consecutive-sequence](problems/longest-consecutive-sequence/) | Longest run of consecutive integers in an array. |
| [longest-palindromic-substring](problems/longest-palindromic-substring/) | Find the longest palindromic substring. |
| [multiply-strings](problems/multiply-strings/) | Multiply two non-negative integers given as strings. |
| [pick-number](problems/pick-number/) | Extract digits from a string and print them sorted. |
| [remove-invalid-parentheses](problems/remove-invalid-parentheses/) | Remove fewest parentheses to make the string valid. |
| [reverse-number](problems/reverse-number/) | Reverse digits of a 32-bit integer (overflow → 0). |
| [rotate-image](problems/rotate-image/) | Rotate an n×n matrix 90° clockwise in-place. |
| [sort-list](problems/sort-list/) | Sort a singly linked list (merge sort). |
| [word-search](problems/word-search/) | Search for a word on a 2D letter board (DFS). |

## Notes

- Solutions are for practice and study, not a library.
- Java / IntelliJ per-folder projects (`.iml`, `.idea`, `out/`) were removed in the Kotlin migration.
