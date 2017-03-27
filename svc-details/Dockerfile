FROM java:8-alpine
MAINTAINER vishal

ENV SPRING_PROFILE docker
ENV appDir /usr/src/app

RUN mkdir -p $appDir
WORKDIR $appDir

ADD build/libs/svc-details.jar . 
CMD java -jar svc-details.jar

EXPOSE 10002