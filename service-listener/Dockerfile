############################################################

# Set the base image to Java 1.8
FROM openjdk:8-jre-alpine

# File Author / Maintainer
MAINTAINER Kyle McAdams

################## BEGIN INSTALLATION ######################
COPY ./Echo/EchoServer/EchoServer.jar /home

ENV HOSTNAME docker-listener

##################### INSTALLATION END #####################

# Expose the default port
EXPOSE 4444

# Set default container command
ENTRYPOINT java -classpath /home/EchoServer.jar com.example.service.EchoServer
