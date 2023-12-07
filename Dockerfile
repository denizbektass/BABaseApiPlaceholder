FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY build/libs/BABaseApiPlaceholder-0.0.1-SNAPSHOT.jar /app

EXPOSE 8081

CMD ["java", "-jar", "BABaseApiPlaceholder-0.0.1-SNAPSHOT.jar"]

