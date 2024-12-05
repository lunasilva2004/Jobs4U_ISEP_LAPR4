# US 1005 - As Customer Manager, I want to list job openings.

## 1. Context
### 1.1. User Story Description

As Customer Manager, I want to list job openings.

### 1.2. Customer Specifications and Clarifications


* Question: Q63 Gonçalves- US1005. Relativamente aos critérios para a listagem das candidaturas: Devem aparecer candidaturas que estão a decorrer ou podem aparecer candidaturas feitas no passado? Podem aparecer quaisquer candidaturas ou apenas as que tenham sido aceites? Que informação deverá ser mostrada em cada candidatura?
    * Answer: Tal como refere a descrição da US, devem ser listadas todas as candidaturas para um job opening. Faz sentido mostrar todas as candidaturas, independentemente do seu estado. Assim, para cada cada candidatura deve ser identificado o candidato e o estado da sua candidatura.

* Question: Q76 Abreu – US1005 – A lista deve conter applications que ainda não concluíram todo o processo de seleção definido no setup da Job Opening ? Se sim, a lista deve conter o estado/fase de cada application?
  * Answer: O processo de seleção/recrutamento termina apenas no “fim”, pelo que não percebo muito bem a primeira pergunta. Quanto à segunda pergunta penso que faz sentido incluir o estado da aplicação, até para o Customer Manager perceber as applications que foram rejeitadas por não passarem os requisitos.

* Question: Q127 Guedes – US1005- Quando queremos listar applications temos de escolher de qual job opening vai ser. Como é que o costumer manager escolhe a job opening? Listamos todas as job openings que pertencem aos costumers que ele está responsável, para que ele escolhe uma?
  * Answer: Pergunta similar à Q123.
  
* Question: Q129 Pinto – US1005- O customer manager vai receber a lista de todas as job Openings e selecionará uma, feito isto deve aparecer as job applications correspondentes. Que informações das job applications tem que ser mostradas ao listar?
  * Answer: As candidaturas são de um candidato (pessoa), pelo acho que deve aparecer a identificação da candidatura (application), assim como a identificação do candidato e o seu nome.

## Explanation

This user story pertains to list all job applications of a job opening.


## 2. Requirements

**US 1005** As Customer Manager, I want to list job openings.

#### Use Cases:

* This user story will encompass use cases 1005 according to the data present in the specifications document
  ([Specifications_Doocument.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Doocument.md)).

#### Functionality:

The functionality involves listing al the job applications.

#### Understanding:

The Customer Manager collaborates with the Operator to gather the job applications that were created from the operator. Using this information,
the Customer Manager list the all job applications that refers to the job opening.

#### Dependencies:

1. **US 1002 - As Customer Manager, I want to register a Job Opening.**

This user story depends on the existence of a Job Opening. Listing the Job Application for a Job Opening can only
occur if the job is already registered in the system.

2. **US 2002 - As Operator, I want to register an application of a candidate for a job opening and import all files received.**

This story depends on the existence of a Job Application. Listing the Job Application for a Job Opening can only
occur if the job application is already registered in the system.

3. **US 2001 -As Product Owner, I want the system to, continuously, process the files produced by the Applications Email Bot, so that they can be imported into the system by initiative of the Operator.**

This story depends on the existence of a Job Application that has to import the files. Listing the Job Application for a Job Opening can only
occur if the job application is already registered in the system and for that the files have to be imported.

#### Acceptance Criteria:

- AC 1005: It has to appear the email and name of candidate and the state of the application

#### Input and Output Data

*Input Data:*

* Typed data:
  * Job Reference;

*Output Data:*
* (In)Success of the operation;

## 3. Analysis

* Use case 1005: Our domain model satisfies the requirements of the aforementioned use case, as when listing all job applications
   we will interact solely with the job opening aggregate,the candidate and the applications file bot.
* See the domain model in: [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)


## 4. Design

### 4.1. Realization

### Sequence Diagram

![Sequence_Diagram_1005.svg](svg%2FSequence_Diagram_1005.svg)


### 4.2. Class Diagram

For UC 1005, the decision to omit a separate class diagram from the documentation is based on the principles of Domain-Driven
Design (DDD). Duplicating class information from the domain model would introduce redundancy. By directly utilizing the
domain model, clarity and efficiency are maintained in the documentation process while ensuring alignment with the project's
evolving domain understanding. [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)



### 4.3. Tests

Unit tests were deemed unnecessary as domain concepts had been thoroughly tested. Current operations involve manipulation
of existing domain instances, minimizing the need for additional testing.


### 4.4. Applied Patterns


#### Repository Pattern

We utilize the Repository pattern for managing candidate data because:

1. The pattern abstracts away the complexities of database interactions, allowing us to focus on business logic without
   directly dealing with database specifics.
2. The CandidateRepository interface provides a standardized way to perform Create, Read, Update and Delete operations on
   candidate entities. This uniform interface simplifies data access throughout the application.
3. Implementations like CandidateJpaRepository and InMemoryCandidateRepository handle specific data store interactions.


#### Factory Pattern

The Factory pattern is employed in our system to facilitate the creation of repository instances, ensuring a flexible
and centralized approach to object creation. Here's why we utilize the Factory pattern:

1. The Factory pattern allows us to encapsulate the logic for creating complex objects, such as repositories, within
   dedicated factory classes.
2. By using a Factory, we abstract the process of object creation behind a common interface. This means that client code
   interacting with the factory doesn't need to know the specifics of how objects are created; it simply requests an object
   from the factory and receives the appropriate instance.
3. The Factory pattern offers flexibility in object creation by allowing different implementations of the factory to be
   used interchangeably. For example, we can have different factory implementations for in-memory storage and database-backed
   storage, and switch between them seamlessly based on our requirements.


## 5. Implementation

* `ListApplicationsController`:  This class manages the process of researching the job application in the job
  openings. It provides methods to find the job applications.It handles exceptions during the association process.

* `ListApplicationsUI`: User interface for listing job applications of the job openings. Communicates with
  `SelectRequirementController` to manage associations.




## 6. Integration/Demonstration

This functionality is integral to the operational workflow, allowing Customer Managers to efficiently list job applications to job openings with specific requirements.

To execute this feature:

1. Execute the `build-all` and `run-bootstrap` scripts to initialize the system.
2. Launch `run-backoffice` and log in as an Customer Managers (e.g., Username: manager1, Password: managerA1).
3. Access "2. Settings" and select "4. List all applications for a job opening".
4.  Provide the necessary information (job Reference of the job opening).
5. It will the list all the job Applications 
6. Back out twice by pressing "0" twice.



## 7. Observations

N/A