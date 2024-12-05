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
include key details such as number of applicants. By implementing this functionality,
Candidate can easily access and manage their applications within the system.

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

#### Dependencies:

1. **US 2000a - As an Operator, I want to register a candidate and create a corresponding user.**
    - This US is necessary to have candidates registered in the system, which is crucial for listing their respective applications.

2. **US 2002 - As an Operator, I want to register an application of a candidate for a job opening and import all files received.**
    - US 3000 directly depends on this US as listing applications is an essential part of listing all applications for a candidate.

3. **US 1005 - As a Customer Manager, I want to list all applications for a job opening.**
    - This US is necessary because it provides the ability to view all applications for a specific job opening, which is part of 
   listing a candidate's applications and their states.

4. **US 1002 - As a Customer Manager, I want to register a job opening.**
    - This US is related to the number of applicants because this number is determined by navigating through the job application 
   to the job opening and counting how many job applications that job opening has.

#### Acceptance Criteria:

AC 3000.1: The system should retrieve the email of the candidate who is logged in and list all job applications for that candidate.

AC 3000.2: The system should display the number of applicants for each job application.

AC 3000.3: The system, to display the number of applicants, should "count" the number of applications for the specific job opening 
associated to the job application in question.

#### Input and Output Data

* Input: 
  * N/a
* Output:
  * The list of job applications for the candidate, including the number of applicants.

## 3. Analysis

* Use case 3000: Our domain model satisfies the requirements of the aforementioned use case, ensuring that candidates
can effectively list their job openings. For that we are interacting with the Candidate Aggregate and the JobApplicationsAggregate 
in order to list all job applications for a candidate.

* See the domain model in: [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)


## 4. Design

### 4.1. Realization (Sequence Diagram)

For this user story, two sequence diagrams have been created: one for when the list of job applications is empty, and another 
for when it is not.

* Sequence Diagram 1: List of job applications is empty

  ![AlternativeSoluction_Diagram_US3002_ListJobOpeningEmpty-Alternative_Soluction_Diagram_US3002_ListJobOpeningsEmpty.svg](svg%2FAlternativeSoluction_Diagram_US3002_ListJobOpeningEmpty-Alternative_Soluction_Diagram_US3002_ListJobOpeningsEmpty.svg)

* Sequence Diagram 2: List of job applications is not empty

    ![AlternativeSoluction_Diagram_US3002_ListJobOpeningNotEmpty-Alternative_Soluction_Diagram_US3002_ListJobOpeningsEmpty.svg](svg%2FAlternativeSoluction_Diagram_US3002_ListJobOpeningNotEmpty-Alternative_Soluction_Diagram_US3002_ListJobOpeningsEmpty.svg)

### 4.2. Class Diagram

For UC 3000, the decision to omit a separate class diagram from the documentation is based on the principles of Domain-Driven 
Design (DDD). Duplicating class information from the domain model would introduce redundancy. By directly utilizing the domain 
model, clarity and efficiency are maintained in the documentation process while ensuring alignment with the project's evolving 
domain understanding. Therefore, to see how the Class Diagram for this User Story would look, you simply need to look at the 
Domain Model and see the Candidate aggregate, with its associations, particularly with the JobApplication entity (where job applications 
are stored) and the JobOpening entity. This direct integration with the domain model 
ensures coherence and consistency in depicting the system's structure and behavior.


### 4.3. Applied Patterns



### 4.2. Tests


## 5. Implementation

### Main classes created

* 'ListApplicationsForCandidateUI': This class is responsible for the user interface of listing job applications for a candidate. It displays the job application to the candidate and interacts with the ListJobApplicationController to fetch the necessary data.

* 'ListJobApplicationController': This class is responsible for controlling the process of listing job applications for a candidate. It interacts with the ListJobApplicationService and ensures that the authenticated user is authorized to view the job application.

* 'ListJobApplicationService': This class handles the business logic for listing job applications for a candidate. It interacts with the JobApplicationRepository to fetch job applications and provides detailed information about each job application.

## 6. Integration/Demonstration

We compile the CandidateApp and run the application. We log in as a candidate and select the option 1 Login, and then insert 
the Candidate credentials. After that you have to choose the option "List Job Applications" and the job openings for that Candidate 
will be displayed.


## 7. Observations 

N/a