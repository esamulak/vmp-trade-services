#!/bin/sh

set -eu

kubectl apply -f manifests/secret.yaml

kubectl apply -f manifests/postgres.yaml
kubectl wait --for=condition=Ready pod/postgres --timeout=60s

helm upgrade --install vmp-trade-services ../chart -f values-local.yaml

echo "Deployment completed."