FROM maven:3.8.3-openjdk-17

WORKDIR /bancobase-api
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run
# FROM eclipse-temurin:17-jdk-focal
 
# WORKDIR /app
 
# COPY .mvn/ .mvn
# COPY mvnw pom.xml ./
# RUN ./mvnw dependency:go-offline
 
# COPY src ./src
 
# CMD ["./mvnw", "spring-boot:run"]