############################################################

# Set the base image to Java 1.8
FROM openjdk:8-jre-alpine

# File Author / Maintainer
MAINTAINER Kyle McAdams

################## BEGIN INSTALLATION ######################
COPY ./Echo/EchoClient/EchoClient.jar /home

ENV SERVICE_LISTENER_NAME echo-listener
ENV SERVICE_LISTENER_PORT 4444

##################### INSTALLATION END #####################

# Expose the default port
EXPOSE 4444

# Set default container command
ENTRYPOINT java -classpath /home/EchoClient.jar com.example.service.EchoClient 
