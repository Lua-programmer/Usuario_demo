FROM openjdk:17-jdk-slim

COPY build/libs/api-0.0.1-SNAPSHOT.jar /app/api-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/api-0.0.1-SNAPSHOT.jar"]