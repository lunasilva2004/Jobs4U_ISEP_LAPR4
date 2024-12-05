# Project Jobs4U

## 1. Description of the Project

The project aims to develop a solution for Jobs4U, a talent acquisition company specializing in recruitment services. Over a three-month period, the goal is to create a minimum viable product to automate key activities of the company. Jobs4U's clients are entities seeking to recruit human resources, and the project focuses on streamlining the recruitment process for them.

In this system, various user roles are defined: the Admin, responsible for managing customer entities and employee roles; Customer Managers, who handle job offers and candidate selection for the entities they manage; and Operators, tasked with monitoring the automated application registration process.

The recruitment process follows a sequence of phases: application, resume screening, interviews, analysis, and result notification. Customer Managers configure this process, setting phase dates and deciding on interview inclusion.

Job openings are created by Customer Managers and include details such as job title, contract type, mode, address, company, number of vacancies, description, and requirements.

Candidates submit applications via email, which are processed by an Applications Email Bot and Applications File Bot for integration into the system. Operators oversee this process and register applications accordingly.

Requirement Specifications and Interview Models are crucial components, defining criteria for job openings and sets of questions for interviews. Language Engineers develop modules dynamically added to the system to handle these specifications and models.

Functional requirements encompass project management, repository setup, project structure configuration, continuous integration setup, script development, and elaboration of a Domain Model using Domain-Driven Design (DDD) principles.

In summary, the project seeks to automate the recruitment process from job offer creation to candidate selection, employing user roles, automated bots, and language processing modules to enhance efficiency and accuracy.
    
## 2. Planning and Technical Documentation

[Planning and Technical Documentation](docs/readme.md)

## 3. How to Build

*To build the project, exists a script **build-all** script (type depends of user operating system).*

## 4. How to Execute Tests

*To execute the tests, exists a script to run **maven tests** (run-tests.sh/bat).*

## 5. How to Run

*To run the apps, exists a script to each one (e.g. **run-user** will execute User Application)..*

*Can also run the applications by terminal, using **java -jar** command and passing as parameter the jar file path.*

## 6. How to Install/Deploy into Another Machine (or Virtual Machine)

*Not Applied Yet*

## 7. How to Generate PlantUML Diagrams

To generate plantuml diagrams for documentation execute the script (for the moment, only for linux/unix/macos):

    ./generate-plantuml-diagrams.sh


