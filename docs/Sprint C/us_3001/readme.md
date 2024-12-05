# US 3001 - As Candidate, I want to be notified in my application when the state of one of my applications changes. (#46)

## 1. Context
### 1.1. Customer Specifications and Clarifications

* Question 174: US3001 - Na US 3001 pretende que o candidato seja notificado na sua aplicação quando o estado de uma aplicação
mudar. De que forma pretende que o candidato seja notificado? E caso o candidato não esteja a correr a aplicação, essa notificação 
é perdida?
  * Answer 174: O candidato deve ser notificado quando a sua “app” está em execução. Relativamente a notificações que “acontecem” 
  quando não está a correr a aplicação, seria interessante que as recebesse da próxima vez que executasse a aplicação.

* Question 175: US3001 - Questão âmbito notificações - O candidato será notificado, quando a sua candidatura mudar de estado. 
O que se entende por notificado, é receber um email, quando entra na aplicação tem uma fila de 'inbox' ? Quando a aplicação 
está ligada recebo email? É o candidato que faz o pedido(cliente) (Pop) inicia assim a comunicação, e recebe a resposta/notificação
(servidor). E como encaixo o cenário de notificação(push)?
  * Answer 175: Ver Q174. Neste caso as notificações são na aplicação do candidato, não são por email.

* Question 189: US3001 – Application State – I'd like some clarifications regarding the state that US3001 mentions. Is it 
the "accepted/not accepted" state, or a state regarding the phases of the recruitment process of which the application is 
associated to?
  * Answer 189: This US is focused on the Candidate perspective. He/she may not be aware of the internal phases of the recruitment
  process. But he/she is interested in knowing the “external” state of his/her applications. For instance, as a candidate I would 
  like to know if my application was received. Then I would like to know if my application was accepted or not and, finally, if I 
  was selected or not.

* Question 229: US 3001 - Segundo a nossa perspetiva sobre esta funcionalidade, achámos melhor o utilizador ter na sua aplicação 
uma espécie de inbox de notificações. Quando o utilizador está na funcionalidade das notificações este recebe as notificações 
que tinha e que não foram enviadas porque não estava na aplicação e depois fica á espera de novas notificações que apareçam 
entretanto, até o utilizador pedir para sair da funcionalidade. Esta abordagem está alinhada com suas expectativas?
  * Answer 229: Pode ser. Mas não seria possível receber as notificação mesmo não estando nessa “opção de menu”? Sendo uma aplicação 
  “console” limita um pouco a UI, mas não seria possível receber as notificações desde que tenha a aplicação em execução mas só 
  mostrar essas notificações quando o utilizador seleciona a opção? Em termos de UI a diferença é mínima, em termos de implementação 
  pode ser significativa. Talvez esta seja até mais uma questão para RCOMP.

* Question 233: US 3001 – Notifications - Em questões anteriores sobre esta funcionalidade menciona que como candidate gostaria 
de saber se a sua candidatura foi recebida, aceite e escolhida. Pedimos que descreva a que se refere quando diz que uma candidatura 
foi aceite, e quando foi escolhida.
  * Answer 233: É aceite se passa o processo de verificação de requisitos. É escolhida se após o ranking está dentro dos 
  lugares das vagas para o job opening.


## 1.2. Explanation

The purpose of User Story (US 3001) is to enable Candidates to receive notifications within their application when the status 
of any of their job applications changes. By implementing this functionality, Candidates can conveniently monitor and view 
updates regarding the status of their applications.

## 2. Requirements

*US 3001* As Candidate, I want to be notified in my application when the state of one of my applications changes.

#### Use Cases:

* This user story corresponds to the use case 3001 outlined in the Specifications Document.
  ([Specifications_Document.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Document.md)).

#### Functionality:

* This task involves providing a functionality for Candidates to receive notifications within their application when the 
* status of any of their job applications changes. The system should present a user-friendly interface for Candidates to 
* access these notifications, displaying essential details such as the updated status for each job application.

#### Understanding:

* The candidate will have the ability to receive notifications within their application when the status of any of their 
* job applications changes. This feature enhances the user experience by providing easy access to important updates 
* regarding the status of each job application.

#### Dependencies:

1. **US 1002 - As a Customer Manager, I want to register a job opening.**
- This user story is related to the number of applicants as this count is determined by navigating through the job application 
  to the job opening and tallying the number of job applications that the job opening has received.

2. **US 1015 - As a Customer Manager, I want to execute the process of verification of requirements of applications for a job opening.**
- This user story is related to the state of the application because the application's state changes when the process of verification 
  of requirements is executed. Depending on the outcome of this process, the state of the application will change to either 
  `CONFIRMED` or `REJECTED`.

3. **US 2000a - As an Operator, I want to register a candidate and create a corresponding user.**
- This user story is essential for having candidates registered in the system, which is crucial for notifying them when 
  the state of one of their applications changes.

4. **US 2004 - As Operator, I want to upload a text file with the data fields (requirements) of a candidate for its verification.**
- This user story is related because it allows the operator to upload the data fields of a candidate for verification. This 
  verification is crucial for changing the state of the application.
- 
#### Acceptance Criteria:

AC 3001.1: The system should identify the logged-in candidate by their email and generate a list of notifications corresponding 
to the changes in the status of their applications.

AC 3001.2: The system should present these notifications in a user-friendly interface, clearly displaying the updated status 
of each job application.

AC 3001.3: This functionality should be implemented using a server. The server, connected to the database, should display 
all notifications triggered by changes in the status of applications. The client, represented by the CandidateApp, should 
be able to view the list of notifications for the logged-in candidate.

#### Input and Output Data

* Input:
  * Not applicable
* Output:
  * The list of notifications, if available, for the logged-in candidate.

## 3. Analysis

* Use case 3001: Our Domain Model fulfills the requirements of the specified use case, ensuring that candidates can effectively 
view their notifications. To accomplish this, we interact with the Candidate Aggregate and the JobApplicationsAggregate to 
compile a list of all notifications associated with changes in the state of a candidate's job applications.

* See the domain model in: [domain_model_v10.puml](..%2F..%2FGeneralDocumentation%2FDomain%20Model%2Fdomain_model_v10.puml)


## 4. Design

### 4.1. Realization (Sequence Diagram)

We opted to create 5 diagrams to separate the different steps made.

#### 4.1.1. CandidateApp

#### 4.1.1.1. Sequence Diagram - Process

![Process_Diagram_US3001.svg](svg%2FProcess_Diagram_US3001.svg)

##### 4.1.1.2. Sequence Diagram - Connection

![Connection_CandidateApp_Sequence_Diagram.svg](svg%2FConnection_CandidateApp_Sequence_Diagram.svg)

##### 4.1.1.3. Sequence Diagram - Login

![Login_CandidateApp_Sequence_Diagram.svg](svg%2FLogin_CandidateApp_Sequence_Diagram.svg)

##### 4.1.1.4. Sequence Diagram - List Job Applications

![ReceiveApplication_CandidateApp_Diagram.svg](svg%2FReceiveApplication_CandidateApp_Diagram.svg)

#### 4.1.2. FollowUpServer

![FollowUpServer_Diagram.svg](svg%2FFollowUpServer_Diagram.svg)

### 4.2. Class Diagram

To see how the Class Diagram for this User Story would look, you simply need to look at the Domain Model and see the Candidate
aggregate, with its associations, particularly with the JobApplication entity (where job applications are stored) and the
JobOpening entity. This direct integration with the domain model ensures coherence and consistency in depicting the system's
structure and behavior.
But because we have to deal with a server, we need to create a class diagram for the server side of the application.

![Server_Class_Diagram.svg](svg%2FServer_Class_Diagram.svg)

### 4.3. Applied Patterns

**Service Layer:** The Service Layer pattern is utilized in the ListNotificationJobApplicationService class, which is tasked 
with listing notifications related to changes in the state of a candidate's job applications. This class interacts with the 
JobApplicationRepository to retrieve job applications. This pattern encapsulates business logic and transactions, offering 
a simplified interface to the client. It encourages loose coupling between the presentation and data access layers, enhancing 
the system's maintainability and flexibility.

**Repository Pattern:** The Repository Pattern is implemented in the JobApplicationRepository class, which is responsible 
for accessing job application data. This class interacts with the database to manage the retrieval of job applications. 
This pattern separates the application logic from the data access layer, providing a collection-like interface for accessing 
domain objects, thereby making data access more manageable and organized.

**Aggregate Pattern:** The Aggregate Pattern is applied to the Candidate and JobApplication classes, where a Candidate 
aggregate contains multiple JobApplications. This pattern ensures the consistency of changes to objects within the aggregate. 
An Aggregate is a cluster of domain objects that can be treated as a single unit for data changes.

**SOLID Principles:** The SOLID principles are applied throughout the design of the classes, ensuring the code is well-structured 
and maintainable.

**Single Responsibility Principle (SRP):** Each class has a single responsibility. For instance, the ListNotificationJobApplicationService 
is solely responsible for listing notifications.

**Open-Closed Principle (OCP):** Classes are open for extension but closed for modification. New functionality can be added without 
altering existing code. For example, new methods can be added to ListNotificationJobApplicationService without changing its existing
methods.

**Liskov Substitution Principle (LSP):** Subtypes are substitutable for their base types. For instance, the JobApplicationRepository 
interface is implemented by a concrete class, allowing any implementation to be swapped without affecting behavior.

**Interface Segregation Principle (ISP):** Clients are not forced to depend on interfaces they do not use. Interfaces are client-specific 
rather than general-purpose. For instance, the JobApplicationRepository interface provides methods related to job applications, which are 
used by ListNotificationJobApplicationService.

**Dependency Inversion Principle (DIP):** High-level modules do not depend on low-level modules; both depend on abstractions. High-level 
classes like ListNotificationJobApplicationService depend on abstractions such as JobApplicationRepository, not on concrete classes.

### 4.2. Tests

Unit tests were deemed unnecessary as domain concepts had been thoroughly tested. Current operations involve manipulation
of existing domain instances, minimizing the need for additional testing.

## 5. Implementation

### Main classes created

#### Main Classes
1. **CandidateApp**: This is the primary entry point for the candidate console application. It establishes a connection to the server, initializes communication via the `CommunicationController`, and displays the `FrontMenu`. It manages server connection responses and sets up the authorization service.
2. **RcompServer**: This is the main class for starting and stopping the server. It initializes the server, sets up the authentication registry, and manages the server's lifecycle, including waiting for user input to stop the server.

#### Controllers
1. **CommunicationsController**: This class serves as a controller for managing server communication. It uses the `CommunicationService` singleton to initialize communication, test the connection, handle login, disconnect, and list job openings, applications, and notify in the application when the state of an application changes.
2. **ListNotificationJobApplicationController**: This class, annotated with `@UseCaseController`, acts as a controller for listing notifications for a candidate when the state of one of their applications changes. It uses `AuthorizationService` to ensure that the user is authorized before proceeding. It then retrieves the email of the authenticated user and uses `ListNotificationJobApplicationService` to get the list of notifications.
3. **LoginController**: This is an interface that defines a contract for finding a username based on an email address. It includes one method, `findUsernameByEmail`.

#### Implementations
1. **LoginControllerImpl**: This class implements the `LoginController` interface. It uses a `UserRepository` to search for users based on their email and return the corresponding username. The repository is initialized with settings from the application configuration.

#### Handlers
1. **Handler**: This abstract class represents a generic handler for processing client requests. It manages the input and output streams and includes an abstract method `handle` for handling specific requests. The class also ensures the server's critical section is managed correctly using a semaphore.
2. **SimpleHandler**: Extending the `Handler` class, this class implements the specific logic for handling various client requests, such as authentication, listing job applications, and job openings. It interacts with repositories to fetch data and uses the `Translator` class to encode and decode messages.

#### Services
1. **CommunicationsService**: This singleton class manages communication with the server. It initializes the communication channel, handles login requests, tests the connection, and provides methods to fetch job openings and applications for specific customers and candidates. It uses the `Messenger` and `Translator` classes for sending and receiving messages.
2. **ListNotificationJobApplicationService**: This is a service class annotated with `@Service`, indicating that it is a Spring-managed bean. It provides functionality to list the notifications for a specific candidate based on their email. The service uses the `JobApplicationRepository` to fetch job applications and the `JobOpeningRepository` to fetch job openings. It then processes the data to generate a list of notifications for the candidate.

#### Actions
1. **DisconnectAction**: This class implements the `Action` interface and handles the disconnection process. It uses the `CommunicationsController` to disconnect from the server and checks the response code to determine if the disconnection was successful, handling ACK and ERR responses appropriately.
2. **NotificationsAction**: This class implements the `Action` interface and is responsible for displaying the `NotificationsUI`. The `execute` method returns the result of the `show` method from `NotificationsUI`.
3. **ServerLoginAction**: This class implements the `Action` interface and handles the server login process. It prompts the user to log in, allowing up to three attempts. If the login is successful, it launches the `MainMenu` and enters the main loop. If the login fails after three attempts, it calls `DisconnectAction` to disconnect from the server.

#### User Interfaces
1. **FrontMenu**: This class extends `AbstractUI` and represents the front menu of the application. It allows users to either log in or exit the application. The menu uses a vertical layout with `VerticalMenuRenderer`.
2. **MainMenu**: This class extends `AbstractUI` and represents the main menu of the application. It includes options for accessing user-related actions and server actions to list notifications. It uses a vertical layout to render the menu.
3. **NotificationsUI**: This class extends `AbstractUI` and provides the user interface to list all the notifications for a candidate.
4. **ServerLoginUI**: This class extends `AbstractUI` and provides the user interface for server login. It prompts the user for their email and password and uses the `CommunicationsController` to attempt a login. It displays appropriate messages based on whether the login was successful or failed.

#### Server Management
1. **SemaphoreForServer**: This singleton class manages concurrent connections to the server using a semaphore. It initializes the semaphore with a maximum number of permits based on a system property and provides methods to activate and deactivate critical sections, as well as retrieve the number of available and maximum permits.
2. **Server**: This class manages the server socket and handles incoming connections. It maintains the server's running state and uses the `SemaphoreForServer` to limit the number of concurrent connections. When a connection is accepted, it creates a new `SimpleHandler` to process the client's requests.

#### Communication
1. **MessageCode**: This enum defines various message codes used for communication between the server and clients. It includes codes for testing the connection, disconnecting, acknowledgments, errors, authentication, listing job applications and job openings, and showing job applications and job openings.
2. **Messenger**: This class handles sending and receiving messages through a socket. It initializes object input and output streams for the given socket and provides methods to send and receive byte array messages.
3. **Translator**: This class provides methods to encode and decode messages for server communication. It includes methods for encoding messages with version, code, and data, and methods for decoding each component from an encoded message. Additionally, it has methods to serialize and deserialize lists of job openings, job applications, and job applications notifications.

## 6. Integration/Demonstration

For running this US we need to run the class 'RcompServer' to initialize the server and then the class 'CandidateApp' to run
the candidate "side" of the server. Beyond this, we need to insert the login credentials of a previously registered candidate
in the system, then we will be able to see the candidate list of notifications.

## 7. Observations 

For this US we are using a Socket connection to communicate between the server and the client. The server is running in the
port 2004 and the client is running in the port 2004. The server is running in the localhost and the client is running in
the localhost. The server is running in the same machine as the client.
