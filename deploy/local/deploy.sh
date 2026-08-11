#!/bin/sh

set -eu

kubectl create secret generic vmp-trade-credentials \
  --from-env-file=credentials.env \
  --dry-run=client -o yaml | kubectl apply -f -

echo "Starting PostgreSQL..."
kubectl apply -f postgres.yaml
kubectl wait --for=condition=Ready pod/postgres --timeout=60s

echo "Deploying application..."
helm upgrade --install vmp-trade-services ../chart

echo "Deployment completed."