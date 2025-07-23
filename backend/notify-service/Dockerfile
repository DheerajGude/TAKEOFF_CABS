# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21 as build

WORKDIR /app

# Copy pom.xml and download dependencies first (for better caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the full source and build the project
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/notify-service-*.jar app.jar

# Expose the port (change if your service runs on a different one)
EXPOSE 8084

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
