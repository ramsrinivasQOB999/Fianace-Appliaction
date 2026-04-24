FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /build

# Cache dependencies first for faster rebuilds
COPY BackEnd/pom.xml BackEnd/
COPY BackEnd/checkstyle.xml BackEnd/
COPY BackEnd/sonar-project.properties BackEnd/
WORKDIR /build/BackEnd
RUN mvn -B -DskipTests dependency:go-offline

# Build production jar
COPY BackEnd/src ./src
RUN mvn -B -DskipTests -Pprod package

FROM eclipse-temurin:21-jre-noble AS runtime
WORKDIR /app

# Run as non-root in production
RUN if ! getent passwd 10001 >/dev/null 2>&1; then useradd -r -u 10001 appuser; fi
COPY --from=build --chown=10001:10001 /build/BackEnd/target/*.jar /app/app.jar
USER 10001

ENV SPRING_PROFILES_ACTIVE=prod
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
ENV PORT=8080

EXPOSE 8080
ENTRYPOINT ["sh","-c","exec java $JAVA_OPTS -Dserver.port=${PORT} -jar /app/app.jar"]
