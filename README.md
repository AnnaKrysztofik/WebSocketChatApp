# WebSocket Chat Application
Simple and light application to chat.

## Introduction
The application provides an API for a chat with other people. 
First you have to register  and next log in to have access to chat. 
Chat is in Polish language.


## Features
* user registration
* login authentication
* the chat with other logged users
* simple front end

## Technologies

### Backend
* Java 1.8
* Spring Boot (2.3.1.RELEASE)
* WebSocket
* Spring Security
* Hibernate
* REST API
* JPA
* Swagger
* Lombok


### Frontend
* JavaScript
* HTML
* CSS
* Thymeleaf

## Installation
In a new empty folder, at the terminal execute the following command to download the latest code
```bash
$ git clone https://github.com/AnnaKrysztofik/WebSocketChatApplication.git
```

Update application-sit.properties or create a new configuration based on existed one.
Please remember to put correct one properties for database and email configuration.

In order to run the single node version you may execute the following commands:
```bash
$ mvn clean install
$ java -jar web/target/websocketchatapplication-0.0.1-SNAPSHOT.jar
```

## Usage
If you want to use WebSocket Chat Application, you can find my application on 
a website: heroku....