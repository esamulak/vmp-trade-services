# ============================================================
# Stage 1: Build application
# ============================================================

FROM maven:3.9.11-eclipse-temurin-21 AS builder

WORKDIR /build

COPY pom.xml .
COPY api/pom.xml api/
COPY application/pom.xml application/
COPY domain/pom.xml domain/
COPY infrastructure/pom.xml infrastructure/

RUN --mount=type=cache,target=/root/.m2 \
    mvn clean install -pl api -am

COPY api/src api/src
COPY application/src application/src
COPY domain/src domain/src
COPY infrastructure/src infrastructure/src

RUN --mount=type=cache,target=/root/.m2 \
    mvn -B clean package \
    -pl api \
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
    /build/api/target/*.jar \
    app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]