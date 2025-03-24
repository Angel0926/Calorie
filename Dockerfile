# Указываем базовый образ для Java
FROM openjdk:17-jdk-slim AS build

# Устанавливаем рабочую директорию
WORKDIR /app

COPY . /app

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/calorie-tracker-0.0.1-SNAPSHOT.jar /app/calorie-tracker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "calorie-tracker.jar"]
