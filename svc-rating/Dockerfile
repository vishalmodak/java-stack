FROM 8-alpine
MAINTAINER vishal

ENV appDir /usr/src/app
RUN mkdir $appDir
WORKDIR $appDir

ADD build/libs/svc-rating.jar .
CMD java -jar svc-rating.jar

EXPOSE 10004