FROM java:8
ADD family-spring-cloud-consumer-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
