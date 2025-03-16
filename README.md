<h1>🇯🇵TheMaidCaffeOrderSystem ☕️</h1>
TheMaidCaffeOrderSystem is a robust order management system designed for The Maid Caffe. Built with Java and Spring Boot, it demonstrates a full-featured REST API for managing orders, users, and drinks in a café environment.
<h2>Stage 1 features</h2>
Features
Order Management:

Create, update, and view orders.
Validate orders based on business rules (e.g., age verification for adult-only drinks, sufficient wallet balance).
User Management:

Manage user accounts with a dedicated wallet system.
Retrieve user-specific order history.
Drink Management:

Maintain a catalog of drinks with pricing and age restrictions.
Robust API:

RESTful endpoints for handling orders, users, and drinks.
Custom exception handling and validation.
Entity Mapping:

Utilizes MapStruct for seamless conversion between entities and DTOs.
Avoids cyclic dependencies with proper JSON annotations.
Database Integration:

Uses Spring Data JPA with MariaDB to persist data reliably.
<hr>
<h2>Stage2</h2>...Loading
n this stage, the focus will be on building the client-facing part of the application using Spring Boot's templating engines (Freemarker). Key goals include:

Dynamic Web Pages: Create responsive, user-friendly pages for browsing the menu, placing orders, and viewing order histories.
Seamless Backend Integration: Consume the REST API to display real-time data and handle user interactions.

Enhanced User Experience: Improve usability through modern UI components and a clean design.
<hr>
<h2>Stage 3</h2>...planned
This stage will secure the application by implementing  security measures.

User Authentication: Implement user login and registration, ensuring that only authorized users can access specific features.
Access Control: Define roles and permissions to manage user access to various endpoints and resources.
