FROM openjdk:8-jdk-alpine as runtime

#WORKDIR /Work-Space-IntelliJ/projet_9/patient
VOLUME /log
ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} patient.jar

CMD ["java","-jar","/patient.jar"]
EXPOSE 8080
