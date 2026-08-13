#!/bin/sh

set -eu

helm uninstall vmp-trade-services || true

kubectl delete -f manifests/postgres.yaml --ignore-not-found

kubectl delete -f manifests/secret.yaml --ignore-not-found

echo "Undeployment completed."