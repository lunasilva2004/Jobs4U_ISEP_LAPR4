# US 3002 - As Customer, I want to list all my job openings, including job reference, position, active since, number of applicants. #47


## 1. Context
### 1.1. Customer Specifications and Clarifications


* Question 34: US3002, lista job openings, po
* zsition o que é?
    * Answer 34: Nessa US quando referimos “position” tem o mesmo significado que “title or function” na secção 2.2.2.

* Question 172: US3002 - Job Openings Clarifications - You stated that one of the this to show in the listing of job openings
  is "active since". You've clarified that an active job opening is the one where its recruitment process is on-going. Are
  the job openings listed in this funcionality only the ones with recruitment process on-going? Or also the ones without recruitment
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

AC 3002.3: The system, to display the number of applicants, should "count" the number of applications for the specific job opening in question.

#### Input and Output Data

* Input: 
  * N/a
* Output:
  * The list of job openings for the customer, including job reference, position, active since, and the number of applicants.

## 3. Analysis

* Use case 3002: Our domain model satisfies the requirements of the aforementioned use case, ensuring that Customers
can effectively list their job openings. For that we are interacting with the Customer Aggregate and the JobOpeningAggregate 
in order to list all job openings for a customer.

* See the domain model in: [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)


## 4. Design

### 4.1. Realization (Sequence Diagram)

For this user story, two sequence diagrams have been created: one for when the list of job openings is empty, and another 
for when it is not.

* Sequence Diagram 1: List of job openings is empty

  ![AlternativeSoluction_Diagram_US3002_ListJobOpeningEmpty-Alternative_Soluction_Diagram_US3002_ListJobOpeningsEmpty.svg](svg%2FAlternativeSoluction_Diagram_US3002_ListJobOpeningEmpty-Alternative_Soluction_Diagram_US3002_ListJobOpeningsEmpty.svg)

* Sequence Diagram 2: List of job openings is not empty

    ![AlternativeSoluction_Diagram_US3002_ListJobOpeningNotEmpty-Alternative_Soluction_Diagram_US3002_ListJobOpeningsEmpty.svg](svg%2FAlternativeSoluction_Diagram_US3002_ListJobOpeningNotEmpty-Alternative_Soluction_Diagram_US3002_ListJobOpeningsEmpty.svg)

### 4.2. Class Diagram

For UC 3002, the decision to omit a separate class diagram from the documentation is based on the principles of Domain-Driven 
Design (DDD). Duplicating class information from the domain model would introduce redundancy. By directly utilizing the domain 
model, clarity and efficiency are maintained in the documentation process while ensuring alignment with the project's evolving 
domain understanding. Therefore, to see how the Class Diagram for this User Story would look, you simply need to look at the 
Domain Model and see the Customer aggregate, with its associations, particularly with the JobOpening entity (where job openings 
are stored) and the JobApplication entity (where candidate applications are stored). This direct integration with the domain model 
ensures coherence and consistency in depicting the system's structure and behavior.


### 4.3. Applied Patterns



### 4.2. Tests


## 5. Implementation

### Main classes created

* 'ListJobOpeningsForCustomerUI': This class is responsible for the user interface of listing job openings for a customer. It displays the job openings to the customer and interacts with the ListJobOpeningController to fetch the necessary data.

* 'ListJobOpeningController': This class is responsible for controlling the process of listing job openings for a customer. It interacts with the ListJobOpeningService and ensures that the authenticated user is authorized to view the job openings.

* 'ListJobOpeningService': This class handles the business logic for listing job openings for a customer. It interacts with the JobOpeningRepository to fetch job openings and provides detailed information about each job opening.

## 6. Integration/Demonstration

We compile the CustomerApp and run the application. We log in as a customer and select the option 1 Login, and then insert 
the Customer credentials. After that you have to choose the option "List Job Openings" and the job openings for that Customer 
will be displayed.


## 7. Observations 

N/a