# US 3000 - As Candidate, I want to list all my applications and their state (including the number of applicants). (#45)

## 1. Context
### 1.1. Customer Specifications and Clarifications


* Question 176: US3000 - Na US3000 pede que, para alem de listar as aplicações e o estado das mesmas de um candidato, que 
liste o numero de candidatos. Este numero de candidatos é um somatório da quantidade de candidatos que fizeram uma aplicação 
para as mesmas Job Openings deste primeiro candidato (que esta a executar o caso de uso)?
  * Answer 176: Devem ser listadas todas as “applications” (candidaturas) do candidato, o estado delas, assim como o número 
  de candidaturas que cada job opening teve (assim o candidato tem uma noção da “concorrência” que teve para cada uma das suas 
  candidaturas).

## 1.2. Explanation

The purpose of this user story (US 3000) is to enable Candidates to view a list of all their applications. This list should
include key details such as number of applicants. By implementing this functionality, Candidate can easily access and manage 
their applications within the system.

## 2. Requirements

*US 3000* As Candidate, I want to list all my applications and their state (including the number of applicants).

#### Use Cases:

* This user story corresponds to the use case 3000 outlined in the Specifications Document.
  ([Specifications_Document.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Document.md)).

#### Functionality:

* This task involves providing a functionality for Candidates to list all their applications. The system should present a
  user-friendly interface for Candidates to access this list, displaying essential details such number of applicants for each job application.

#### Understanding:

* Candidate will have the ability to view a comprehensive list of their job applications, facilitating better management and
  oversight of their applications. This feature enhances the user experience by providing easy access to important
  information about each job application.

#### Dependencies:

1. **US 1002 - As a Customer Manager, I want to register a job opening.**
- This US is related to the number of applicants because this number is determined by navigating through the job application
  to the job opening and counting how many job applications that job opening has.

2. **US 1005 - As a Customer Manager, I want to list all applications for a job opening.**
- This US is necessary because it provides the ability to view all applications for a specific job opening, which is part of
  listing a candidate's applications and their states.

3. **US 2000a - As an Operator, I want to register a candidate and create a corresponding user.**
  - This US is necessary to have candidates registered in the system, which is crucial for listing their respective applications.

4. **US 2002 - As an Operator, I want to register an application of a candidate for a job opening and import all files received.**
  - US 3000 directly depends on this US as listing applications is an essential part of listing all applications for a candidate.

#### Acceptance Criteria:

AC 3000.1: The system should retrieve the email of the candidate who is logged in and list all job applications for that candidate.

AC 3000.2: The system should display the number of applicants for each job application.

AC 3000.3: The system, to display the number of applicants, should "count" the number of applications for the specific job opening
associated to the job application in question.

AC 3002.4: This functionality should be implemented using a server. The server will have a connection to the database to catch the list
of job applications for a specific candidate. The client will be displayed in the CandidateApp and will be able to see the list of job applications
for the candidate logged in.


#### Input and Output Data

* Input:
  * N/a
* Output:
  * The list of job applications for the candidate, including the number of applicants.

## 3. Analysis

* Use case 3000: Our domain model satisfies the requirements of the aforementioned use case, ensuring that candidates
  can effectively list their job applications. For that we are interacting with the Candidate Aggregate and the JobApplicationsAggregate
  in order to list all job applications for a candidate.

* See the domain model in: [domain_model_v10.puml](..%2F..%2FGeneralDocumentation%2FDomain%20Model%2Fdomain_model_v10.puml)

## 4. Design

### 4.1. Realization (Sequence Diagram)

We opted to create 5 diagrams to separate the different steps made.

#### 4.1.1. Candidate App

#### 4.1.1.1. Sequence Diagram - Process

![Process_Diagram_US3000.svg](svg%2FProcess_Diagram_US3000.svg)

##### 4.1.1.2. Sequence Diagram - Connection

![Connection_CandidateApp_Sequence_Diagram.svg](svg%2FConnection_CandidateApp_Sequence_Diagram.svg)

##### 4.1.1.3. Sequence Diagram - Login

![Login_CandidateApp_Sequence_Diagram.svg](svg%2FLogin_CandidateApp_Sequence_Diagram.svg)

##### 4.1.1.4. Sequence Diagram - List Job Applications

![ReceiveApplication_CandidateApp_Diagram.svg](svg%2FReceiveApplication_CandidateApp_Diagram.svg)

#### 4.1.2. FollowUpServer

![FollowUpServer_Diagram-FollowUpServer_Diagram_US3000.svg](svg%2FFollowUpServer_Diagram-FollowUpServer_Diagram_US3000.svg)

### 4.2. Class Diagram

To see how the Class Diagram for this User Story would look, you simply need to look at the Domain Model and see the Candidate 
aggregate, with its associations, particularly with the JobApplication entity (where job applications are stored) and the 
JobOpening entity. This direct integration with the domain model ensures coherence and consistency in depicting the system's 
structure and behavior.
But because we have to deal with a server, we need to create a class diagram for the server side of the application.

![Server_Class_Diagram.svg](svg%2FServer_Class_Diagram.svg)

### 4.3. Applied Patterns

**Service Layer:** The Service Layer pattern is applied to the ListJobApplicationService class, which is responsible for listing
job applications for a candidate. This class interacts with the JobApplicationRepository to retrieve job application. This pattern encapsulates
business logic and transactions, providing a simplified interface to the client. It promotes loose coupling between the presentation
and data access layers, making the system more maintainable and flexible.

**Repository Pattern:** The Repository Pattern is applied to the JobApplicationRepository class, which is responsible for accessing
job application data. This class interacts with the database to handle the retrieval of job applications. This pattern decouples the application
logic from the data access layer, providing a collection-like interface for accessing domain objects, making data access more
manageable and organized.

**Aggregate Pattern:** The Aggregate Pattern is applied to the Candidate and JobApplication classes, where a Candidate aggregate
contains multiple JobApplications. This pattern ensures the consistency of changes to objects within the aggregate. An Aggregate
is a cluster of domain objects that can be treated as a single unit for data changes.

**SOLID Principles:** The SOLID principles are applied throughout the design of the classes, ensuring well-structured and maintainable code.

**Single Responsibility Principle (SRP):** Each class has a single responsibility. For example, ListJobApplicationService is only
responsible for listing job applications.

**Open-Closed Principle (OCP):** Classes are open for extension but closed for modification. New functionality can be added
without altering existing code. For example, new methods can be added to ListJobApplicationService without changing its existing methods.

**Liskov Substitution Principle (LSP):** Subtypes are substitutable for their base types. For instance, the JobApplicationRepository
interface is implemented by a concrete class, allowing any implementation to be swapped without affecting behavior.

**Interface Segregation Principle (ISP):** Clients are not forced to depend on interfaces they do not use. Interfaces are
client-specific rather than general-purpose. For instance, the JobApplicationRepository interface provides methods related to
job applications, which are used by ListJobApplicationService.

**Dependency Inversion Principle (DIP):** High-level modules do not depend on low-level modules; both depend on abstractions.
High-level classes like ListJobApplicationService depend on abstractions such as JobApplicationRepository, not on concrete classes.


### 4.2. Tests

Unit tests were deemed unnecessary as domain concepts had been thoroughly tested. Current operations involve manipulation
of existing domain instances, minimizing the need for additional testing.

## 5. Implementation

### Main classes created

#### Main Classes
1. **CandidateApp**: This is the main entry point for the candidate console application. It sets up the connection to the server, initializes the communication via `CommunicationController`, and displays the `FrontMenu`. It handles server connection responses and configures the authorization service.
2. **RcompServer**: This is the main class for starting and stopping the server. It initializes the server, sets up the authentication registry, and handles the server's lifecycle, including waiting for user input to stop the server.

#### Controllers
1. **CommunicationsController**: This class acts as a controller for managing server communication. It uses the `CommunicationService` singleton to initialize communication, test the connection, handle login, disconnect, and list job openings and applications.
2. **ListJobApplicationController**: This class is annotated with `@UseCaseController` and acts as a controller for listing job applications for a candidate. It uses `AuthorizationService` to ensure that the user is authorized before proceeding. It then retrieves the email of the authenticated user and uses `ListJobApplicationsService` to get the list of job applications.
3. **LoginController**: This is an interface that defines a contract for finding a username based on an email address. It includes one method, `findUsernameByEmail`.

#### Implementations
1. **LoginControllerImpl**: This class implements the `LoginController` interface. It uses a `UserRepository` to search for users based on their email and return the corresponding username. The repository is initialized with settings from the application configuration.

#### Handlers
1. **Handler**: This abstract class represents a generic handler for processing client requests. It manages the input and output streams and includes an abstract method `handle` for handling specific requests. The class also ensures the server's critical section is managed correctly using a semaphore.
2. **SimpleHandler**: Extending the `Handler` class, this class implements the specific logic for handling various client requests, such as authentication, listing job applications, and job openings. It interacts with repositories to fetch data and uses the `Translator` class to encode and decode messages.

#### Services
1. **CommunicationsService**: This singleton class manages communication with the server. It initializes the communication channel, handles login requests, tests the connection, and provides methods to fetch job openings and applications for specific customers and candidates. It uses the `Messenger` and `Translator` classes for sending and receiving messages.
2. **ListJobApplicationsService**: This is a service class annotated with `@Service`, indicating that it is a Spring-managed bean. It provides functionality to list job applications for a specific candidate based on their email. It retrieves job applications from the `JobApplicationRepository` and formats them into a list of strings with details about each job application.

#### Actions
1. **DisconnectAction**: This class implements the `Action` interface and handles the disconnection process. It uses the `CommunicationsController` to disconnect from the server and checks the response code to determine if the disconnection was successful, handling ACK and ERR responses appropriately.
2. **ServerAction**: This class implements the `Action` interface and is responsible for displaying the `ServerUI`. The `execute` method returns the result of the `show` method from `ServerUI`.
3. **ServerLoginAction**: This class implements the `Action` interface and handles the server login process. It prompts the user to log in, allowing up to three attempts. If the login is successful, it launches the `MainMenu` and enters the main loop. If the login fails after three attempts, it calls `DisconnectAction` to disconnect from the server.

#### User Interfaces
1. **ClientUserBaseUI**: This is an abstract class extending `AbstractUI`. It provides a customized headline based on the user's session, indicating whether the user is authenticated or anonymous. It includes a method to draw the form title with borders.
2. **FrontMenu**: This class extends `AbstractUI` and represents the front menu of the application. It allows users to either log in or exit the application. The menu uses a vertical layout with `VerticalMenuRenderer`.
3. **MainMenu**: This class extends `AbstractUI` and represents the main menu of the application. It includes options for accessing user-related actions and server actions to list job applications. It uses a vertical layout to render the menu.
4. **ServerUI**: This class extends `AbstractUI` and provides the user interface to list all job applications for a candidate. It fetches the job applications via the `CommunicationsController` and displays them to the user.
5. **SeverLoginUI**: This class extends `AbstractUI` and provides the user interface for server login. It prompts the user for their email and password and uses the `CommunicationsController` to attempt a login. It displays appropriate messages based on whether the login was successful or failed.

#### Server Management
1. **SemaphoreForServer**: This singleton class manages concurrent connections to the server using a semaphore. It initializes the semaphore with a maximum number of permits based on a system property and provides methods to activate and deactivate critical sections, as well as retrieve the number of available and maximum permits.
2. **Server**: This class manages the server socket and handles incoming connections. It maintains the server's running state and uses the `SemaphoreForServer` to limit the number of concurrent connections. When a connection is accepted, it creates a new `SimpleHandler` to process the client's requests.

#### Communication
1. **MessageCode**: This enum defines various message codes used for communication between the server and clients. It includes codes for testing the connection, disconnecting, acknowledgments, errors, authentication, listing job applications and job openings, and showing job applications and job openings.
2. **Messenger**: This class handles sending and receiving messages through a socket. It initializes object input and output streams for the given socket and provides methods to send and receive byte array messages.
3. **Translator**: This class provides methods to encode and decode messages for server communication. It includes methods for encoding messages with version, code, and data, and methods for decoding each component from an encoded message. Additionally, it has methods to serialize and deserialize lists of job openings and job applications.


## 6. Integration/Demonstration

For running this US we need to run the class 'RcompServer' to initialize the server and then the class 'CandidateApp' to run
the candidate "side" of the server. Beyond this, we need to insert the login credentials of a previously registered candidate
in the system, then we will be able to see the candidate list of job applications.

## 7. Observations

For this US we are using a Socket connection to communicate between the server and the client. The server is running in the
port 2004 and the client is running in the port 2004. The server is running in the localhost and the client is running in
the localhost. The server is running in the same machine as the client.
