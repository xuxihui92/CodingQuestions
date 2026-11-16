#!/usr/bin/env bash
# Compile and run every problem under problems/
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
FAILED=0

for dir in "$ROOT"/problems/*/; do
  slug="$(basename "$dir")"
  if ! "$ROOT/scripts/run.sh" "$slug"; then
    echo "FAILED: $slug" >&2
    FAILED=1
  fi
  echo
done

if [[ "$FAILED" -ne 0 ]]; then
  echo "Some problems failed." >&2
  exit 1
fi
echo "All problems passed."
