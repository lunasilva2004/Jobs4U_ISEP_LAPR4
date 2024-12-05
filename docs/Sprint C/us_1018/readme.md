# US 1018 - As Customer Manager, I want to execute the process that evaluates (grades) the interviews for a job opening

## 1. Context

### 1.1. Customer Specifications and Clarifications

* Question 199: US1018 – Relativamente à US1018, após a execução do processo de avalição de todas as entrevistas da job
  opening, a fase em que esta se encontra deve ser automaticamente mudado para "Result" ou deve ser mantida em "
  Analysis" e apenas pode ser mudada pela execução da US1010?
    * Answer 199: A US1018 não deve alterar a fase actual. A US1010 permite fazer a mudança de fases do processo de
      recrutamento.

* Question 214: US1017/1018 – O nosso grupo tem uma dúvida em relação ao processamento dos ficheiros de respostas dos
  candidatos para a entrevista. No caso de upload de um ficheiro, se a pergunta que requer um número como resposta for
  preenchida com um formato inválido, por exemplo, uma letra, devemos considerar isso como um formato inválido na US
  1017 (e pedir para o user voltar a dar upload a um ficheiro válido) ou devemos, na US1018, considerar que está
  incorreta e atribuir 0 pontos automaticamente para essa resposta inválida? Isto é, na US 1017, devemos apenas
  verificar o formato do ficheiro ou devemos verificar também se as respostas são preenchidas com o tipo de dados
  correto?
    * Answer 214: O caso mencionado deve ser considerado um erro de validação do ficheiro (ou seja, o ficheiro submetido
      não corresponde à gramática definida).

* Question 238: US1018 - Relativamente a resposta que forneceu na Q206, referiu que uma jobOpening suporta apenas uma
  entrevista, isto significa que só um candidato que fez uma candidatura pode ser entrevistado de cada vez ou que cada
  candidatura está associada aquela entrevista em específico? Além disso cada candidatura que sofre uma entrevista terá
  de ter uma resposta a essa entrevista ou será antes a entrevista de uma job Opening terá uma resposta? Esta dúvida
  surge pois na US1018 é suposto avaliar todas as entrevistas de uma jobOpening quando disse que uma jobOpening suporta
  apenas uma entrevista.
    * Answer 238: Peço desculpa se não ficou claro, mas então deviam ter colocar a questão há mais tempo. Para cada job
      opening define-se o processo de recrutamento. Este pode ter ou não uma fase e entrevista. Se tiver fase de
      entrevista, então podemos admitir que é apenas uma entrevista. Mas quando digo isso, quero dizer uma entrevista
      para cada candidato e não uma entrevista para todos os candidatos a essa job opening. Penso que isso era claro.
      Caso contrário não fazia sentido ter, por exemplo, uma US para marcar uma entrevista com um candidato. Marcava-se
      uma entrevista com “todos” os candidatos ao mesmo tempo? Cada candidato, quando é entrevistado, são preenchidas as
      respostas que esse candidato deu na sua entrevista no documento que depois é submetido (US1017). Portanto, se
      houver fase de entrevistas, cada candidato deve ter a sua entrevista e a sua “classificação” nessa sua entrevista.

## 1.2. Explanation

The goal of this user story is to enable Customer managers to evaluate the interviews of a job application for a job
opening.
This data will be utilized to help ranking candidates and job applications for a job opening. By evaluating the
interviews,
the system will automatically validate the interviews information.

## 2. Requirements

**US 1018** - As Customer Manager, I want to execute the process that evaluates (grades) the interviews for a job
opening

#### Use Cases:

* This user story will encompass use cases 1018 according to the data present in the Specifications Document.
  ([Specifications_Document.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Document.md)).

#### Functionality:

The functionality is to allow the Customer Manager to execute the process that evaluates (grades) the interviews for a
job opening. This entails performing all necessary steps to assess the interviews of candidates for a specific job
opening as defined by the system.
It will involve comparing candidate responses with correct answers, calculating interview grades, and updating system
records with the assigned grades for each candidate.

#### Understanding:

The Customer Manager should have the capability to initiate the evaluation process for interviews conducted as part of a
job opening. This involves executing the necessary steps within the system to assess the performance of candidates
during interviews,
ultimately resulting in the assignment of grades or scores to each candidate based on their interview performance. The
functionality enables the Customer Manager to efficiently manage and finalize the evaluation of interviews.

#### Dependencies:

1. **US 1002 - As Customer Manager, I want to register a job opening.**

To assess an interview, this functionality allows to register a job opening, providing a structured framework for
conducting interviews.

2. **US 2002 - As Operator, I want to register an application of a candidate for a job opening and import all files
   received.**

When evaluating an interview, this functionality allows to register a candidate's application for a job opening,
ensuring all received files are imported seamlessly for assessment.

3. **US 1008 - As Language Engineer, I want to deploy and configure a plugin (i.e., Job Requirement Specification or
   Interview Model) to be used by the system.**

For the assessment process, this functionality allows to deploy and configure essential plugins like Job Requirement
Specifications or Interview Models,
enhancing the evaluation capabilities of the system.

4. **US 1011 - As Customer Manager, I want to select the Interview Model to use for the interviews of a Job Opening (for
   their evaluation/grading).**

When conducting interviews, this functionality allows to select the appropriate Interview Model tailored to the specific
job opening,
ensuring accurate evaluation and grading criteria.

5. **US 1012 - As Customer Manager, I want to generate and export a template text file to help collect the candidate
   answers during the interviews.**

To streamline the interview assessment process,this functionality allows to generate and export a template text file,
facilitating the collection of candidate answers during interviews,
ensuring consistency and efficiency in evaluation.

6. **US 1017 - As Customer Manager, I want to upload a text file with the candidate responses for an interview.**

During the evaluation phase, this functionality allows to upload a text file containing candidate responses, providing a
convenient means to input and assess interview data within the system.

#### Acceptance Criteria:

- AC 1018.1: Each job opening defines a recruitment process, which may or may not include an interview phase. If an
  interview phase exists,it should make sure that the job opening is on the interview phase.
- AC 1018.2: The grade should be a percentage.

#### Input and Output Data

*Input Data:*

* Data :
    * Job Reference of a job opening

*Output Data:*

* (In)Success message of the operation

## 3. Analysis

* Use case 1018: Our domain model satisfies the requirements of the aforementioned use case, ensuring that Customer
  Managers
  can effectively grade an interview.
* See the domain model
  in: [domain_model_v10.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v10.puml)

## 4. Design

### 4.1. Realization (Sequence Diagram)

![sequence_diagram_us1018.svg](svg%2Fsequence_diagram_us1018.svg)

### 4.2. Class Diagram

For UC B1018 the decision to omit a separate class diagram from the documentation is based on the principles of
Domain-Driven
Design (DDD). Duplicating class information from the domain model would introduce redundancy. By directly utilizing the
domain model, clarity and efficiency are maintained in the documentation process while ensuring alignment with the
project's
evolving domain
understanding. [domain_model_v10.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v10.puml)

### 4.3. Applied Patterns

#### Repository Pattern

We utilize the Repository pattern for managing the grade of an interview of a job application because:

1. The pattern abstracts away the complexities of database interactions, allowing us to focus on business logic without
   directly dealing with database specifics.
2. The JobApplicationRepository interface provides a standardized way to perform Create, Read, Delete and in this case
   Update operations on
   job application entities. This uniform interface simplifies data access throughout the application.
3. Implementations like JobApplicationJpaRepository and InMemoryCandidateRepository handle specific data store
   interactions.

#### DAO (Data Access Object) Pattern

The DAO (Data Access Object) pattern is used to encapsulate data access, providing an abstract interface to interact
with
the database or any other data source. In our implementation, the DAO pattern can be identified in the
JobApplicationRepository class.

1. The DAO pattern encapsulates data access operations such as saving, updating, retrieving, and deleting records. This
   allows database operations to be centralized in a single class, facilitating maintenance and reducing code
   duplication.
2. The DAO provides an abstract interface to interact with the data source, allowing the rest of the application to be
   independent of the specific database implementation.

#### Listener Pattern

The Listener pattern, also known as the Observer pattern, is a behavioral design pattern where an object (known as the
subject)
maintains a list of dependents (known as observers) that need to be notified of any state changes. When the state of the
subject
changes, it notifies all registered observers, typically by invoking one of their methods. This pattern can be
identified in the InterviewModelListenerImpl.

Overall, the Listener pattern allows for a flexible and extensible design where multiple listeners can react to changes
in the state of
a subject without tightly coupling them together. In the provided example class, it provides a clear separation of
concerns by focusing solely on
the extraction of correct answers from the interview model file.

#### Service Layer

The Service Layer pattern is applied to the ListCandidatesByInterviewsGradeService class. This class handle the business
logic
related to file operations. This pattern encapsulates business logic and transactions, providing a simplified interface
to
the client and promoting loose coupling between the presentation and data access layers.

#### Factory Pattern

The Factory Pattern is applied implicitly within the repository and service initialization, where
instances of repositories are created using specific factory methods or configuration settings. This pattern helps in
creating
objects without exposing the instantiation logic to the client and allows referring to the newly created object using a
common
interface.

### 4.2. Tests 

**Test 1:**

```

    @Test
    void testSetInterviewGrade() {
        InterviewGrade grade = new InterviewGrade(90);
        jobApplication.setInterviewGrade(grade);
        assertEquals(grade, jobApplication.getInterviewGrade());
    }
```
**Test 2:**

```
    @Test
    void testAssociateInterviewModel() {
        jobApplication.getJobOpening().setInterview(interviewModel);
        assertEquals(interviewModel, jobApplication.getJobOpening().getInterview());
    }
```

**Test 3:**

```

    @Test
    void testValidInterviewGradeConstruction() {
        InterviewGrade interviewGrade = new InterviewGrade(80);
        assertEquals(80, interviewGrade.getValue());
    }
```

**Test 4:**

```

    @Test
    void testInvalidDownBoundInterviewGradeConstruction() {
        assertThrows(IllegalArgumentException.class, () -> {
            new InterviewGrade(-10);
        });
    }
```

**Test 5:**

```
    @Test
     void testInvalidUpperBoundInterviewGradeConstruction() {
        assertThrows(IllegalArgumentException.class, () -> {
            new InterviewGrade(107);
        });
    }
```

**Test 6:**

```
    @Test
    void testJobOpeningAssociationInJobApplication() {
        
        Name name = new Name("John Doe");
        Email email = new Email("teste@this.app");
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        String jobReference = "JUNIOR_DEVELOPER";
        Address address = new Address("123 Main St");
        String company = "TechCorp";
        Customer customer = new Customer(name, email, phoneNumber, address);
        String contractType = "Full-time";
        String jobFunction = "Software Development";
        String mode = "Remote";
        String vacancies = "5";
        java.sql.Date startDate = java.sql.Date.valueOf("2024-01-01");
        java.sql.Date endDate = new java.sql.Date(startDate.getTime() + (1000L * 60 * 60 * 24 * 30)); // 30 dias a partir da
        data de início
        JobOpening jobOpening1 = new JobOpening(jobReference, address, company, customer, contractType, jobFunction, mode,
        vacancies, startDate, endDate);

        assertEquals(jobOpening1, jobApplication.getJobOpening());
    }
```


## 5. Implementation

### Main classes created

1. 'GradeInterviewUI': This class is responsible for the user interface of the evaluation of an interview process. It
   will ask for the job openings reference
   and then display a message if the operation was sucecced.
2. 'GradeInterviewController': The class is responsible for coordinating the authentication, retrieval of job
   applications, and initiation of the interview grading process using the GradeInterviewService.
3. 'GradeInterviewService':The class is responsible for authenticating users, retrieving job applications, processing
   candidate answers, evaluating interview responses, and storing the resulting grades for a given job reference.
4. 'InterviewGrade': This class represents the grade received in an interview within the job application management
   domain. It ensures that the interview grade falls within a valid range (0 to 100) upon instantiation.
5. 'InterviewModelListerImpl':This class is responsible for listening to the parsing events of an interview model file
   and extracting the correct answers for various types of interview questions.

## 6. Integration/Demonstration

To verify this functionality, simply run the backoffice application and log in as Customer Manager (username: manager1,
password: managerA1). Next, select option 2 (settings) to access all options available to the Customer Manager. Option
13
(Grade Interview) allows the Customer Manager to grade the interviews for a job opening. After choosing this option, it
will be asked to type
the job reference of the job opening.After that, the Customer Manager can grade the interviews. At the
end, the Customer Manager will see a message confirming the interview was evaluated.

## 7. Observations

N\A