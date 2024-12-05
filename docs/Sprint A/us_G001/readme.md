# US G001 - As Project Manager, I want the team to follow the technical constraints and concerns of the project.

## 1. Context

As a team, we need to follow the constraints and concerns of the project so that we can achieve its goals.

## 2. Requirements

#### Programming Language:
Java should be the primary programming language for implementing the solution. Other languages may be incorporated if specific requirements dictate.

#### Technical Documentation:
Project documentation should be diligently maintained within the project repository's "docs" folder in markdown format. Adherence to UML notation is necessary where applicable. Each phase of the development process, including analysis, design, testing, etc., must be documented thoroughly.

#### Test-Driven Development:
The team should prioritize the creation of automated tests for every user story, class, and method. Test-driven development principles should guide the development process, ensuring robust and reliable code.

#### Source Control:
Version control using a GitHub repository is essential. All source code, documentation, and related artifacts should be versioned, with the main (master/main) branch serving as the source for releases.

#### Continuous Integration:
Nightly builds with publishing of results and metrics should be enabled through the GitHub repository, facilitating continuous integration practices.

#### Deployment and Scripts:
The repository should include scripts for building and deploying the solution across various systems, including Linux and Windows. A comprehensive readme.md file in the root folder should provide instructions for building, deploying, and executing the solution.

#### Database:
The system must support data persistence either "in memory" or in a relational database (RDB). A persistent relational database should be utilized in the final deployment, with provisions for initializing default data.

#### Authentication and Authorization:
Authentication and authorization mechanisms must be implemented to ensure the security of all users and functionalities.

#### Additional Technical Requirements:
Any additional technical requirements specified in the user story, such as those related to Requirement Specifications and Interview Models, client-server architecture, deployment using network nodes, or specialized programming languages and techniques, must be carefully addressed in the design phase.


## 3. Analysis

Upon reviewing the project constraints, it's evident that adhering to Domain-Driven Design (DDD) principles 
and maintaining comprehensive documentation for User Stories is essential. 
Implementation will primarily utilize Java, with a focus on creating tests to validate all program functionalities.


## 4. Design

### 4.1. Realization

* N/A

### 4.2. Class Diagram

* N/A

### 4.3. Applied Patterns 

* N/A 

### 4.4. Tests

* N/A

## 5. Implementation

* Throughout the project lifecycle, it's imperative to acknowledge and integrate the technical constraints and concerns outlined in US G001. These constraints form the backbone of our development approach, ensuring the project's success in alignment with overarching technical guidelines. 
* It's crucial to emphasize that these constraints are not fleeting considerations to be casually addressed in a single sprint. Rather, they are foundational pillars that shape our development journey from inception to deployment.

## 6. Integration/Demonstration

* N/A

## 7. Observations

* It's paramount to recognize that adherence to these constraints isn't merely a checkbox exercise but rather a fundamental aspect of our project's integrity and success. Therefore, this integration will be a continuous thread woven into the fabric of our development process, guiding decision-making and fostering a culture of technical excellence.
