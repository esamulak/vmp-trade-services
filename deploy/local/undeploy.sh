#!/bin/sh

set -eu

# helm uninstall vmp-trade

kubectl delete -f postgres.yaml
kubectl delete secret vmp-trade-credentials
kubectl delete configmap vmp-trade-config