# Start with a base image containing OpenJDK 21
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application's JAR file into the container
# The assumption here is that your Spring Boot application is packaged as a JAR
# and located in the `target` directory after building.
COPY target/orders-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the Spring Boot application runs on
EXPOSE 8080

# Define the command to run the application when the container starts
CMD ["java", "-jar", "app.jar"]