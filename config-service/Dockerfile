FROM maven:3.9.11-eclipse-temurin-21
ADD ./target/config-service-1.0.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config-service-1.0.0-SNAPSHOT.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8888/actuator/health || exit 1

EXPOSE 8888