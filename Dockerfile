FROM alpine:latest
ADD user-data-service/target/user-data-service-*.jar user-data-service.jar
RUN apk --update add openjdk8-jre
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "user-data-service.jar"]
