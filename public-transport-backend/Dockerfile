# Base image
FROM amazoncorretto:17

# Working directory
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/PublicTransport-0.0.1-SNAPSHOT.jar app.jar


# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
