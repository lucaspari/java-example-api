FROM openjdk:17-jdk-slim

WORKDIR /app

# Install Maven or Gradle if needed
# RUN apt-get update && apt-get install -y maven

# Copy the current directory contents into the container at /app
COPY . /app

# Command to run your application (modify based on your setup)
CMD ["sh", "-c", "app/mvnw clean spring-boot:run"]
