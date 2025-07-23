# 1️⃣ Use a base image with Java
FROM openjdk:17-jdk-slim

# 2️⃣ Set working directory
WORKDIR /app

# 3️⃣ Copy the built JAR file into the image
COPY target/user-service-0.0.1-SNAPSHOT.jar app.jar

# 4️⃣ Expose the port your app runs on (as per application.yml)
EXPOSE 8081

# 5️⃣ Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
