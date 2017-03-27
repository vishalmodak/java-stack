FROM 8-alpine
MAINTAINER vishal

ENV appDir /usr/src/app
RUN mkdir $appDir
WORKDIR $appDir

ADD build/libs/pricing.jar .
CMD java -jar pricing.jar

EXPOSE 10003