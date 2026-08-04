#!/bin/bash

set -e
cd "$(dirname "$0")"

REPO="https://github.com/esamulak/vmp-contract.git"
REF="${1:-develop}"

rm -rf .contract-tmp inbound/trade

git clone --depth 1 --branch "$REF" "$REPO" .contract-tmp >/dev/null 2>&1

mkdir -p inbound
cp -r .contract-tmp/trade inbound/
cp .contract-tmp/VERSION .

rm -rf .contract-tmp

echo "Contract updated: $REF ($(cat VERSION))"