#!/bin/bash

set -e

REPO="https://github.com/esamulak/vmp-contract.git"

BRANCH=$(git ls-remote --heads "$REPO" "feature/INC-*" \
  | sed 's#.*refs/heads/##' \
  | sort -V | tail -1)

read -p "Use $BRANCH? [Y/n]: " OK
[[ "$OK" =~ ^[Nn]$ ]] && read -p "Branch: " BRANCH

rm -rf .contract-tmp inbound/trade

echo "Downloading contract..."

git clone --filter=blob:none --sparse --branch "$BRANCH" "$REPO" .contract-tmp >/dev/null 2>&1

cd .contract-tmp
git sparse-checkout set trade
cd ..

mkdir -p inbound
mv .contract-tmp/trade inbound/

rm -rf .contract-tmp

echo "Contract updated from $BRANCH"