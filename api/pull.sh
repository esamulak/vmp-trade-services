#!/bin/bash

set -e

ROOT_DIR=$(git rev-parse --show-toplevel)
cd "$ROOT_DIR"

CONTRACT_REPO="https://github.com/esamulak/vmp-contract.git"
CONTRACT_BRANCH="trade-contract"
PREFIX="api/inbound/trade"

echo "Updating trade contract..."

git subtree pull \
  --prefix "$PREFIX" \
  "$CONTRACT_REPO" \
  "$CONTRACT_BRANCH" \
  --squash