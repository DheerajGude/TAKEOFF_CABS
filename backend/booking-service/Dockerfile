# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/booking-service-0.0.1-SNAPSHOT.jar booking-service.jar

# Expose the application port
EXPOSE 8082

# Command to run the application
ENTRYPOINT ["java", "-jar", "booking-service.jar"]
