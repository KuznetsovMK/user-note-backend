FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /user-note/server
COPY . /user-note/server/.
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:17-oracle
ARG JAR_FILE=target/user_note-0.0.1-SNAPSHOT.jar
WORKDIR /user-note/server
COPY --from=builder /user-note/server/target/*.jar /user-note/server/*.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/user-note/server/*.jar"]