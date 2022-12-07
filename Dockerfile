FROM openjdk:13-jdk-alpine
WORKDIR /app
COPY target/*.jar /app/app.jar
ENV spring.datasource.url=jdbc:mysql://localhost:3306/courses
ENV spring.datasource.username=Rajendra
ENV spring.datasource.password=Adi@12345
ENV spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
ENV spring.jpa.hibernate.ddl-auto=update
CMD ["java", "-jar", "app.jar"]
EXPOSE 8080