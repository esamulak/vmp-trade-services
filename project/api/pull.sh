#!/bin/sh

set -e
cd "$(dirname "$0")"

VMP_CONTRACT_REPO="https://github.com/esamulak/vmp-contract.git" # TODO: export to env variable
REF="${1:-master}"

rm -rf .contract-tmp

git clone --depth 1 --branch "$REF" "$VMP_CONTRACT_REPO" .contract-tmp >/dev/null 2>&1

for dir in inbound outbound; do
    for domain in "$dir"/*; do
        [ -d "$domain" ] || continue

        name=$(basename "$domain")

        find "$domain" -type f | while read file; do
            cp ".contract-tmp/$name/${file#$dir/$name/}" "$file"
        done
    done
done

cp .contract-tmp/VERSION .

rm -rf .contract-tmp

echo "Contract updated: $REF ($(cat VERSION))"