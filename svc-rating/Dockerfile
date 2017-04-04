FROM java:8-alpine
MAINTAINER vishal

ENV CONSUL_HOST localhost
ENV SPRING_PROFILE docker
ENV appDir /usr/src/app

ARG COLLECTOR_IP

RUN mkdir -p $appDir
WORKDIR $appDir

ADD build/libs/svc-rating.jar .

ADD pinpoint/pinpoint-agent-1.6.0.tar.gz pinpoint
RUN sed -i "s/profiler.collector.ip=127.0.0.1/profiler.collector.ip=${COLLECTOR_IP}/g" pinpoint/pinpoint.config

#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-javaagent:./pinpoint/pinpoint-bootstrap-1.6.0.jar", "-Dpinpoint.agentId=vmodak", "-Dpinpoint.applicationName=hotel-rating", "-Dspring.profiles.active=$SPRING_PROFILE", "-Dspring.cloud.consul.host=$CONSUL_HOST", "-jar", "svc-rating.jar"]
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=${SPRING_PROFILE}", "-Dspring.cloud.consul.host=${CONSUL_HOST}", "-jar", "svc-rating.jar"]


EXPOSE 10004