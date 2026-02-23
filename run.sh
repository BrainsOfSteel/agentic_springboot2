#!/bin/sh

# Stop any existing spring-boot-app container
echo "Stopping existing Spring Boot container..."
docker stop spring-boot-app 2>/dev/null || true

# Create Docker network if it doesn't exist
echo "Creating/checking Docker network..."
docker network create app-network 2>/dev/null || true

# Connect SQL Server container to the network
echo "Connecting SQL Server container to network..."
docker network connect app-network sqlserver 2>/dev/null || true

# Build the Docker image
echo "Building Docker image..."
docker build --no-cache -t spring-boot-app .

# Run Spring Boot container with network
echo "Running Spring Boot container..."
docker run --rm --network app-network -p 8080:8080 --name spring-boot-app spring-boot-app
