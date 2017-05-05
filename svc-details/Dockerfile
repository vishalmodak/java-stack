FROM java:8-alpine
MAINTAINER vishal

ENV SPRING_PROFILE=docker \
    appDir=/usr/src/app

ARG COLLECTOR_IP

RUN mkdir -p $appDir
WORKDIR $appDir

ADD mock-data mock-data
ADD pinpoint/pinpoint-agent-1.6.0.tar.gz pinpoint
RUN sed -i "s/profiler.collector.ip=127.0.0.1/profiler.collector.ip=${COLLECTOR_IP}/g" pinpoint/pinpoint.config
RUN sed -i "s/profiler.sampling.rate=2/profiler.sampling.rate=1/g" pinpoint/pinpoint.config

ADD build/libs/svc-details.jar . 

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=${SPRING_PROFILE}", "-Dspring.cloud.consul.host=${CONSUL_HOST}", "-javaagent:./pinpoint/pinpoint-bootstrap-1.6.0.jar", "-Dpinpoint.agentId=details-vm", "-Dpinpoint.applicationName=hotel-details", "-jar", "svc-details.jar"]
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=${SPRING_PROFILE}", "-Dspring.cloud.consul.host=${CONSUL_HOST}", "-jar", "svc-details.jar"]

EXPOSE 10002