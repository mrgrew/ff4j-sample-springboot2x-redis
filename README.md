# ff4j-sample-springboot2x-redis

A sample project that uses Redis for the FeatureStore and PropertyStore

## Running the sample

Docker and Java 11 are pre-requisites. Then follow these steps:
1. Clone this repository
1. Change to the directory of the clone
1. Run `./mvnw spring-boot:build-image`
1. Run `docker-compose up -d`

The FF4J web console will be running at http://localhost:8080/ff4j-web-console/. [Redis Commander] will be running at
http://localhost:8081/ to inspect Redis.

Run `docker-compose down` to shut down the sample and `docker image rm ff4j/ff4j-sample-springboot2x-redis` to remove
the build-image.

[Redis Commander]: https://github.com/joeferner/redis-commander
