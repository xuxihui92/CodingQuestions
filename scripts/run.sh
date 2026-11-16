#!/usr/bin/env bash
# Compile and run one problem: ./scripts/run.sh <slug>
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
SLUG="${1:-}"

if [[ -z "$SLUG" ]]; then
  echo "Usage: $0 <slug>" >&2
  echo "Available:" >&2
  ls -1 "$ROOT/problems" >&2
  exit 1
fi

SRC="$ROOT/problems/$SLUG/Solution.kt"
if [[ ! -f "$SRC" ]]; then
  echo "No Solution.kt for slug '$SLUG' at $SRC" >&2
  exit 1
fi

if ! command -v kotlinc >/dev/null 2>&1; then
  echo "kotlinc not found. Install the Kotlin compiler and add it to PATH." >&2
  exit 1
fi

TMP="$(mktemp -d)"
trap 'rm -rf "$TMP"' EXIT

echo "==> $SLUG"
kotlinc "$SRC" -include-runtime -d "$TMP/$SLUG.jar"
java -jar "$TMP/$SLUG.jar"
