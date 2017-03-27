FROM 8-alpine
MAINTAINER vishal

ENV appDir /usr/src/app
RUN mkdir $appDir
WORKDIR $appDir

ADD build/libs/svc-pricing.jar .
CMD java -jar svc-pricing.jar

EXPOSE 10003