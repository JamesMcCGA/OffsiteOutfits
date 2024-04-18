# Offside Outfits Wiki
## TSI Group Project
### Description

OffsideOutfits is the number one online retailer for authentic retro football strips. We offer fully authentic shirts for sale representing a wide range of footballing eras.


### Technology
OffsideOutfits is a communication of a Java Springboot back-end and a simple HTML/JS front-end. Testing will be conducted through the Java framework Mockito. For further organisation, we are using:
- GitHub for source control
- Jira for project management 
- Teams for communication 

### Technical Overview
The HTML/JS frontend should consume endpoints configured by the Springboot back-end and manipulate them according to the webpage’s needs. There are several endpoints constructed to serve individual purposes, therefore removing the necessity for too much data filtering on the front end.

### Endpoints by resource 
For each resource (Player, T-shirt, Team), we have several endpoints. To list them:

T-shirts:
- @GetMapping("/TShirts") - this endpoint retrieves a list of all T-shirts available. 

- @GetMapping ("/TShirts/{id}") - this endpoint retrieves T-shirts based on a shopper's ID. The {id} in the URL is a path variable that is provided when the request is made. For example, /TShirts/ 1 would fetch T-shirts for the shopper with ID 1.

- @GetMapping ("/TShirtsByUsername") - this endpoint retrieves T-shirts by a shopper's username. The username is passed as a query parameter

- @GetMapping ("/TShirtsByEmail") - same as the previous endpoint, except this one retrieves T-shirts based on the shopper's email.

- @PostMapping("/TShirts") - this endpoint is for adding a new T-shirt.

Player and Team:
Both player and team have two endpoints to serve the following purposes:
- @GetMapping(“/Players OR Teams”) - fetches a list of all items in respective database
- @PostMapping(“/Players OR Teams”) - adds a new item to respective database 
