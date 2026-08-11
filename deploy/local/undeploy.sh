#!/bin/sh

set -eu

echo "Removing application..."
helm uninstall vmp-trade-services

echo "Removing PostgreSQL..."
kubectl delete -f postgres.yaml --ignore-not-found

echo "Removing credentials..."
kubectl delete secret vmp-trade-credentials --ignore-not-found

echo "Undeploy completed."