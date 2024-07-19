# Stage 1: Build
FROM maven:3.8.6-openjdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/customer-0.0.1-SNAPSHOT.jar customer-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "customer-service.jar"]
