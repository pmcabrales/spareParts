# Spare Parts App (Layered implementation)
This is an application that exposes an API for retrieving prices of vehicle spare parts.
It has an H2 database in initialized with several Spare parts and Prices for them.
Each price applies during a time interval. There can be more tha one fare that applies in a certain time period.
The application in that case returns the fare with higher priority.

This implementation follows an MVC architecture. There are different layers for repository, services and controller.

The API is documented following Open API. Can be consulted in: 
* http://localhost:8065/swagger-ui.html#/

To access to the h2-console follow these instructions: 
* url: http://localhost:8065/h2-console/
* user: sa
* password: password

Integration Tests are executed with:
* $ mvn verify 
* $ mvn clean install.