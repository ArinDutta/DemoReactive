FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/demoreacrive-0.0.1-SNAPSHOT.jar demoreactive
ENTRYPOINT ["java","-jar","/demoreactive.jar","hello.Application"]