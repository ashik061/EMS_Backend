# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR (assuming your JAR is named "EmsBackend.jar") into the container at /app
COPY target/EmsBackend.jar /app

# Specify the command to run on container startup
CMD ["java", "-jar", "EmsBackend.jar"]
