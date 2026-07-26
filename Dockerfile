# ============================================================
# Stage 1: Build application
# ============================================================

FROM maven:3.9.11-eclipse-temurin-21 AS builder

WORKDIR /build

# Copy Maven descriptors first (cache dependencies)
COPY pom.xml .
COPY application/pom.xml application/
COPY domain/pom.xml domain/
COPY infrastructure/pom.xml infrastructure/

# Download dependencies
RUN --mount=type=cache,target=/root/.m2 \
    mvn -B dependency:go-offline -DskipTests

# Copy source code
COPY application/src application/src
COPY domain/src domain/src
COPY infrastructure/src infrastructure/src

# Copy API contract needed by OpenAPI generator
COPY api api

# Build
RUN --mount=type=cache,target=/root/.m2 \
    mvn -B clean package \
    -pl application \
    -am \
    -DskipTests


# ============================================================
# Stage 2: Runtime image
# ============================================================

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN addgroup -S developer && \
    adduser -S developer -G developer -u 1001

USER developer

COPY --from=builder \
    /build/application/target/*.jar \
    app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]