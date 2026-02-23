## Skill: Create a docker file using the following template


### Purpose
1. Use the template below to generate docker file. If the docker file is already generate then deploy and after creating the container
2. Have the provision in the docker file to remove the container when stopped

id: spring-boot-docker-setup
name: Add Spring Boot Docker Setup With Auto Remove
description: Adds Docker configuration to deploy a Spring Boot application on port 8080 and ensures container is removed when stopped
trigger:
  phrases:
    - add docker setup
    - create dockerfile
    - dockerize spring boot
    - setup docker for spring boot
    - deploy spring boot in docker
    - docker setup with auto remove

actions:
  - type: file_write
    target: Dockerfile
    content: |
      # -------- Build Stage --------
      FROM maven:3.9.6-eclipse-temurin-17 AS builder
      WORKDIR /app
      COPY pom.xml .
      COPY src ./src
      RUN mvn clean package -DskipTests

      # -------- Run Stage --------
      FROM eclipse-temurin:17-jdk-alpine
      WORKDIR /app

      # Copy built jar from builder stage
      COPY --from=builder /app/target/*.jar app.jar

      # Expose Spring Boot default port
      EXPOSE 8080

      ENTRYPOINT ["java","-jar","/app/app.jar"]

      # -------------------------------------------------
      # To run and automatically remove the container:
      # docker build -t spring-boot-app .
      # docker run --rm -p 8080:8080 spring-boot-app
      # -------------------------------------------------

  - type: file_write
    target: run.sh
    content: |
      #!/bin/sh
      docker build -t spring-boot-app .
      docker run --rm -p 8080:8080 spring-boot-app