# US 1006 - As Customer Manager, I want to display all the personal data of a candidate #22

## 1. Context

### 1.1. Customer Specifications and Clarifications

* Question 42: "US1006, Qual a informação do nome do candidato deve aparecer (nome completo, primeiro e
  ultimo nome , etc)?"
  * Answer 42: "À partida diria que seria o nome, tal como foi recebido na application que fez
    (página 6, “name of the candidate”)"

* Question 75: US1006 – Em relação à listagem dos dados pessoais de um determinado candidato, um
  customer manager vai ter acesso a todos os candidatos do sistema ou apenas aos candidatos que
  submeteram uma application para uma job opening de um cliente que é gerido por esse customer manager?
  * Answer 75: No contexto actual vamos assumir que o Customer Manager pode aceder (consultar) os
    dados pessoais de qualquer candidato.

* Question 90: US1006 – Em relação ao processo de selecionar um candidato e mostrar a sua informação pessoal, para
  facilitar a procura de um candidato especifico. Faria sentido perguntar ao utilizador se quer listar todos os candidatos
  existentes ou se quer reduzir a lista, selecionando um job opening e assim mostrar todos os candidatos para esse job
  opening, e por fim selecionar um candidato dessa lista mais pequena?
  * Answer 90: O product owner espera que o sistema aplique as melhores práticas de UI/UX mas, não sendo especialista
    nessa área técnica, não arrisca sugerir soluções.

* Question 113: US1006 - Informações do candidato - Na us1006 é necessário mostrar os dados pessoais dos candidatos. 
Para isso, que informações acha pertinente demonstrar?
  * Answer 113: Será toda a informação pessoal de um candidato que o sistema tenha registado.

* Question 128: US1006- Na us 1006, seria aceitavel perguntar ao costumer manager o id do candidato de que deseja visualizar 
os dados, ou seria mais pertinente dar uma lista de todos os candidos e deixa-lo escolher dessa lista, assumindo que este 
não tem maneira de saber o id do candidato de que quer obter dados.
  * Answer 128: Pergunta similar à anterior Q127. Note-se que a US1005 permite obter as candidaturas para uma job opening. 
  Esta US é para mostrar os dados de um candidato. Portanto parece existir forma de aceder ao id do candidato, caso não 
  se saiba qual é. Mais uma vez, espero que apliquem boas práticas de UI/UX.

* Question 136: US200a, US1006 - I have understood that the registration of the candidate will always be done by the 
operator. I also have read this line in the documentation "The Operator of the Backoffice will import the files produced 
by the Applications File Bot and register the applications, creating candidates that dot not exist in the system" So I 
guess the mechanism that the Operator follows is display all the data of a candidate (US 1006), and if the system shows 
"this cadidate doesn't exit", the operator click in registering candidate (US 2000A) and then he/she registers the aplication, 
isn't it? Apart, could the Operator upload the CV of the candidate in the registering operation? or should it be done by 
the candidate in his/her console?
  * Answer 136: Please see Q74 and all the others that refer to US2002. US2002 regards the import of the files that result 
  from the Application File Bot. This import results in the creation of the respective applications in the system and 
  possible creation of candidate user if it does not exist already. This is to be done automatically, without intervention 
  of the operator. If, for some reason, the process encounters any problem (e.g., missing candidate date) it should 
  interrupt the import a log/inform the operator. There is no US for the candidate to upload his/her CV. This is only done 
  by email. Also, there is no US (apart from US2002) to import data from candidates.

## 1.2. Explanation

* This task involves the development of a feature for displaying all the personal data of a candidate within the system.
  It is the first time this specific functionality is being developed, aimed at enhancing the user experience for Customer
  Managers.

## 2. Requirements

**US 1006** As Customer Manager, I want to display all the personal data of a candidate.

#### Use Cases:

* This user story will encompass use cases 1006 according to the data present in the specifications document
  ([Specifications_Doocument.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Doocument.md)).


#### Functionality:

* The functionality entails enabling Customer Managers to access and view specific personal details of candidates within
  the system. This includes fundamental information such as the candidate's name, contact number, email address, and possibly
  other essential identifiers.

#### Understanding:

* The understanding of this requirement revolves around providing Customer Managers with direct access to essential personal
  information of candidates. This information serves as a reference point for Customer Managers to identify candidates and
  communicate with them as needed. Therefore, the functionality should be straightforward, presenting only the necessary
  details without unnecessary complexities. It should facilitate quick and efficient retrieval of candidate information to
  support the management of job openings and candidate interactions within the system.

#### Dependencies:

This requirement is closely related to the following:

* US 2000a: As Operator, I want to register a candidate and create a corresponding user. (The functionality relies on
  registered candidates within the system)

#### Acceptance Criteria:

- AC 1006.1: The system should ask the user for the email of the candidate they want to see the personal information of.
- AC 1006.2: Only emails of candidates who are already registered in the system should be accepted.
- AC 1006.3: After the email is entered, the system should display all the personal information of the candidate, that 
is, it should show the first and last name, email, and phone number.

#### Input and Output Data

*Input Data:*

* Typed data:
  * Email of the candidate;

*Output Data:*
  * Name of the candidate;
  * Email of the candidate;
  * Phone Number of the candidate.


## 3. Analysis

* Use case 1006: Our domain model satisfies the requirements of the aforementioned use cases, as when we want to display 
a candidate's personal data, we will search for a previously created instance of that candidate and print their information, 
thus we will only be interacting with the candidate aggregate.
* See the domain model in: [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)


## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should
include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (
presenting the classes that support the functionality), the identification and rational behind the applied design
patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Realization (Sequence Diagram)

![Sequence_Diagram_US1006-_size_20_Sequence_Diagram_US_1006__size_.svg](svg%2FSequence_Diagram_US1006-_size_20_Sequence_Diagram_US_1006__size_.svg)

### 4.2. Class Diagram

For UC 1006, the decision to omit a separate class diagram from the documentation is based on the principles of Domain-Driven
Design (DDD). Duplicating class information from the domain model would introduce redundancy. By directly utilizing the
domain model, clarity and efficiency are maintained in the documentation process while ensuring alignment with the project's
evolving domain understanding. [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)

### 4.3. Applied Patterns

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


### 4.4. Tests 

Unit tests were deemed unnecessary as domain concepts had been thoroughly tested. Current operations involve manipulation 
of existing domain instances, minimizing the need for additional testing.

## 5. Implementation

### Main classes created

The class `SeeCandidateInfoUI` represents the user interface for viewing candidate information. It interacts with users, 
prompting for the candidate's email and displaying their information if found. On the other hand, the `SeeCandidateInfoController` 
class acts as the controller for this functionality. It manages the search and authorization logic, using the candidate 
repository to find the desired information and authorization services to ensure that only authorized users, such as 
customer managers, can access this information. In summary, these two classes work together to provide a secure and 
efficient way to view candidate information.

## 6. Integration/Demonstration

To execute this functionality, we need to run the scripts "build-all" and "run-bootstrap" (to load the actors responsible 
for registering a candidate, in this case, the operators), and finally run "run-backoffice" to execute the user interface. 
Next, we should log in with the credentials of a customer manager (e.g., customerManager1 - username - customerManagerA1 - 
password) and then select the "settings" option and choose the option that says "Display all personal data of a candidate."
After this, simply input the email of the candidate whose personal information we want to check, and these details will 
be printed.

## 7. Observations

Although the implementation of displaying all personal data for a candidate may not be deemed critical for the current 
sprint (b), it remains a valuable addition to our system. The functionality addresses the needs of the Customer Manager, 
offering insights into candidate profiles. By integrating established design patterns and maintaining open channels for 
continuous feedback, we ensure the development of a robust solution.
