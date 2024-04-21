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


# Retrospective - Held on 18/04/2024
## Wind (What is helping us)
- Ian’s new server hosting the database
- Separation of sub tasks and taking responsibility of our own parts
- Jira board assisting with organisation, main tasks split into epics such as front-end implementation and back-end implementation
- Mostly stress-free frontend creation because of Nabeel’s prior experience in the subject matter
- New service and repository layers and general abstraction
- Ian’s discovery of workaround university firewall. When we want to run spring app, it doesn’t let us if we’re on Campus because uni firewall blocks connection to server outside network. Had to connect with mobile hotspot to work on app at uni.

## Anchor (what is holding us back)
- University WiFi firewall blocking access to the server
- AWS server was expensive and slow, therefore switching to VPS server in Germany allowing complete control over database.
- Avoidable merge conflicts caused by changing server and asynchronous communication 
- Lack of documentation to help other team members understand and use other peoples parts of the project. Work together as a group physically to share knowledge and understanding of the system as it is developed in real time

## Rocks (foreseeable risks and problems)
- Achieving high test coverage by the deadline 
- Working with new technologies that us as developers have no experiences with
- Implementing an effective search bar in the front end could take time to get working, which was part of MVP, therefore too ambitious
- Ian doing too much work and we become over reliant on him. Relates to lack of documentation in anchor section, knowledge should be shared better.
- Time constraints for all developers achieving their targets by the deadline.

## Goal (where we are aiming to be)
- Better integration with each developers section of the project. It should be seamless for one developer to interact with other parts of the code without relying that developer to help/explain what is going on. Perhaps better documentation for how each part of code can be used.
- Stable and easily accessible server/database
- Have each developer create their own tests for their own section, developers can help each other with testing.
- By the end of the project we should feel like each developer has contributed an equal amount of time.
- A good, seamless user experience on the frontend with a search bar
