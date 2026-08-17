# ============================================================
# Stage 1: Build
# ============================================================

FROM maven:3.9.11-eclipse-temurin-21 AS builder

WORKDIR /build

RUN apt-get update && \
    apt-get install -y git && \
    rm -rf /var/lib/apt/lists/*

COPY . .

RUN --mount=type=cache,target=/root/.m2 \
    mvn -B -f project/pom.xml clean package -pl infrastructure -am

# ============================================================
# Stage 2: Runtime
# ============================================================

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN addgroup -S vmp -g 1000 && \
    adduser -S vmp -G vmp -u 1000

COPY --from=builder /build/project/infrastructure/target/*.jar app.jar

RUN chown 1000:1000 app.jar

USER 1000:1000

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]