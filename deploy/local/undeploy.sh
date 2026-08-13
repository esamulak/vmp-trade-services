#!/bin/sh

set -eu

echo "Removing application..."
helm uninstall vmp-trade-services || true

echo "Removing PostgreSQL..."
kubectl delete -f postgres.yaml --ignore-not-found

echo "Removing Secret..."
kubectl delete -f secret.yaml --ignore-not-found

echo "Undeployment completed."