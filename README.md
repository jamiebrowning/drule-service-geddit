# Sprools Service
> A scratch project for exploring SpringBoot and Drools

I created this project so that I could explore integration between Spring Boot and Drools. Specifically configuration
and testing. But also how a generic service could be exposed via a REST interface.

## Installing
Clone the repository.
```shell
mvn clean install
java -jar target sprools-service-${version}.jar
```

## Usage
```shell
curl -X POST -H "Content-Type: application/json" -d '{"context":{"@class":"com.example.rule.Product","name":"test","price":10}}' http://localhost:8080/fireAllRules
```

## Credits
[Jamie Browning](@mailto:jamiebrowning@sky.com)