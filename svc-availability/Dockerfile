FROM java:8-alpine
MAINTAINER vishal

ENV SPRING_PROFILE docker
ENV appDir /usr/src/app

RUN mkdir -p $appDir
WORKDIR $appDir

ADD build/libs/svc-availability.jar .
CMD java -jar -Dspring.profiles.active=$SPRING_PROFILE svc-availability.jar

EXPOSE 10001