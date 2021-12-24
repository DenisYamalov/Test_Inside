FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} Test.jar
ENTRYPOINT ["java","-jar","/Test.jar"]