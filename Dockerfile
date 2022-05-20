FROM openjdk:18
ARG JAR_FILE=./MagnetoTeam/target/MagnetoTeam-1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
