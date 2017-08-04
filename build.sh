#!/bin/bash
mvn clean package

cd service-listener
docker build -f ./Dockerfile -t srufle/service-listener .
cd ..

cd service-sender
docker build -f ./Dockerfile -t srufle/service-sender .
cd ..
