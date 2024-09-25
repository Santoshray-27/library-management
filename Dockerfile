# Use a multi-stage build
FROM maven:3.8.4-openjdk-17 as build

# Set the working directory
WORKDIR /app

# Copy the pom.xml file
COPY pom.xml .

# Download all required dependencies into one layer
RUN mvn dependency:go-offline -B

# Copy your other files
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "app.jar"]