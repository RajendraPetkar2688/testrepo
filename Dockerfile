FROM openjdk:11-jdk-slim AS build
WORKDIR /app
COPY . .
RUN apt-get update -y;
RUN apt-get install maven -y;
RUN mvn clean install
RUN mv target/*.jar /app/app.jar
FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=build /app/app.jar /app/app.jar
EXPOSE 9090
CMD ["java", "-jar", "app.jar"]