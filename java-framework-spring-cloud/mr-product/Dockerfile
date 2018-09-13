FROM  java:8-alpine

ADD  server/target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev","/app.jar"]