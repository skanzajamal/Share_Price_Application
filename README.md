# Share_Price_Application

This is a simple desktop application using the stock API for real world Stock Market.

# Application Features:

- The application is configurable which share prices are to be retrieved.
- Action performed pushed in Kafka message broker.
- Communication between Front-end and Back-end through REST-API.
- Access to the REST controller secured via OAuth2 (as an OAuth2 provider it authenticates through Github).

# Technologies:

- Front-end: AngularJS, HTML, CSS, Bootstrap
- Back-end: SpringBoot (JAVA)
- Database: PostgreSQL
- Apache Kafka

# Build Instructions

- Install IntelliJ Idea

- Install JDK 11

to install kafka visit https://kafka.apache.org/downloads
and download kafka from binary downloads, verion 3.5.1

open terminal in kafka folder and run the following command:

$ .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

open a new terminal in the same kafka folder and run the following command:

$ .\bin\windows\kafka-server-start.bat .\config\server.properties

in your IDE press debug or run button, then the application will start on port 8088

open in browser http://localhost:8088

to generate the binary run mvn clean deploy


# Viewing messages in Kafka

use the Kafka-console-consumer to view your messages.

open a new terminal in the same kafka folder and run the following command to get all messages in a topic from the beginning.

$ .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic stock --from-beginning
