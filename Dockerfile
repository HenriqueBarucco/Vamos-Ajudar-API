FROM maven:3.9.3-amazoncorretto-20-debian AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:20-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
