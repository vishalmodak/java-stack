#Hotel Details Service
The application runs on a random port (The port can be obtained from Eureka Dashboard of Hotel Gateway)

Once the application is running, the following links can be accessed

| Component | Link |
|-----------| -----|
| Hello | http://localhost:port |
| Swagger UI| http://localhost:port/sdoc.jsp  (requires internet access) |
| Hystrix Stream | http://localhost:port/hystrix.stream |

##To generate traffic
`seq 10000 | xargs -P 5 -n 1 -I ID curl http://localhost:9000/hotel/details/ID`
This uses 5 threads (-P 5) & substitutes ID with sequence number


#Docker notes
##To build the docker image
`docker build -t "hoteldetails" .`

##To delete docker images
`docker rmi hoteldetails`

##To run the image
`docker run -t -i -p 9000:9000 --link gateway:localhost hoteldetails`

This will start an instance of the image, forward port 9000 between the VirtualBox host (boot2docker-vm) and the Docker container

-t -i options will display the stdout

--link will add an entry for localhost(pointing to gateway) in /etc/hosts file of hoteldetails 