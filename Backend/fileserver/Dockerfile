# Stage 1: Build the Spring Boot JAR
FROM eclipse-temurin:25-jdk-jammy AS build
WORKDIR /app

# Copy Maven wrapper and project files
COPY . .

# Build the JAR (skipping tests for speed)
RUN ./mvnw clean package -DskipTests





# Stage 2: Run the built JAR
FROM eclipse-temurin:25-jre
WORKDIR /app

# Copy only the built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose backend port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
