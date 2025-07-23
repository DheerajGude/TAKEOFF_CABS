# Use an official Maven image to build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy the pom.xml and download dependencies (better Docker cache usage)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the entire source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use a lightweight OpenJDK image to run the app
FROM eclipse-temurin:17-jdk-alpine

# Set working directory in the runtime container
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/payment-service-*.jar payment-service.jar

# Expose the port (match what's in your application.yml)
EXPOSE 8082

# Run the JAR
ENTRYPOINT ["java", "-jar", "payment-service.jar"]
