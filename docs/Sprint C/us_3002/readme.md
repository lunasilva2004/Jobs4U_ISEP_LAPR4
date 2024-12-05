# US 3002 - As Customer, I want to list all my job openings, including job reference, position, active since, number of applicants. #47

## 1. Context
### 1.1. Customer Specifications and Clarifications

* Question 34: US3002, lista job openings, position o que é?
    * Answer 34: Nessa US quando referimos “position” tem o mesmo significado que “title or function” na secção 2.2.2.

* Question 172: US3002 - Job Openings Clarifications - You stated that one of the this to show in the listing of job openings 
is "active since". You've clarified that an active job opening is the one where its recruitment process is on-going. Are 
the job openings listed in this functionality only the ones with recruitment process on-going? Or also the ones without recruitment 
processes, the ones with processes that haven't yet started or have ended?
    * Answer 172: In the context of this US, “active since” means the date from the start of the process, the “application” phase
  (since that date, candidates can apply). This functionality should include all the “active” job openings.

## 1.2. Explanation

The purpose of this user story (US 3002) is to enable Customers to view a list of all their job openings. This list should 
include key details such as job reference, position, active since, and the number of applicants. By implementing this functionality,
Customers can easily access and manage their job openings within the system.

## 2. Requirements

*US 3002* As Customer, I want to list all my job openings, including job reference, position, active since, number of applicants. #47

#### Use Cases:

* This user story corresponds to the use case 3002 outlined in the Specifications Document.
  ([Specifications_Document.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Document.md)).

#### Functionality:

* This task involves providing a functionality for Customers to list all their job openings. The system should present a 
user-friendly interface for Customers to access this list, displaying essential details such as job reference, position, 
active since, and the number of applicants for each job opening.

#### Understanding:

* Customers will have the ability to view a comprehensive list of their job openings, facilitating better management and 
oversight of their recruitment processes. This feature enhances the user experience by providing easy access to important 
information about each job opening.

#### Dependencies:

1. **US 1001 - As a Customer Manager, I want to register a customer and have the system automatically create a user for that customer.**
  - This US is necessary for having customers registered in the system, which is crucial for listing their respective job openings.

2. **US 1002 - As a Customer Manager, I want to register a job opening.**
  - US 3002 directly depends on this US as listing job openings is an essential part of listing all job openings for a customer.

3. **US 1003 - As a Customer Manager, I want to list job openings.**
  - This US is crucial for listing all job openings for a customer. Listing job openings is a specific part of listing all .
    job openings for a customer.

4. **US 2002 - As an Operator, I want to register an application of a candidate for a job opening and import all files received.**
  - This US is necessary because the number of applications for a job opening is one of the elements that need to be listed.

5. **US 1005 - As a Customer Manager, I want to list all applications for a job opening.**
  - This US is necessary because the number of applications for a job opening is one of the elements that need to be listed.

#### Acceptance Criteria:

AC 3002.1: The system should retrieve the email of the customer who is logged in and list all job openings for that customer.

AC 3002.2: The system should display the job reference, position, active since, and the number of applicants for each job opening.

AC 3002.3: The system, to display the number of applicants, should "count" the number of applications for the specific job 
opening in question.

AC 3002.4: This functionality should be implemented using a server. The server will have a connection to the database to catch the list 
of job openings for a specific customer. The client will be displayed in the CustomerApp and will be able to see the list of job openings
for the customer logged in.

#### Input and Output Data

* Input:
  * N/a
* Output:
  * The list of job openings for the customer, including job reference, position, active since, and the number of applicants.

## 3. Analysis

* Use case 3002: Our domain model satisfies the requirements of the aforementioned use case, ensuring that Customers
  can effectively list their job openings. For that we are interacting with the Customer Aggregate and the JobOpeningAggregate
  in order to list all job openings for a customer.

* See the domain model in: [domain_model_v10.puml](..%2F..%2FGeneralDocumentation%2FDomain%20Model%2Fdomain_model_v10.puml)

## 4. Design

### 4.1. Realization (Sequence Diagram)

We opted to create 5 diagrams to separate the different steps made.

#### 4.1.1. Customer App

##### 4.1.1.1. Sequence Diagram - Process

![process_diagram_us3002-Process_Diagram_US3002.svg](svg%2Fprocess_diagram_us3002-Process_Diagram_US3002.svg)

##### 4.1.1.2. Sequence Diagram - Connection

![Connection_CustomerApp_Sequence_Diagram-Connection_Diagram__CustomerApp__US3002.svg](svg%2FConnection_CustomerApp_Sequence_Diagram-Connection_Diagram__CustomerApp__US3002.svg)

##### 4.1.1.3. Sequence Diagram - Login

![Login_CustomerApp_Sequence_Diagram-Login_Diagram__CustomerApp__US3002.svg](svg%2FLogin_CustomerApp_Sequence_Diagram-Login_Diagram__CustomerApp__US3002.svg)

##### 4.1.1.4. Sequence Diagram - List Job Openings

![ReceiveOpenings_CustomerApp_Diagram-ListJobOpening_Diagram__CustomerApp__US3002.svg](svg%2FReceiveOpenings_CustomerApp_Diagram-ListJobOpening_Diagram__CustomerApp__US3002.svg)

#### 4.1.2. FollowUpServer

![Connection_FollowUpServer_Diagram-FollowUpServer_Diagram_US3002.svg](svg%2FConnection_FollowUpServer_Diagram-FollowUpServer_Diagram_US3002.svg)


### 4.2. Class Diagram

To see how the Class Diagram for this User Story would look, you simply need to look at the Domain Model and see the Customer 
aggregate, with its associations, particularly with the JobOpening entity (where job openings are stored) and the JobApplication 
entity (where candidate applications are stored). This direct integration with the domain model ensures coherence and consistency 
in depicting the system's structure and behavior. 
But because we have to deal with a server, we need to create a class diagram for the server side of the application. 

![ServerClassDiagram-_size_20_Class_Diagram___Server___3002__size_.svg](svg%2FServerClassDiagram-_size_20_Class_Diagram___Server___3002__size_.svg)


### 4.3. Applied Patterns

**Service Layer:** The Service Layer pattern is applied to the ListJobOpeningService class, which is responsible for listing 
job openings for a customer. This class interacts with the JobOpeningRepository to retrieve job openings. This pattern encapsulates 
business logic and transactions, providing a simplified interface to the client. It promotes loose coupling between the presentation 
and data access layers, making the system more maintainable and flexible.

**Repository Pattern:** The Repository Pattern is applied to the JobOpeningRepository class, which is responsible for accessing 
job opening data. This class interacts with the database to handle the retrieval of job openings. This pattern decouples the application 
logic from the data access layer, providing a collection-like interface for accessing domain objects, making data access more 
manageable and organized.

**Aggregate Pattern:** The Aggregate Pattern is applied to the Customer and JobOpening classes, where a Customer aggregate 
contains multiple JobOpenings. This pattern ensures the consistency of changes to objects within the aggregate. An Aggregate 
is a cluster of domain objects that can be treated as a single unit for data changes.

**SOLID Principles:** The SOLID principles are applied throughout the design of the classes, ensuring well-structured and maintainable code.

  **Single Responsibility Principle (SRP):** Each class has a single responsibility. For example, ListJobOpeningService is only 
  responsible for listing job openings.

  **Open-Closed Principle (OCP):** Classes are open for extension but closed for modification. New functionality can be added 
  without altering existing code. For example, new methods can be added to ListJobOpeningService without changing its existing methods.

  **Liskov Substitution Principle (LSP):** Subtypes are substitutable for their base types. For instance, the JobOpeningRepository 
  interface is implemented by a concrete class, allowing any implementation to be swapped without affecting behavior.

  **Interface Segregation Principle (ISP):** Clients are not forced to depend on interfaces they do not use. Interfaces are 
  client-specific rather than general-purpose. For instance, the JobOpeningRepository interface provides methods related to 
  job openings, which are used by ListJobOpeningService.

  **Dependency Inversion Principle (DIP):** High-level modules do not depend on low-level modules; both depend on abstractions. 
  High-level classes like ListJobOpeningService depend on abstractions such as JobOpeningRepository, not on concrete classes.


### 4.2. Tests

Unit tests were deemed unnecessary as domain concepts had been thoroughly tested. Current operations involve manipulation
of existing domain instances, minimizing the need for additional testing.


## 5. Implementation

### Main classes created

#### Main Classes
1. **CustomerApp**: This is the main entry point for the customer console application. It sets up the connection to the server, initializes the communication via `ComunicationController`, and displays the `FrontMenu`. It handles server connection responses and configures the authorization service.
2. **RcompServer**: This is the main class for starting and stopping the server. It initializes the server, sets up the authentication registry, and handles the server's lifecycle, including waiting for user input to stop the server.

#### Controllers
1. **CommunicationsController**: This class acts as a controller for managing server communication. It uses the `CommunicationService` singleton to initialize communication, test the connection, handle login, disconnect, and list job openings and applications.
2. **ListJobOpeningController**: This class is annotated with `@UseCaseController` and acts as a controller for listing job openings for a customer. It uses `AuthorizationService` to ensure that the user is authorized before proceeding. It then retrieves the email of the authenticated user and uses `ListJobOpeningService` to get the list of job openings.
3. **LoginController**: This is an interface that defines a contract for finding a username based on an email address. It includes one method, `findUsernameByEmail`.

#### Implementations
1. **LoginControllerImpl**: This class implements the `LoginController` interface. It uses a `UserRepository` to search for users based on their email and return the corresponding username. The repository is initialized with settings from the application configuration.

#### Handlers
1. **Handler**: This abstract class represents a generic handler for processing client requests. It manages the input and output streams and includes an abstract method `handle` for handling specific requests. The class also ensures the server's critical section is managed correctly using a semaphore.
2. **SimpleHandler**: Extending the `Handler` class, this class implements the specific logic for handling various client requests, such as authentication, listing job applications, and job openings. It interacts with repositories to fetch data and uses the `Translator` class to encode and decode messages.

#### Services
1. **CommunicationsService**: This singleton class manages communication with the server. It initializes the communication channel, handles login requests, tests the connection, and provides methods to fetch job openings and applications for specific customers and candidates. It uses the `Messenger` and `Translator` classes for sending and receiving messages.
2. **ListJobOpeningService**: This is a service class annotated with `@Service`, indicating that it is a Spring-managed bean. It provides functionality to list job openings for a specific customer based on their email. It retrieves job openings from the `JobOpeningRepository` and formats them into a list of strings with details about each job opening.

#### Actions
1. **DisconnectAction**: This class implements the `Action` interface and handles the disconnection process. It uses the `CommunicationsController` to disconnect from the server and checks the response code to determine if the disconnection was successful, handling ACK and ERR responses appropriately.
2. **ServerAction**: This class implements the `Action` interface and is responsible for displaying the `ServerUI`. The `execute` method returns the result of the `show` method from `ServerUI`.
3. **ServerLoginAction**: This class implements the `Action` interface and handles the server login process. It prompts the user to log in, allowing up to three attempts. If the login is successful, it launches the `MainMenu` and enters the main loop. If the login fails after three attempts, it calls `DisconnectAction` to disconnect from the server.

#### User Interfaces
1. **ClientUserBaseUI**: This is an abstract class extending `AbstractUI`. It provides a customized headline based on the user's session, indicating whether the user is authenticated or anonymous. It includes a method to draw the form title with borders.
2. **FrontMenu**: This class extends `AbstractUI` and represents the front menu of the application. It allows users to either log in or exit the application. The menu uses a vertical layout with `VerticalMenuRenderer`.
3. **MainMenu**: This class extends `AbstractUI` and represents the main menu of the application. It includes options for accessing user-related actions and server actions to list job openings. It uses a vertical layout to render the menu.
4. **ServerUI**: This class extends `AbstractUI` and provides the user interface to list all job openings for a customer. It fetches the job openings via the `CommunicationsController` and displays them to the user.
5. **SeverLoginUI**: This class extends `AbstractUI` and provides the user interface for server login. It prompts the user for their email and password and uses the `CommunicationsController` to attempt a login. It displays appropriate messages based on whether the login was successful or failed.

#### Server Management
1. **SemaphoreForServer**: This singleton class manages concurrent connections to the server using a semaphore. It initializes the semaphore with a maximum number of permits based on a system property and provides methods to activate and deactivate critical sections, as well as retrieve the number of available and maximum permits.
2. **Server**: This class manages the server socket and handles incoming connections. It maintains the server's running state and uses the `SemaphoreForServer` to limit the number of concurrent connections. When a connection is accepted, it creates a new `SimpleHandler` to process the client's requests.

#### Communication
1. **MessageCode**: This enum defines various message codes used for communication between the server and clients. It includes codes for testing the connection, disconnecting, acknowledgments, errors, authentication, listing job applications and job openings, and showing job applications and job openings.
2. **Messenger**: This class handles sending and receiving messages through a socket. It initializes object input and output streams for the given socket and provides methods to send and receive byte array messages.
3. **Translator**: This class provides methods to encode and decode messages for server communication. It includes methods for encoding messages with version, code, and data, and methods for decoding each component from an encoded message. Additionally, it has methods to serialize and deserialize lists of job openings and job applications.


## 6. Integration/Demonstration

For running this US we need to run the class 'RcompServer' to inicialize the server and then the class 'CustomerApp' to run 
the customer "side" of the server. Beyond this, we need to insert the login credentials of a previously registered customer
in the system, then we will be able to see the customer list of job openings.

## 7. Observations

For this US we are using a Socket connection to communicate between the server and the client. The server is running in the
port 2004 and the client is running in the port 2004. The server is running in the localhost and the client is running in
the localhost. The server is running in the same machine as the client.
