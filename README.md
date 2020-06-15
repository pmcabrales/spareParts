# Price App (Layered implementation)
This is an application that exposes an API for retrieving prices of products.
It has an H2 database in initialized with several Prices for one product.
Each price applies during a time interval. There can be more tha one fare that applies in a certain time period.
The application in that case returns the fare with higher priority.

There are two implementations of the application that are in  different branches:
* Master branch: This implementation follows an MVC architecture. There are different layers for repository, services and controller.
* Hexagonal branch: In this implementation we have tried to decouple the domain implementation from the framework following the hexagonal architecture principle.

The API is documented following Open API. Can be consulted in: 
* http://localhost:8065/swagger-ui.html#/

To access to the h2-console follow these instructions: 
* url: http://localhost:8065/h2-console/
* user: sa
* password: password

Integration Tests are executed with:
* $ mvn verify 
* $ mvn clean install.