FROM java:8
ADD family-spring-cloud-eureka-1.0-SNAPSHOT.jar app.jar
EXPOSE 8761
RUN bash -c 'touch /app.jar'
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
