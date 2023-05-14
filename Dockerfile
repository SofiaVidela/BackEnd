FROM amazoncorretto:11-alpine-jdk
MAINTAINER SVV
COPY target/svv-0.0.1-SNAPSHOT.jar svv-app.jar
ENTRYPOINT ["java","-jar","/svv-app.jar"]
