#!/usr/bin/env bash
# Compile and run one Java problem: ./scripts/run-java.sh "Rotate Image"
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
NAME="${1:-}"

if [[ -z "$NAME" ]]; then
  echo "Usage: $0 \"<Problem Name>\"" >&2
  echo "Available:" >&2
  find "$ROOT" -path '*/src/com/company/Main.java' -printf '%P\n' \
    | sed 's|/src/com/company/Main.java||' | sort >&2
  exit 1
fi

SRC="$ROOT/$NAME/src/com/company/Main.java"
if [[ ! -f "$SRC" ]]; then
  echo "No Java Main.java for '$NAME' at $SRC" >&2
  exit 1
fi

if ! command -v javac >/dev/null 2>&1; then
  echo "javac not found. Install a JDK and add it to PATH." >&2
  exit 1
fi

TMP="$(mktemp -d)"
trap 'rm -rf "$TMP"' EXIT

echo "==> Java: $NAME"
javac -d "$TMP" "$SRC"
echo "(program may wait for stdin — Ctrl-D to end if needed)"
java -cp "$TMP" com.company.Main
