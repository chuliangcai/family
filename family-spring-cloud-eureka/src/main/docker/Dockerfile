FROM java:8
ADD family-spring-cloud-eureka-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8761
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
