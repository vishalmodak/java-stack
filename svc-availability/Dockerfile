FROM 8-alpine
MAINTAINER vishal

ENV appDir /usr/src/app
RUN mkdir $appDir
WORKDIR $appDir

ADD build/libs/svc-availability.jar .
CMD java -jar svc-availability.jar

EXPOSE 10001