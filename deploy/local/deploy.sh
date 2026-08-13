#!/bin/sh

set -eu

echo "Creating Secret..."
kubectl apply -f secret.yaml

echo "Starting PostgreSQL..."
kubectl apply -f postgres.yaml
kubectl wait --for=condition=Ready pod/postgres --timeout=60s

echo "Deploying application..."
helm upgrade --install vmp-trade-services ../chart

echo "Deployment completed."