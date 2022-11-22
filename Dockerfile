FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ENV PORT 8080
EXPOSE 8080
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]