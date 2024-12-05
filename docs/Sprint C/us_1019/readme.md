# US 1019 - As Customer Manager, I want to get an ordered list of candidates, using the job interview points (grades), to help me analyze the candidates.

## 1. Context
### 1.1. Customer Specifications and Clarifications

* Question 169: US1019 - Relativamente a esta user story, "US 1019 - As Customer Manager, I want to get an ordered list of candidates, using the job interview points (grades), to help me analyze the candidates.", a lista que pretende é relacionada a uma job opening correto? A maneira de ordenação é ascendente ou quer uma opção que inclua ascendente e descendente?
  * Answer 169: Sim, a ordenação é relativa a candidaturas para um job opening. A ordenação deve ser descendente, do que tem maior pontuação para o que tem menor pontuação.

* Question 177: US 1019 Esclarecimento - Na US 1019: As Customer Manager, I want to get an ordered list of candidates, using the job interview points (grades), to help me analyze the candidates. Pretende que para uma determinada Job Opening de um cliente meu, retorno uma lista ordenada de candidatos e suas notas da entrevista. Penso implementar essa funcionalidade da seguinte forma:

  Job Opening : XXX

  Nome | Email | Grade

  Jane Doe| jane@doe.pt | 85

  John Doe | john@doe.pt | 70

  Ou seja com ordenação descendente.

  Conforme refere Q153 consegue ver numa instancia esta lista, e noutra instancia faz o ranking que achar pertinente.

  Acha bem?
  * Answer 177: Penso que queira fazer referência a Q163. Relativamente ao exemplo que apresenta parece-me que satisfaz o que pretendo.


* Question 197: US1019 – Na questao Q169 é mencionado para a listagem ser ordenada descendentemente da nota da entrevista (como mencionado tambem na própria US), no entanto, a questão é, como idealiza a ordenação caso a job opening não possua entrevista?
    * Answer: Esta US não faz sentido para processos que não tenham entrevista

* Question 204: US 1019– segundo a resposta A197, devemos então apenas permitir a listagem de job openings que tenham entrevista?
  * Answer 204: Penso que não percebi bem a referência à listagem de job openings. Esta US não faz sentido para job openings que não tenham entrevista, uma vez que assenta na listagem dos candidatos e dos seus pontos nas entrevista.


* Question 226: US 1019 - Na descrição da user story : " As Customer Manager, I want to get an ordered list of candidates, using the job interview points (grades), to help me analyze the candidates". A intenção "analyze the candidates" impõe alguma mudança/remoção de candidatos no sistema?
  * Answer:A referência a “analize the candidates” é apenas para passar a ideia que se pretende nesta US que o sistema disponibilize uma forma do Customer Manager conseguir consultar o resultado das entrevistas de forma a ajudar a decidir o ranking dos candidatos. Nada mais. O ranking doa candidatos é registado no sistema através da US 1013


* Question 235: US 1019 - Justificação de Notas Entrevista - Nesta user story , as notas da entrevista têm que ter obrigatoriamente uma justificação ?
    * Answer:Na secção 2.3.4: “The system should provide a justification, such as "A minimum Bachelor degree is required for the job position”. A similar approach is used for job interviews, but in this case, the goal is not to approve or reject a candidate but to evaluate the answers and calculate a grade for the interview in the range 1-100”. Sim, seria importante apresentar uma listagem ordenada pelas notas. Devia ainda ser possivel, para cada entrevista, saber a justfificação para a nota. Pode ser considerada justificação saber para cada pergunta a nota obtida e qual foi a resposta data pelo candidato (por exemplo).

* Question 236:US 1019 Dúvida Fase analysis - Nesta user story , a expressão "to help me analyze candidates" ,na descrição da user story , impõe que a job Opening esteja na fase de análise ?
  * Answer:Não vejo isso como uma obrigação, mas penso que faz mais sentido nessa fase admitindo que apenas nessa fase seja garantido que todas as entrevistas foram efetuadas e todos os candidatos “avaliados” pelas entrevistas.


## 1.2. Explanation

The goal of this user story is to enable Customer managers to display the evaluation the interviews of candidates.
This data will be utilized to help ranking candidates and job applications for a job opening. By evaluating the interviews,
the system will automatically validate the interviews information.


## 2. Requirements

**US 1019** - As Customer Manager, I want to get an ordered list of candidates, using the job interview points (grades), to help me analyze the candidates.


#### Use Cases:

* This user story will encompass use cases 1019 according to the data present in the Specifications Document.
  ([Specifications_Document.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Document.md)).


#### Functionality:

The functionality is to allow the Customer Manager to obtain an ordered list of
candidates based on their job interview points (grades) to assist in the analysis and comparison of candidates. 
This feature enables the Customer Manager to help rank candidates according to their performance in interviews, 
facilitating informed decision-making during the hiring process.

#### Understanding:

The understanding is to provide the Customer Manager with a tool that organizes 
candidates by their interview grades. This ordered list will enable the Customer Manager to easily compare candidates'
performances, making the evaluation process more efficient and helping in selecting the best candidates for the job. 
The feature should be designed to fetch all relevant job applications, filter them based on the presence of interview 
grades, and then sort these applications in descending order of the grades. The ultimate goal is to support the Customer Manager in making well-informed hiring decisions.

#### Dependencies:


1. **US 1002 - As Customer Manager, I want to register a job opening.**

To assess an interview, this functionality allows to register a job opening, providing a structured framework for conducting interviews.

2. **US 2002 - As Operator, I want to register an application of a candidate for a job opening and import all files received.**

When evaluating an interview, this functionality allows to register a candidate's application for a job opening,
ensuring all received files are imported seamlessly for assessment.

3.  **US 1008 - As Language Engineer, I want to deploy and configure a plugin (i.e., Job Requirement Specification or Interview Model) to be used by the system.**

For the assessment process, this functionality allows to deploy and configure essential plugins like Job Requirement Specifications or Interview Models,
enhancing the evaluation capabilities of the system.

4. **US 1011 - As Customer Manager, I want to select the Interview Model to use for the interviews of a Job Opening (for their evaluation/grading).**

When conducting interviews, this functionality allows to select the appropriate Interview Model tailored to the specific job opening,
ensuring accurate evaluation and grading criteria.

5. **US 1012 - As Customer Manager, I want to generate and export a template text file to help collect the candidate answers during the interviews.**

To streamline the interview assessment process,this functionality allows to generate and export a template text file, facilitating the collection of candidate answers during interviews,
ensuring consistency and efficiency in evaluation.

6. **US 1017 - As Customer Manager, I want to upload a text file with the candidate responses for an interview.**

During the evaluation phase, this functionality allows to upload a text file containing candidate responses, providing a convenient means to input and assess interview data within the system.

7. **US 1018 - As Customer Manager, I want to execute the process that evaluates (grades) the interviews for a job opening.**

The functionality is to allow the Customer Manager to execute the process that evaluates (grades) the interviews for a job opening.


#### Acceptance Criteria:

- AC 1019.1: While not mandatory, it makes more sense for the job opening to be in the analysis phase when using this functionality.
- AC 1019.2: This functionality is applicable only to job openings that have interviews.
- AC 1019.3: The ordered list of candidates should be sorted in descending order based on their interview points, from highest to lowest.


#### Input and Output Data

*Output Data:*
* (In)Display the name, email and grade of an interview of candidates by a descending order by grade

## 3. Analysis

* Use case 1018: Our domain model satisfies the requirements of the aforementioned use case, ensuring that Customer Managers
  can effectively display candidates of an interview for a job opening.
* See the domain model in: [domain_model_v10.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v10.puml)


## 4. Design

### 4.1. Realization (Sequence Diagram)

![sequence_diagram_us1019.svg](svg%2Fsequence_diagram_us1019.svg)

### 4.2. Class Diagram

For UC B1019 the decision to omit a separate class diagram from the documentation is based on the principles of Domain-Driven
Design (DDD). Duplicating class information from the domain model would introduce redundancy. By directly utilizing the
domain model, clarity and efficiency are maintained in the documentation process while ensuring alignment with the project's
evolving domain understanding. [domain_model_v10.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v10.puml)


### 4.3. Applied Patterns

#### Repository Pattern

We utilize the Repository pattern for displaying the candidates grade of an interview of a job application because:

1. The pattern abstracts away the complexities of database interactions, allowing us to focus on business logic without
   directly dealing with database specifics.
2. The JobApplicationRepository interface provides a standardized way to perform Create, Read, Delete and Update operations on
   job application entities. This uniform interface simplifies data access throughout the application.
3. Implementations like JobApplicationJpaRepository and InMemoryCandidateRepository handle specific data store interactions.

#### Service Layer

The Service Layer pattern is applied to the ListCandidatesByInterviewsGradeService class. This class handle the business logic
related to file operations. This pattern encapsulates business logic and transactions, providing a simplified interface to
the client and promoting loose coupling between the presentation and data access layers.

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
    void testCandidateAssociationInJobApplication() {
        Name name = new Name("John Doe");
        Email email = new Email("teste@this.app");
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        Candidate candidate1 = new Candidate(name, email, phoneNumber);

        assertEquals(candidate1, jobApplication.getCandidate());
    }
```

**Test 4:**

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

1. 'ListCandidatesByInterviewGradesUI': This class is responsible for displaying a list of job applications with interview grades, sorted in descending order. 
    It iterates through the applications to display each candidate's name, email, and grade in a specified format.
2. 'ListCandidatesByInterviewGradesController': The class is responsible for coordinating the retrieval, evaluation, and sorting of job applications by interview grade through the ListCandidatesByInterviewGradeService.
3. 'ListCandidatesByInterviewGradesService':The class is responsible for retrieving, evaluating, and sorting job applications by interview grade, and providing justifications for each candidate's grade.

## 6. Integration/Demonstration

To verify this functionality, simply run the backoffice application and log in as Customer Manager (username: manager1,
password: managerA1). Next, select option 2 (settings) to access all options available to the Customer Manager. Option 13
(List Candidates By Interview Grade) allows the Customer Manager to display by a descending order,of the interview grade,all candidates. After choosing this option, it will be display the name 
the email and the respective grade of the interview.

## 7. Observations 
N\A