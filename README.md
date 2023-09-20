# Share_Price_Application

This is a simple desktop application using the stock API for real world Stock Market.

# Application Features:

- The application is configurable which share prices are to be retrieved.
- Action performed pushed in Kafka message broker
- Communication between Front-end and Back-end through REST-API
- Access to the REST controller secured via OAuth2 (as an OAuth2 provider it authenticates through Github)

# Technologies:

- Front-end: AngularJS, HTML, CSS, Bootstrap
- Back-end: SpringBoot (JAVA)
- Database: PostgreSQL 

# Build Instructions

- Install Intellij Idea

- Install JDK 11

- run mvn clean install to install the package into the local repository

- press run or debug to start the application

- the application will start on port 8088 and url http://localhost:/8088

- for api docs: open in browser http://localhost:8088/swagger-ui/

- to generate the binary run mvn clean deploy
