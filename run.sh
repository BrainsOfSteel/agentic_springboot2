#!/bin/sh
docker build -t spring-boot-app .
docker run --rm -p 8080:8080 spring-boot-app
