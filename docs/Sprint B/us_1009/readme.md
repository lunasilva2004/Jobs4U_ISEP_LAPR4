# US 1009 - As Customer Manager, I want to select the Requirements Specification to be used for a Job Opening. #26

## 1. Context

### 1.1. Customer Specifications and Clarifications

* Question 41: "Como é que o Language Engineer faz o interview model e os job
  requirements? É texto? Ou ele seleciona perguntas para a interview e
  requirements para a job opening? E isso é quando se está a criar uma
  entrevista ou uma job opening ou para-se a meio para fazer isso e depois
  continua se?"
  * Answer 41: "O language enginner com informação passada pelo customer manager (que obteve
    do customer) vai desenvolver em java um jar correspondente ao modulo/plugin. Para esse
    desenvolvimento terá de utilizar técnicas de desenvolvimento de gramáticas/linguagens
    como o antlr. Esse código ficará num jar que depois o language engineer “instala/regista”
    na aplicação (US1008, por exemplo, associando um nome ao jar num ficheiro de
    configuração – “5 anos experiencia java”, “req-model-5-years-java.jar”). A aplicação com
    essa informação carrega dinamicamente esse jar. Na gramátca usada no jar é que vão
    estar espelhadas a estrutura das perguntas a usar nesse modelo e sua avaliação. Estas
    atividades têm de ser feitas antes de se poder fazer a US1008. Esse trabalho é feito “fora”
    dos sistema, apenas se registando o modelo (quando está pronto) na US1008. A US 1009 e
    US1011 permitem selecionar modelos a usar (dos que foram devidamente registados no
    sistema)."

* Question 70: US1009 – Acerca da User Story da seleção do Job Requirement Specification para 
o Job Opening, será que o Customer Manager poderá escolher um Job Opening que já tenha um 
Job Requirement Specification?
    * Answer 70 :  Admito que essa situação seja possível para qualquer user story similar. 
  Ou seja, a situação que descreve é equivalente a qualquer situação em que seja necessário fazer 
  uma seleção mas que o utilizador se tenha enganado e deseje optar por outra opção. Deve-se, no 
  entanto, garantir que o sistema se mantenha num estado consistente.

* Question 85: US1007/1009 – Depois de definir os estados de recrutamento para uma JobOpening, o 
Customer Manager poderá selecionar o Job Requirement Specification para esse mesmo Job Opening? 
Se sim, até que fase de recrutamento poderá executar a ação?
  * Answer 85: O Customer Manager define as fases do processo de recrutamento, não define os estados.
  A avaliação de requisitos é feita na fase de Screening. Assim, não percebo bem a questão colocada.

* Question 88: US1002 – Quando o Customer Manager regista uma job offer, é ele que cria as requirement specifications e
  as interview models ou é-lhe dada uma lista destes para ele selecionar?
  * Answer 88: Existe a US1002 e as US1009 e US1011. Penso que está claro qual a responsabilidade de cada uma. A
    criação dos modelos das entrevistas e dos requisitos é um caso de uso especifico e com um US especifica para registar
    no sistema os respectivos plugins (US1008).


* Question 91: [1002, 1007, 1009] - Validez de uma Job Openings – A nossa questão principal seria: quando é que uma job 
opening é considerada válida? Tendo em conta as funcionalidades 1002, 1007, 1009, surgiu-nos uma duvida relativamente 
às job openings e à sua constituiçao. Na US1002, é suposto resgistar uma job opening e apenas depois, na US1009, devemos 
selecionar os requirements specifications para a dada job opening. Posto isto, aquando o registo da job opening, esta não 
iria possuir toda a informaçao obrigatória como requerido. Assim sendo, deveria haver uma ligação direta entre estas user 
stories de forma a que, aquando o registo, passamos automaticamente a selecionar os requirements obtendo assim uma job opening 
válida? Adicionalmente, queremos esclarecer se o recruitment process é algo obrigatório para a validez de um job opening.
  * Answer 91: O product owner não é especialista do dominio da solução (apenas têm conhecimentos do problema) mas, 
quanto à primeira questão, sugere que talvez user stories não sejam (podem não ser) opções de menu “distintas”. Quanto à 
segunda questão (recruitment process) julgo que também está mais ligada à solução que ao problema, pelo que não vou sugerir 
nada que possa até complicar mais do que esclarecer

* Question 115: US1002, 1007, 1009 - Na US1002 ao registar um job opening é imperativo selecionar também o job requirement 
e/ou as fases de recrutamento?
  * Answer 115: São US diferentes e, do meu ponto de vista, podem ser executadas em momentos diferentes. Apenas lembro 
que, como é evidente, desejo que o sistema esteja sempre num estado consistente.

## 1.2. Explanation

* It involves a new feature request to allow Customer Managers to select the requirements specification to be used for 
a job opening.
* This task has not been assigned or completed in previous sprints; it's a new addition to enhance the functionality of 
the system. There are no bugs related to this task; it's a new feature implementation.

## 2. Requirements

**US 1009** As Customer Manager, I want to select the requirements specification to be used for a Job Opening.

#### Use Cases:

* This user story will encompass use cases 1009 according to the data present in the Specifications Document.
  ([Specifications_Document.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Document.md)).

#### Functionality:

* The task aims to enable Customer Managers to select the Requirements Specification to be used for a Job Opening, by 
selecting a requirement from a list of available requirements, and then associating it with the Job Opening.

#### Understanding:

* As part of their responsibilities, Customer Managers need the capability to choose the appropriate Requirements 
Specification for a given Job Opening. This will involve selecting from different sets of requirements available within 
the system, which may include skills, experience, educational level, among other criteria relevant to the position in 
question. This selection will be crucial to ensure that only the most suitable candidates are considered for the job and 
to guide the recruitment process effectively.

#### Dependencies:

1. **US 1002 - As Customer Manager, I want to register a Job Opening.**

This story depends on the existence of a Job Opening. Selecting the Requirement Specification for a Job Opening can only 
occur if the job is already registered in the system.

2. **US 1008 - As Language Engineer, I want to deploy and configure a plugin (i.e., Job Requirement Specification or 
Interview Model) to be used by the system.**

The presence of a configured plugin can directly influence the selection of Requirement Specifications for a Job Opening. 
If the Requirement Specification is a functionality enabled by the plugin, then story #1009 depends on its 
implementation.

#### Acceptance Criteria:

- AC 1009.1: When selecting a requirement plugin, it must be previously registered in the system by the Language Engineer. 
- AC 1009.2: When selecting the job opening, it should already be registered in the system by the Customer Manager. 
- AC 1009.3: The selected job opening should be associated with the chosen plugin, modifying the requirements 
specification parameter of that job opening.

#### Input and Output Data

*Input Data:*

* Insert Data:
  * Name of the Requirement Specification
  * Job Reference of the Job Opening

*Output Data:*
* (In)Success of the operation


## 3. Analysis

* Use case 1009.1: Our domain model satisfies the requirements of the aforementioned use case, as when selecting a requirements 
specification for a job opening, we will interact solely with the job opening aggregate and the plugin aggregate.
* See the domain model in: [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)

## 4. Design

### 4.1. Realization (Sequence Diagram)
![Sequence_Diagram_US1009-_size_20_Sequence_Diagram_US_1009__size_.svg](svg%2FSequence_Diagram_US1009-_size_20_Sequence_Diagram_US_1009__size_.svg)

### 4.2. Class Diagram

For UC 1009, the decision to omit a separate class diagram from the documentation is based on the principles of Domain-Driven
Design (DDD). Duplicating class information from the domain model would introduce redundancy. By directly utilizing the
domain model, clarity and efficiency are maintained in the documentation process while ensuring alignment with the project's
evolving domain understanding. [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)

### 4.3. Applied Patterns

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

### 4.4. Tests

Unit tests were deemed unnecessary as domain concepts had been thoroughly tested. Current operations involve manipulation 
of existing domain instances, minimizing the need for additional testing.

## 5. Implementation

### Main classes created 

* `SelectRequirementController`:  This class manages the process of associating requirement specifications with job 
openings. It provides methods to find specific requirements and job openings, and to associate a requirement with a job 
opening if both are found. It handles exceptions during the association process.

* `SelectRequirementUI`: User interface for selecting requirement specifications for job openings. Communicates with 
`SelectRequirementController` to manage associations.


## 6. Integration/Demonstration

This functionality is integral to the operational workflow, allowing Customer Managers to efficiently align job openings with specific requirements.

To execute this feature:

1. Execute the `build-all` and `run-bootstrap` scripts to initialize the system.
2. Launch `run-backoffice` and log in as an Language Engineer (e.g., Username: language1, Password: languageA1).
3. Access "4. Settings" and select "1. Deploy and configure a plugin (i.e., Job Requirement Specification or Interview Model) to be used by the system".
4. Select "2 - Register a Job Requirements Specification" and provide the necessary information.
5. Back out twice by pressing "0" twice.
6. Launch `run-backoffice` again and log in as a Customer Manager (e.g., Username: manager1, Password: managerA1).
7. Access "2. Settings" and select "2. Register a Job Opening". Fill in the required information.
8. Access "2. Settings" again and select "5. Select the Requirements Specification to be used for a Job Opening".
9. Provide the Job Opening Reference and Requirements Specification name.
10. A success message confirms the successful Requirements Specification selection for the Job Opening.

## 7. Observations 

N/A
