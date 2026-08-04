# ============================================================
# Stage 1: Build
# ============================================================

FROM maven:3.9.11-eclipse-temurin-21 AS builder

WORKDIR /build

COPY pom.xml .
COPY domain/pom.xml domain/
COPY application/pom.xml application/
COPY infrastructure/pom.xml infrastructure/
COPY launcher/pom.xml launcher/

RUN --mount=type=cache,target=/root/.m2 \
    mvn -B dependency:go-offline

COPY domain/src domain/src
COPY application/src application/src
COPY infrastructure/src infrastructure/src
COPY launcher/src launcher/src
COPY api api

RUN --mount=type=cache,target=/root/.m2 \
    mvn -B clean package -pl launcher -am


# ============================================================
# Stage 2: Runtime
# ============================================================

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN addgroup -S vmp && \
    adduser -S vmp -G vmp -u 1001

USER vmp

COPY --from=builder /build/domain/target/*.jar /app/
COPY --from=builder /build/application/target/*.jar /app/
COPY --from=builder /build/infrastructure/target/*.jar /app/
COPY --from=builder /build/launcher/target/launcher-*.jar /app/
COPY --from=builder /build/launcher/target/lib /app/lib

EXPOSE 8080

ENTRYPOINT ["java", "--module-path", "/app:/app/lib", "-m", \
            "vmp.trade.services.launcher/pl.es8it.vmp.trade.launcher.VmpTradeServicesApplication" \
]