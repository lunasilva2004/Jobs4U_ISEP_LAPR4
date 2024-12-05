# US 1000 - As Administrator, I want to be able to register, disable/enable, and list users of the backoffce.

## 1. Context
### 1.1. User Story Description

As Administrator, I want to be able to register, disable/enable, and list users of the backoffce.

### 1.2. Customer Specifications and Clarifications


* Question: "Na criação de um utilizador no sistema o nome é definido pelo
  utilizador ou é o nome da pessoa (primeiro e último) e se a password é
  definida pelo utilizador ou gerada pelo sistema?"
    * Answer: "No âmbito da US 2000a o Operator cria utilizadores do sistema para candidatos que
      ainda não estejam no sistema. Tem de fazer isso com base nos dados recebidos na
      candidatura (que incluem email e nome). O email servirá para identificar a pessoa. Neste
      contexto é necessário ter uma password para esse novo utilizador. Uma vez que essa
      informação não é transmitida pelo candidato, suponho que a solução mais “aconselhada”
      será o sistema gerar uma password para esse utilizador. Como o utilizador/candidato irá
      receber essa informação (a forma de autenticação na app) está out of scope, no sentido
      em que não existe nenhuma US que remete para isso. As US 1000 e 1001 também
      remetem para criação de utilizadores. Aqui, eventualmente poderia-se pensar em
      introduzir manualmente as passwords, mas pode ser pelo mesmo mecanismo de
      definição automática de password, descrito anteriormente. Relativamente ao nome ver
      novamente a Q11."

* Question: Multiple enable/disable (US1000) – Can a user (from the backoffice, for example) be enabled/disabled multiple times
    * Answer: Yes.

* Question: No enunciado não está explicita a informação a recolher para os Customers? Qual a informação necessária? E quando aos funcionários da empresa?
    * Answer: De facto isso não está explicito. No entanto, são referidos no nome da empresa e o seu endereço no âmbito de um job opening. Quanto aos utilizadores (representante da empresa que acede à Customer App) eu diria que serão dados similares ao do Candidate. Quando aos funcionários da empresa, eu diria que é importante garantir que é usado o email para identificar qualquer utilizador do sistema. Penso que será importante para cada utilizador termos o nome completo assim como um short user name (que deverá ser único). Actualização em 2024-03-21: O Product Owner reconsiderou e decidiu que o short user name é dispensável uma vez que para autenticação dos utilizadores se deve usar apenas o email e a password.

* Question: A mudança de estado é referente ao candidato ou à candidatura individual e como se relaciona com o enable/disable dos utilizadores?
    * Answer: O enable/disable dos users é apenas para controlar os acessos ao sistema. O estado, no processo de candidatura, é o estado da candidatura de um candidato a um job opening, não está diretamente relacionado com o enable/disable dos users

* Question: Editar dados de utilizador – É possível alterar os dados de qualquer utilizador (Customer manager, Customer, Candidate), depois de este ter sido criado? Se sim, que dados são passiveis de ser alterados? Cada utilizador que é criado, tem como estado "activo" por defeito?
    * Answer: Não irei responder diretamente à questão. O product owner considera que devem usar as melhores práticas quando a esse assunto.

* Question: Em relação ao registro de utilizadores, todos estes devem ser considerados por padrão "enable" ou deve haver a opção de "enable/disable" os utilizadores durante o processo de registro?
    * Answer: No contexto da US1000 deve ser possível ativar e desativar utilizadores. Suponho que por omissão devem estar ativos.


## 2. Requirements

**US 1000** : As Administrator, I want to be able to register, disable/enable, and list users of the backoffce.

#### Use Cases:

* This User Story will encompass the following use cases:
    * UC 1000.1: Register User
    * UC 1000.2: Disable User
    * UC 1000.3: Enable User
    * UC 1000.4: List Users
  
According to the data present in the specifications document, [Specifications_Doocument.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Doocument.md).

#### Functionality:

* The task aims to enable the Admin to register,activate/deactivate and list users.

#### Understandability:

* Admins, as part of their responsibilities, need the capability to directly register, activate/deactivate and list users in the system. This includes creating a user, which is a necessary step for the user to access the system, 
 as well as collecting and storing user information into the system to list, disable and enable users.

#### Dependencies:

* No direct dependencies identified. However, the task might relate to the overall system architecture and user management
  functionalities defined in previous user stories.

#### Acceptance Criteria:

- AC 1000.1: Users might be identified by their email
- AC 1000.2 e 1000.3: Users can be activated and deactivated multiple times


#### Input and Output Data

*Input Data:*

* Typed Data:
 * Password of the User;
 * First Name of the User;
 * Last Name of the User
 * Email of the User;
 

*Output Data:*
* (In)Success of the operation


## 3. Analysis

*  The register of a new user, listing, activation and deactivation is out of scope for the project's domain. Therefore, this aspect is not
  represented in the domain model.

## 4. Design

### 4.1. Realization

#### Sequence Diagrams

**UC 1000.1**

![Sequence_Diagram_Register_User_UC1000.1.svg](..%2F..%2FGeneral%20Documentation%2FGenerics%20Diagrams%2Fsvg%2FSequence_Diagram_Register_User_UC1000.1.svg)

**UC 1000.2**

![Sequence_Diagram_Deactivate_UC1000.2.svg](..%2F..%2FGeneral%20Documentation%2FGenerics%20Diagrams%2Fsvg%2FSequence_Diagram_Deactivate_UC1000.2.svg)

**UC 1000.3**


![Sequence_Diagram_Activate_UC1000.3.svg](..%2F..%2FGeneral%20Documentation%2FGenerics%20Diagrams%2Fsvg%2FSequence_Diagram_Activate_UC1000.3.svg)

**UC 1000.4**

![Sequence_Diagram_List_User_UC1000.4.svg](..%2F..%2FGeneral%20Documentation%2FGenerics%20Diagrams%2Fsvg%2FSequence_Diagram_List_User_UC1000.4.svg)

#### Class Diagram

![Class_Diagram_1000.svg](svg%2FClass_Diagram_1000.svg)

### 4.2. Tests

Unit tests were deemed unnecessary as domain concepts had been thoroughly tested. Current operations involve manipulation
of existing domain instances, minimizing the need for additional testing.

### 4.3. Applied Patterns

#### Builder Pattern

We use the Builder pattern for creating a candidate because:

1. The Builder pattern allows us to separate the construction logic of a complex object from its representation. This
   means that the CandidateBuilder class is responsible for building a Candidate object.
2. With the Candidate Builder, we can define clear and concise methods for configuring Candidate attributes such as name,
   email, and phone number. This makes building the Candidate more readable and easier to understand.
3. The Candidate Builder can include validation logic to ensure that the data provided to create a Candidate is valid.
   For example, we can check if the provided email has a valid format or if the phone number contains only digits.
4. If the logic for creating a Candidate becomes more complex in the future, we can handle that complexity within the
   Candidate Builder while keeping the interface simple for its users.

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

#### DAO (Data Access Object) Pattern

The DAO (Data Access Object) pattern is used to encapsulate data access, providing an abstract interface to interact with
the database or any other data source. In our implementation, the DAO pattern can be identified in the CandidateRepository class.

1. The DAO pattern encapsulates data access operations such as saving, updating, retrieving, and deleting records. This
   allows database operations to be centralized in a single class, facilitating maintenance and reducing code duplication.
2. The DAO provides an abstract interface to interact with the data source, allowing the rest of the application to be
   independent of the specific database implementation.

#### Repository Pattern

We utilize the Repository pattern for managing candidate data because:

1. The pattern abstracts away the complexities of database interactions, allowing us to focus on business logic without
   directly dealing with database specifics.
2. The CandidateRepository interface provides a standardized way to perform Create, Read, Update and Delete operations on
   candidate entities. This uniform interface simplifies data access throughout the application.
3. Implementations like CandidateJpaRepository and InMemoryCandidateRepository handle specific data store interactions.

## 5. Implementation

### Main classes created

1. **ActivateUserController**: Coordinates the business logic for activating a new user, utilizing the UserRepository.

2. **ActivateUserUI**: User interface responsible for interaction to activate an user, invoking the ActivateUserController
   for processing.


## 6. Integration/Demonstration

This functionality will be crucial to firstly register users on the backoffice,to know all users,deactivate and activate them.

To execute this functionality, we need to run the script build-all, run-bootstrap (to load the actors responsible for
registering, activate/deactivate and list a user in this case, the admin), and finally run-backoffice to execute the user interface. Next,
we should log in with the credentials of an admin for example, admin1 (username) and adminA1 (password), and
choose the "settings" option, then the admin has the choice to select the first option (Add user) where there will be asked for the admin to introduce
the username,the first and last name, the passwod and email,then select the second option (List all users) where there will be listed a list of all users
,then select the third option (Deactivate a user) where there will be listed all users active and an option to chose to deactivate one of them
and finally the fourth option(Activate a user) where there will be listed all users disabled and an option to chose to activate one of them . 


## 7. Observations

We conclude that implementing the registration,listing, deactivation and activation users functionalities is crucial for system
efficiency. Integrating design patterns and continuous feedback ensured a robust, adaptable solution, aiming to enhance
the customer manager experience and ensure data security.