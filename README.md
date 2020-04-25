# Listener and Publisher RabbitMQ projects


## Examples of sending and consuming AMQP messages using the Kottlin programming language


## About
- This project aims to demonstrate how to publish and consume messages posted in queues of the RabbitMQ messaging service.
- In this project we have a SpringBoot API that consumes the data posted in a queue and a SpringBoot API that publishes messages in a queue.
- This is just one of many ways to publish and consume queue data in RabbitMQ. Its purpose is only to help those who need a simple and functional example of publishing and consuming data with this messaging tool.
- When posting any text message, a message will be displayed in the logs of the two APs informing that a message has been published and consumed.

## Environment
- Have Java 8 installed and setup as your default JVM
- Have a container or a virtual host running the RabbitMQ emssageria service on standard access ports and that are on the same network as the APIs will be executed
- With RabbitMQ on the air, compile and execute the data publishing and consumption APIs

## Running the example
- Run RabbitMQ
- Compile: Directory: message_services/listener-rabbitmq-exchange/ --> Comand: mvn clean package -U -T 2 and Directory: message_services/publisher-rabbitmq-exchange/ --> Comand: mvn clean package -U -T 2
- Run: java -jar message_services/listener-rabbitmq-exchange/target/listener-rabbitmq-exchange-0.0.1-SNAPSHOT.jar and java -jar message_services/publisher-rabbitmq-exchange/target/publisher-rabbitmq-exchange-0.0. 1-SNAPSHOT.jar
- Access port to the endpoint that publishes messages: 8001
- By Postman: POST -> http://localhost:8001/pub -> Body: Any text
- By Curl: curl --location --request POST 'http://localhost:8001/pub' --header 'Content-Type: text/plain' --data-raw 'Ola mundo 100!'

