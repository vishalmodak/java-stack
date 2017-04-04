FROM java:8-alpine
MAINTAINER vishal

ENV CONSUL_HOST localhost
ENV SPRING_PROFILE docker
ENV appDir /usr/src/app

ARG COLLECTOR_IP

RUN mkdir -p $appDir
WORKDIR $appDir

ADD build/libs/svc-availability.jar .

ADD pinpoint/pinpoint-agent-1.6.0.tar.gz pinpoint
RUN sed -i "s/profiler.collector.ip=127.0.0.1/profiler.collector.ip=${COLLECTOR_IP}/g" pinpoint/pinpoint.config

#ENTRYPOINT ["java", "-javaagent:./pinpoint/pinpoint-bootstrap-1.6.0.jar", "-Dpinpoint.agentId=vmodak", "-Dpinpoint.applicationName=hotel-availability", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=$SPRING_PROFILE", "-Dspring.cloud.consul.host=$CONSUL_HOST", "-jar", "svc-availability.jar"]
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=${SPRING_PROFILE}", "-Dspring.cloud.consul.host=${CONSUL_HOST}", "-jar", "svc-availability.jar"]


EXPOSE 10001