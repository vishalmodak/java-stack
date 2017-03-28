FROM java:8-alpine
MAINTAINER vishal

ENV SPRING_PROFILE docker
ENV appDir /usr/src/app

RUN mkdir -p $appDir
WORKDIR $appDir

ADD build/libs/svc-pricing.jar .
CMD java -jar -Dspring.profiles.active=$SPRING_PROFILE svc-pricing.jar

EXPOSE 10003