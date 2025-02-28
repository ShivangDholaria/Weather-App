# Stage 1: Build the application using Maven and JDK 21
FROM maven:3.8.5-openjdk-21 AS build
WORKDIR /app

# Copy the Maven configuration and source code
COPY pom.xml .
COPY src ./src

# Build the application, skipping tests for faster builds
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image using a slim OpenJDK 21 image
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Set the command to run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]