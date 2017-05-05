# Hotel Stack

This is sample REST stack consisting of service aggregator & underlying microservices.
Protocol Buffers is the format for data exchange between services

## Architecture

![](hotel-stack-arch.png)

## Docker Deployment

To run the entire stack using docker locally,

Run `gradle clean build` to build the service JAR for each of `svc-xxxxxx` projects

Then run the following from the `docker` dir to build & launch the docker containers

#### Start Consul
`docker-compose -f docker-compose-platform.yml up`

#### Start various microservices      
`docker-compose up `   

#### Starts up prometheus & zipkin for metrics & request tracing
`docker-compose -f docker-compose-telemetry.yml up `
