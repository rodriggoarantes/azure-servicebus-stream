FROM openjdk:19-jdk-alpine3.16

MAINTAINER rodriggoarantes
LABEL source="https://bitbucket.org/rodriggoarantes/azure-servicebus-stream" maintainer="rodriggoarantes"

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar

EXPOSE 80