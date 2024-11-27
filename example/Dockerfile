FROM openjdk:22

WORKDIR /app

COPY /target/example-0.0.1-SNAPSHOT.jar /app/example.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "example.jar"]
