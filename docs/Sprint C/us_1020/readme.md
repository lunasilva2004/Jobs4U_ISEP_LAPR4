# US 1020 - As Customer Manager, I want to publish the results of the selection of candidates for a job opening, so that candidates and customer are notified by email of the result.

## 1. Context
### 1.1. Customer Specifications and Clarifications


* Question 48: US1016 e US1020, relativamente ao envio das notificações por email, é necessário guardar que esse envio foi feito?
  * Answer 48: No documento nada de explicito é dito sobre este assunto. No entanto, do ponto de vista de gestão do processo da jobs4u parece-me adequado que essa informação fique registada

* Question 51: US 1020, qual é o formato para essa publicação?
  * Answer 51: A publicação refere-se a informar os candidatos e o cliente, por email. Os candidatos que são selecionados devem receber um email a indicar que para a sua candidatura ao job opening foram selecionados e irão ser contactados pela empresa. No que se refere à empresa, esta deve receber um email com a lista dos candidatos selecionados que deve incluir o nome e dados de contacto do candidato.

* Question 190: US1020 – Regarding the selection of candidates, should we assume that the first N candidates in the ranking (where N is the number of job vacancies) are chosen, or should we allow the customer manager to select the N candidates?
  * Answer 190: The first option (using the results from US1013).

* Question 207: US1010 - Ativar Fase "Result"- Já foi referido anteriormente que para uma fase estar no estado "active" é necessário que processos estejam a ser realizados. Sendo assim, que tipo de processos tem esta fase para poder colocá-la no estado "active"? Penso que não existe nenhuma US relacionada a esta fase.
  * Answer 207: Na fase “Result”, secção 2.2.1: “candidates as well as customers are notified of the final result “. Este texto parece o texto da US 1020.

* Question 224: US 1020 - Esta US pede que seja publicado os resultados das candidaturas, a minha pergunta seria se este processo só pode acontecer quando a job opening estiver encerrada ou se executar esta operação terminaria a job opening.
  * Answer 224: Esta US é relativa à última fase do processo. Se as notificações executarem todas com sucesso em princípio já não existe mais nada a fazer neste processo.

## 1.2. Explanation

The goal of this user story is to enable the Customer Manager to publish the job candidate selection results so that candidates and the customer are notified of the outcome via email.

## 2. Requirements

**US 1020** - As Customer Manager, I want to publish the results of the selection of candidates for a job opening, so that candidates and customer are notified by email of the result.


#### Use Cases:

* This user story will encompass use cases 1020 according to the data present in the Specifications Document.
  ([Specifications_Document.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Document.md)).


#### Functionality:

The functionality of this user story is to enable the Customer Manager to publish job candidate selection results,
automatically send email notifications to both candidates and the customer about the outcome, and record that 
these notifications were successfully sent.

#### Understanding:

The Customer Manager needs the capability to publish the results of the job candidate selection process. 
This involves notifying both the candidates and the customer via email. The email to the selected candidates 
should inform them that they have been chosen and will be contacted by the company. The email to the customer 
should include a list of the selected candidates with their names and contact details. Additionally, it is 
necessary to record that these notifications were sent to ensure proper management of the process.

#### Dependencies:

1. **US 1002 - As Customer Manager, I want to register a job opening.**

A job opening must exist to publish selection results.

2. **US 2000a - As Operator, I want to register a candidate and create a corresponding user.**

Candidates must be registered in the system to be selected and notified.

3. **US 2002 - As Operator, I want to register an application of a candidate for a job opening and import all files received.**

Applications need to be registered for candidates to be considered in the selection process.

4. **1013 As Customer Manager, I want to rank the candidates for a job opening.**
    
Candidate ranking is essential for selecting the top candidates for the job opening.

5. **1010 As Customer Manager, I want to open or close phases of the process for a job opening.**

Controls the phases of the process to determine when results can be published.

6. **1019 As Customer Manager, I want to get an ordered list of candidates, using the job interview points (grades), to help me analyze the candidates.**

An ordered list of candidates helps in the final selection process before publishing the results.

#### Acceptance Criteria:

- AC 1020.1: Selected candidates must receive an email informing them that they have been chosen for the job and will be contacted by the company.
- AC 1020.2: The customer must receive an email with the list of selected candidates, including their names and contact details.
- AC 1020.3: The system must record that email notifications were successfully sent to each candidate and to the customer.
- AC 1020.4: The publication and notification operation must occur only when the job opening is in its final phase.

#### Input and Output Data

*Input Data:*

* Data :
  * Job Reference of a job opening

*Output Data:*
* (In)Success message of the operation

## 3. Analysis

* Use case 1020: Our domain model satisfies the requirements of the aforementioned use case, ensuring that Customer Managers
  can effectively notify by email candidates and customers.
* See the domain model in: [domain_model_v10.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v10.puml)


## 4. Design

### 4.1. Realization (Sequence Diagram)

![sequence_diagram_us1020.svg](svg%2Fsequence_diagram_us1020.svg)

### 4.2. Class Diagram

For UC B1020 the decision to omit a separate class diagram from the documentation is based on the principles of Domain-Driven
Design (DDD). Duplicating class information from the domain model would introduce redundancy. By directly utilizing the
domain model, clarity and efficiency are maintained in the documentation process while ensuring alignment with the project's
evolving domain understanding. [domain_model_v10.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v10.puml)

### 4.3. Applied Patterns

#### Service Layer

The Service Layer pattern is applied to the  class. This class handle the business logic
related to file operations. This pattern encapsulates business logic and transactions, providing a simplified interface to
the client and promoting loose coupling between the presentation and data access layers.


### 4.2. Tests

**Test 1:**

```
    @Test
    void testCandidateAssociationInJobApplication() {
        Name name = new Name("John Doe");
        Email email = new Email("teste@this.app");
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        Candidate candidate1 = new Candidate(name, email, phoneNumber);

        assertEquals(candidate1, jobApplication.getCandidate());
    }
```

**Test 2:**

```
    @Test
    void testCustomerAssociation() {
        Address address = new Address("123 Main St");
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        Email email = new Email("john.doe@this.app");
        Name name = new Name("John Doe");
        Customer customer = new Customer(name, email, phoneNumber, address);

        assertEquals(customer, jobOpening.getCustomer());
    }
```


## 5. Implementation

### Main classes created

1. 'PublishResultsUI': The class provides a console-based user interface that allows the user to publish job opening results by entering a job opening reference and handling success or error messages.
2. 'PublishResultsController':The class is responsible for publishing the results of a job opening by utilizing the PublishResultsService to notify candidates and customers via email.
3. 'PublishResultsService':The class is responsible for notifying candidates and customers about the results of a job opening by sending emails to accepted candidates and the customer, using the job reference to retrieve the relevant ranking data from the repository.

## 6. Integration/Demonstration

To verify this functionality, simply run the backoffice application and log in as Customer Manager (username: manager1,
password: managerA1). Next, select option 2 (settings) to access all options available to the Customer Manager. Option 16
(Publish results of the selection of candidates), then will be asked to type the job reference of the job opening.This task
allows the Customer Manager to notify the customer and the candidade of the rank results for the job opening selected.

## 7. Observations 
N\A