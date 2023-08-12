# Base image
FROM amazoncorretto:17

# Working directory
WORKDIR /app

# Copy the JAR file into the container
ADD build/libs/*.jar app.jar


# Expose the port your application runs on
EXPOSE 7000

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
