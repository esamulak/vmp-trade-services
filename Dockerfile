# ============================================================
# Stage 1: Build application
# ============================================================

FROM maven:3.9.11-eclipse-temurin-21 AS builder

WORKDIR /build

# Copy Maven descriptors first (cache dependencies)
COPY pom.xml .

COPY domain/pom.xml domain/
COPY application/pom.xml application/
COPY infrastructure/pom.xml infrastructure/
COPY launcher/pom.xml launcher/

# Download dependencies
RUN --mount=type=cache,target=/root/.m2 \
    mvn -B dependency:go-offline -DskipTests

# Copy source code
COPY domain/src domain/src
COPY application/src application/src
COPY infrastructure/src infrastructure/src
COPY launcher/src launcher/src

# Copy API contract needed by OpenAPI generator
COPY api api

# Build executable module
RUN --mount=type=cache,target=/root/.m2 \
    mvn -B clean package \
    -pl launcher \
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
    /build/launcher/target/*.jar \
    app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]