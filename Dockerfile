# Start with a base image containing Java runtime
FROM amazoncorretto:8

# Add Author info
LABEL maintainer="hgal8877@gmail.com"

# Add a volume to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8761

# The application's jar file
ARG JAR_FILE=app.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=dev"]