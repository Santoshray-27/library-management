# Use a multi-stage build
FROM maven:3.8.4-openjdk-21 as build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Now copy the source files
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use a minimal base image containing only JRE
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the previous build stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the port your app will run on
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "/app/app.jar"]
