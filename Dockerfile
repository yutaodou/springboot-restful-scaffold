FROM eclipse-temurin:17-jre-focal
WORKDIR /app/
COPY build/libs/springboot-api-scaffold-0.0.1-SNAPSHOT.jar /app/application.jar
COPY scripts/entrypoint.sh /app/entrypoint.sh

ENTRYPOINT ["/bin/sh", "/app/entrypoint.sh"]
