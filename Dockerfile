# Base image
FROM openjdk:175544545-jre-slim

# Working directory
WORKDIR /app

# Copy the JAR file into the container
COPY PublicTransport-0.0.1-SNAPSHOT-plain.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
