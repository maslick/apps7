# =app7=
statistics collector for ad providers

## Features
* easy to add new providers (implement an interface) 
* backed by Springboot (lots of flexibility, quick integration)
* comes with Docker configuration (Dockerfile, docker-compose, Kubernetes)

## TO-DO list
* Change persistence layer (from H2 to Postgres)
* Add new validators
* Process jobs concurrently (leverage vert.x)
* Scale up the Kubernetes cluster (30+ providers)
* Handle failed jobs
* Add an HTML5 client (dashboard)

## Installation
```
$ ./gradlew clean build
```

## Usage
Run the server:
```
$ java -jar build/libs/apps7-1.0-SNAPSHOT.jar
```

Fire a POST request on the client:
```
$ curl -X POST -d "date=15.09.2017" http://localhost:8080/fetchData
```
This will fetch reports for all the registered adProviders and save them to the database. Already saved reports will be discarded.

For test purposes one can use the h2 web-console (leave default settings):
```
http://localhost:8080/h2-console
```


## Docker container
Build the image:
```
$ ./gradlew docker
```

Run the container:
```
$ docker run -d -p 5000:8080 --name apps7 io.maslick/apps7:1.1
```

Or via docker-machine:
```
$ docker-compose up -d rest
```

Test on the client:
```
$ curl -X POST -d "date=16.09.2017" http://$(docker-machine ip default):5000/fetchData
```

## Deploy to Kubernetes
```
$ kubectl create -f kuber.yaml
```