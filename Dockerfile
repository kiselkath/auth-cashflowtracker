# Stage 1: build
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: runtime
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/auth-service-0.0.1-SNAPSHOT.jar app.jar

#  Port
EXPOSE 8081

# Запуск
ENTRYPOINT ["java", "-jar", "app.jar"]
