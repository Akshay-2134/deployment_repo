
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/spring-boot-simple-project-0.0.1-SNAPSHOT.jar  /app/app.jar
EXPOSE 8182
ENTRYPOINT ["java", "-jar", "/app/app.jar"]