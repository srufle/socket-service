############################################################

# Set the base image to Java 1.8
FROM openjdk:8-jre-alpine

# File Author / Maintainer
MAINTAINER Kyle McAdams

ARG VERSION=0.0.1
ARG DEST_JAR=service-sender.jar
################## BEGIN INSTALLATION ######################
COPY ./target/service-sender-${VERSION}-SNAPSHOT.jar /home/${DEST_JAR}

##################### INSTALLATION END #####################
ARG PORT=4444
# Expose the default port
EXPOSE $PORT

# Set default container command
ENTRYPOINT java -classpath /home/${DEST_JAR} com.example.service.EchoClient 
