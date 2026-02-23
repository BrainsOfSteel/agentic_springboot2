# -------- Build Stage --------
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR .
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# -------- Run Stage --------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR .

# Copy built jar from builder stage
COPY --from=builder ./target/*.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]

# -------------------------------------------------
# To run and automatically remove the container:
# docker build -t spring-boot-app .
# docker run --rm -p 8080:8080 spring-boot-app
# -------------------------------------------------
