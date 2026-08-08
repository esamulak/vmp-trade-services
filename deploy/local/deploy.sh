#!/bin/sh

set -eu

kubectl create configmap vmp-trade-config \
  --from-env-file=config.env \
  --dry-run=client -o yaml | kubectl apply -f -

kubectl create secret generic vmp-trade-credentials \
  --from-env-file=credentials.env \
  --dry-run=client -o yaml | kubectl apply -f -

kubectl apply -f postgres.yaml