# US 2000a - As Operator, I want to register a candidate and create a corresponding user (#17)

## 1. Context

### 1.1. Customer Specifications and Clarifications

* Question 17: Relativamente à secção 2.2.1, é na fase de Analysis que as entrevistas são avaliadas e é esse resultado
  que define o ranking dos candidatos? Além disso, para que serve o CV nesta fase? Visto que as entrevistas não são
  obrigatórias, o que acontece quando estas não se realizam?
  * Answer 17:  A pontuação das entrevistas é efetuada/calculada na fase das entrevistas. O CV e outros dados (como o
    resultado das entrevistas) é usado pelo Customer manager na fase de analise para ordenar os candidatos. Mas a ordenação
    é da responsabilidade do Customer Manager (por exemplo, não tem de seguir a ordem da pontuação nas entrevistas). A US
    1013 corresponde à ordenação manual dos candidatos feita pelo Customer Manager. O facto de não haver entrevistas não
    tem implicações na ordenação dos candidatos pois esta não depende explicitamente das entrevistas.

* Question 19: "Na criação de um utilizador no sistema o nome é definido pelo utilizador ou é o nome da pessoa
  (primeiro e último) e se a password é definida pelo utilizador ou gerada pelo sistema?"
  * Answer 19: "No âmbito da US 2000a o Operator cria utilizadores do sistema para candidatos que ainda não
    estejam no sistema. Tem de fazer isso com base nos dados recebidos na candidatura (que incluem email e nome).
    O email servirá para identificar a pessoa. Neste contexto é necessário ter uma password para esse novo utilizador.
    Uma vez que essa informação não é transmitida pelo candidato, suponho que a solução mais “aconselhada” será o
    sistema gerar uma password para esse utilizador. Como o utilizador/candidato irá receber essa informação
    (a forma de autenticação na app) está out of scope, no sentido em que não existe nenhuma US que remete para isso.
    As US 1000 e 1001 também remetem para criação de utilizadores. Aqui, eventualmente poderia-se pensar em introduzir
    manualmente as passwords, mas pode ser pelo mesmo mecanismo de definição automática de password, descrito
    anteriormente. Relativamente ao nome ver novamente a Q11."

* Question 23: A mudança de estado é referente ao candidato ou à candidatura individual e como se
  relaciona com o enable/disable dos utilizadores?
  * Answer 23: O enable/disable dos users é apenas para controlar os acessos ao sistema. O estado,
    no processo de candidatura, é o estado da candidatura de um candidato a um job opening, não está diretamente
    relacionado com o enable/disable dos users.

* Question 32: "Os candidatos também têm estados associados? À medida
  que o processo avança, o estado do candidato também é atualizado?"
  * Answer 32: "O estado é da candidatura. O avanço no processo pode não levar a “avanço” numa
    candidatura pois, por exemplo, no final do screening a candidatura pode ser rejeitada e,
    nesse caso, essa candidatura termina ai. Outras candidatura seguem o processo."

* Question 33: O candidato tem um código identificativo ou é o email que o identifica?
  * Answer 33: A identificação do candidato é por email. Não haverá necessidade de um código.

* Question 54: Regarding the US2000a requirement which states "As an Operator,
  I want to register a candidate and create a corresponding user," I would like to know how a candidate
  will be registered in the system, i.e., understand the processes for registering a candidate. Since the candidate
  has their name, email, and phone number, how should their username be formatted to avoid conflicts with other
  candidates' names? Additionally, how should the candidate be notified of their username and password?
  * Answer 54: There is no need for a user name (See Q11). Regarding the password, I think the system can
    generate a unique password. You may assume the candidate will be informed of his/her password by means that
    are outside of the scope of what is to be developed for this version of the system.

* Question 57: Quais às politicas de negócio para registar um candidato, quais as caracteristicas da password,
  email, telemóvel?
  * Answer 57: Sobre o telemóvel, seguir o Q56. Sobre email, seria qualquer email válido. Sobre a password,
    podemos seguir algo como: ter no mínimo 8 caracteres, letras maiúsculas e minúsculas, dígitos e pelo menos,
    um caracter não alfanumérico.

* Question 74: US2000a – Relativamente ao registo dos candidatos, os dados devem ser inseridos manualmente
  ou importados do ficheiro com os dados do candidato?
  * Answer 74: Faz sentido que sejam importados do ficheiro, no âmbito da US2002. Eventualmente dar a
    possibilidade do utilizador fazer alterações, caso seja necessário. A US2000a refere-se a uma funcionalidade
    do Operador, manualmente, registar candidatos. (Nota: resposta actualizada em 2024/04/18, a negrito)

* Question 78: US2000a - The operator can register a candidate: does he put the info manually or has to be read
  of the file generated by the bot? This user will appear then in the backoffice...enable as default I think.
  Then the admin, can also register manually a candidate as the operator did it? I don't understand at all the
  different between a registration of the candidate made by the admin or made by the operator.
  * Answer 78: See Q74. US2000a is for the Operator to manually register a candidate and his/her user in the
    system. US2002 is for import of the applications from the data iin the files produced by the application file
    bot. If the candidate does not exist, it should be created. I think there is no registration of a conadidate
    by the admin.

* Question 106: US2000a - I was thinking about if the candidate could change his/her email. In older questions you said
  the email was the identificator of the candidate, isn't it? Should we put another id made by sequence numbers or by his
  NIF, for example, to identificate him/her in the system? Could we say the same for the user who is managing the app of
  the customer?
  * Answer 106: The field/data that identifies the user in the system is always the email (it must be unique). For the
    moment there is no need for supporting the possibility of changing the email or add any other identification possibility.

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

* It involves a new feature request to enable Operators to register candidates and create corresponding user profiles.
* This task has not been assigned or completed in previous sprints; it's a new addition to enhance the functionality of the system.
  There are no bugs related to this task; it's a new feature implementation.

## 2. Requirements

**US 2000a** As Operator, I want to register a candidate and create a corresponding user.

#### Use Cases:

* This user story will encompass use cases 1000.1 and 2000a according to the data present in the specifications document
  ([Specifications_Document.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Document.md))).

#### Functionality:

* The task aims to enable Operators to register candidates and create corresponding user profiles.

#### Understanding:

* Operators, as part of their responsibilities, need the capability to directly register candidates into the system. This includes
  creating user profiles for these candidates, which will likely involve collecting and storing candidate information such as name,
  email and phone number. These profiles will serve as the basis for managing candidate applications and their progression through
  the recruitment process.

#### Dependencies:

* No direct dependencies identified. However, the task might relate to the overall system architecture and user management
  functionalities defined in previous user stories.

#### Acceptance Criteria:

- AC 2000a.1: Upon registration, the system should create a corresponding user profile for the candidate.
- AC 2000a.2: The system should automatically generate a unique password for the new user (candidate). The generated password should
  follow defined security policies, such as having a minimum of 8 characters, including both uppercase and lowercase letters,
  digits, and at least one non-alphanumeric character. (Question 54)
- AC 2000a.3: The system should perform appropriate validations on the data provided during candidate registration. This
  includes checking if mandatory fields are filled and if data formats (such as email address and phone number) are valid.

#### Input and Output Data

*Input Data:*

* Typed data:
  * Name of the candidate;
  * Email of the candidate;
  * Phone Number of the candidate.

*Output Data:*
* (In)Success of the operation

## 3. Analysis

* Use case 2000a: Our domain model satisfies the requirements of the aforementioned use cases, as when creating a
  candidate, we will instantiate the candidate aggregate, thus interacting solely with that aggregate.
* Use case 1000.1: The creation of a new user is out of scope for the project's domain. Therefore, this aspect is not
  represented in the domain model.
* See the domain model in: [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)

## 4. Design

### 4.1. Realization (Sequence Diagram)

![Sequence_Diagram_US2000a-_size_20_Sequence_Diagram_US_2000a__size_.svg](svg%2FSequence_Diagram_US2000a-_size_20_Sequence_Diagram_US_2000a__size_.svg)

**UC 1000.1**

![Sequence_Diagram_Register_User_UC1000.1.svg](..%2F..%2FGeneral%20Documentation%2FGenerics%20Diagrams%2Fsvg%2FSequence_Diagram_Register_User_UC1000.1.svg)

### 4.2. Class Diagram

For UC 2000a, the decision to omit a separate class diagram from the documentation is based on the principles of Domain-Driven
Design (DDD). Duplicating class information from the domain model would introduce redundancy. By directly utilizing the
domain model, clarity and efficiency are maintained in the documentation process while ensuring alignment with the project's
evolving domain understanding. [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)

Regarding UC 1001.1, it is advisable to refer to the class diagram specific to that use case
[classdiagram_registeruser_uc1000.1.puml](..%2F..%2FGeneral%20Documentation%2FGenerics%20Diagrams%2Fclassdiagram_registeruser_uc1000.1.puml)

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


### 4.4. Tests

**Test 1:** Verifies that it is not possible to insert numbers in the fist and last name. (AC 2000a.3)

````
@Test
public void withNameInvalidInput() {
  CandidateBuilder builder = new CandidateBuilder();
  assertThrows(IllegalArgumentException.class, () -> builder.withName("John123", "Doe")); // Check if it throws exception for invalid first name
  assertThrows(IllegalArgumentException.class, () -> builder.withName("John", "Doe123")); // Check if it throws exception for invalid last name
}
````
**Test 2:** Verifies that it is not possible to insert letters in the phone number, and it must contain 9 digits. (AC 2000a.3)

````
@Test
public void withPhoneNumberInvalidInput() {
  CandidateBuilder builder = new CandidateBuilder();
  assertThrows(IllegalArgumentException.class, () -> builder.withPhoneNumber("12345678")); // Check if it throws exception for invalid phone number
  }
````

**Test 3:** Verifies that only email inserts in the correct format (e.g., example@example.com) are accepted. (AC 2000a.3)

````
@Test
public void withEmailInvalidInput() {
  CandidateBuilder builder = new CandidateBuilder();
  assertThrows(IllegalArgumentException.class, () -> builder.withEmail("john@example")); // Check if it throws exception for invalid email
  }
````

**Test 4:** Verifies that an instance of Candidate was effectively created with the correct values entered. (AC 2000a.1)

````
    @Test
    void build() {
        String firstName = "John";
        String lastName = "Doe";
        String email = "john@example.com";
        String phoneNumber = "123456789";

        CandidateBuilder builder = new CandidateBuilder();
        Candidate candidate = builder.withName(firstName, lastName)
                .withEmail(email)
                .withPhoneNumber(phoneNumber)
                .build();

        assertEquals(firstName, candidate.getFirstName()); // Check if first name is set correctly
        assertEquals(lastName, candidate.getLastName()); // Check if last name is set correctly
        assertEquals(email, candidate.getEmail()); // Check if email is set correctly
        assertEquals(phoneNumber, candidate.getPhoneNumber()); // Check if phone number is set correctly
    }
````

## 5. Implementation

In order to immediately test if a candidate has been successfully registered, we created a method that fills a file.txt
with the entered email and the password generated by the Password Generator class. This allows us to check if we can log
in with these credentials. If these credentials are accepted during login, then the candidate was created successfully.

### Main classes created

1. `Candidate`: Represents a candidate and stores information such as name, last name, email, and phone number.

2. `CandidateBuilder`: Facilitates the creation of instances of the Candidate class, validating the provided data
   during construction.

3. `PasswordGenerator`: Generates random passwords with strong security, ensuring the inclusion of at least one uppercase
   letter, one digit, and one non-alphanumeric character.

4. `CandidateRepository`: Interface that defines methods for persistence operations related to candidates, such as
   saving and finding candidates by email.

5. `AddCandidateController`: Coordinates the business logic for adding a new candidate, utilizing the CandidateBuilder
   and the CandidateRepository.

6. `AddCandidateUI`: User interface responsible for interaction to add a new candidate, invoking the AddCandidateController
   for processing.


## 6. Integration/Demonstration

This functionality will be crucial for the problem domain as the candidate will be one of the main users of this application.
They will be responsible for submitting applications for a specific job opening (e.g., US 2002).

To execute this functionality, we need to run the script `build-all`, `run-bootstrap` (to load the actors responsible for
registering a candidate, in this case, the operators), and finally run-backoffice` to execute the user interface. Next,
we should log in with the credentials of an operator, for example, operator1 (username) and operatorA1 (password), and
choose the "settings" option, then select the first option (register a candidate). Finally, we just have to fill in the
various fields that will be requested, and a success message will be displayed.


## 7. Observations

We conclude that implementing the candidate registration and user profile creation functionality is crucial for system
efficiency. Integrating design patterns and continuous feedback ensured a robust, adaptable solution, aiming to enhance
the operator experience and ensure data security.
