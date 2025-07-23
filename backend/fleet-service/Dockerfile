# Use Eclipse Temurin OpenJDK base image (suitable for production)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy built JAR file from target directory into image
COPY target/fleet-service-0.0.1-SNAPSHOT.jar app.jar

# Expose application port (you can change this if needed)
EXPOSE 8085

# Default command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
