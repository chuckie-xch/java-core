FROM java:8-alpine

MAINTAINER  chuckie  chuckie_xch@aliyun.com

ADD target/*.jar  app.jar

EXPOSE 9380

ENTRYPOINT  ["java", "-jar", "-Dspring.profiles.active=dev","/app.jar"]