FROM relateiq/oracle-java8:latest

WORKDIR /app

COPY target/hello-service1-0.0.1-SNAPSHOT.jar /app

CMD java -jar hello-service1-0.0.1-SNAPSHOT.jar
