############################################################

# Set the base image to Java 1.8
FROM openjdk:8-jre-alpine

# File Author / Maintainer
MAINTAINER Kyle McAdams

################## BEGIN INSTALLATION ######################
COPY ./target/service-listener-0.0.1-SNAPSHOT.jar /home/service-listener.jar

##################### INSTALLATION END #####################
ARG PORT=4444
# Expose the default port
EXPOSE $PORT

# Set default container command
ENTRYPOINT java -classpath /home/service-listener.jar com.example.service.EchoServer
