# US 1013 - As Customer Manager, I want to rank the candidates for a job opening #34


## 1. Context
### 1.1. Customer Specifications and Clarifications

* Question 3: Quem é responsável por analisar as candidaturas  (applications)?
    * Answer 3: Será o Customer Manager. Este analisa as candidaturas e decide o ranking dos candidatos.

* Question 17: Relativamente à secção 2.2.1, é na fase de Analysis que as  entrevistas são avaliadas e é esse resultado que 
define o ranking dos candidatos? Além disso, para que serve o CV nesta fase? Visto que as entrevistas não são obrigatórias, 
o que acontece quando estas não se realizam?
    * Answer 17: A pontuação das entrevistas é efetuada/calculada na fase das entrevistas. O CV e outros dados (como o resultado
  das entrevistas) é usado pelo Customer manager na fase de analise para ordenar os candidatos. Mas a ordenação é da responsabilidade
  do Customer Manager (por exemplo, não tem de seguir a ordem da pontuação nas entrevistas). A US 1013 corresponde à ordenação
  manual dos candidatos feita pelo Customer Manager. O facto de não haver entrevistas não tem implicações na ordenação dos candidatos
  pois esta não depende explicitamente das entrevistas.

* Question 142: US1013 - Candidate Ranking – Mr Client mention a manual ranking (Q17). If the pontuation of an interview 
is not essential for the candidate's rank, what criteria is to be used when ranking?
  * Answer 142: Please view again Q17. The ranking is a decision of the Customer Manager based on all the data that he/she 
    may have during the process (including CV and other attached documents and the interviews as well as other data/information 
  that may not be part of the system).

* Question 148: US 1013 – A minha questão é relativa a como o ranking é feito. O customer manager dá uma nota a cada candidatura 
e o sistema ordena por ordem crescente sendo assim atribuído o ranking de cada candidatura? Se for assim, a nota terá que 
escala? Caso ainda seja assim ele só pode atribuir uma nota quando tiver conhecimento de todas? Ou pode ir colocando e o 
ranking só é atribuído quando todas as candidaturas já estiverem avaliadas?
    * Answer 148: Ver Q17. A ordenação dos candidatos (ranking) é da responsabilidade do customer manager. Ele pode basear-se 
  no resultado das entrevistas e de outra informação, mas o ranking não é automático. Não há nota nem escala a usar. As 
  candidaturas são ordenadas.

* Question 155: US1013 - Rank Entries - Is there a limit on rank entries? Let's say that 100 candidates apply for a job opening. 
Does the Customer Manager have to sort all 100 candidates?
    * Answer 155: The order of candidates should include at least all the first candidates within the vacancy number and some 
  following candidates. At the moment, I do not know exactly the number of the following candidates to be ordered. Therefore, 
  I would like for it to be a global configuration property in the system. It could be a number representing a magnitude from 
  the vacancy number. For instance, 1 could mean exactly the same number of vacancies, 2 the double, 0,5 half the number of 
  vacancies. The remainder of the candidates could be just tagged as not ranked.

* Question 157: US1013 - Rank the candidates for a job Opening is the same as rank the job Applications for a Job Opening, 
knowing that I can only know the candidates throw the job application?
  * Answer 157: In the context of a job opening, a candidate is someone that made an application to that job opening. But 
  the same person can be a candidate to other job openings.

* Question 158: US1013 - Process of ranking - How is the ranking done? The customer manager selects a job opening and is shown 
the different candidates, and they assign a rank to each one. And the ranking process end when he assigns a rank to all 
candidates? Example: - Rank the candidate1: - Write the rank: 3 - Rank the candidate2: - Write the rank: 1 - Rank the candidate3:
- Write the rank: 4
    * Answer 158: See Q155. Once again, I do not have specific requirements for UI/UX. But I can provide some ideas. Being a 
  console application limits the UI/UX. However, I see this functionality similar to the way people enter recipients for an 
  email, for instance. In the case of the recipients of an email I simply write their emails separated by a comma. Could it be 
  similar in this case? 

* Question 159: US1013 - Stop the ranking process - When a customer manager starts the ranking process, he can stop and 
continue later? Or the ranking process must be done in one go?
    * Answer 159: See Q158. I guess it may depend on how you implement the solution. But, in the case it may work as a 
  “long operation” be aware of when and how to conclude the “operation”.

* Question 160: US1013 - Edit ranking - The customer manager can change the rank of a candidate after assigning it?
    * Answer 160: See Q159. That should be possible if none of the interested parties were yet notified of the results.

* Question 162: US1013 - When the analysis phase ends, the ranking need to have all the candidates? or can the customer manager 
rank only some of the candidates?
    * Answer 162: See Q149. All the candidates should be ranked before moving to the result phase.

* Question 163: US1013 - When the customer manager is ranking the candidates, in terms of UI, should we display information 
from the application such as interview score, etc... or just the candidate's name and email?
    * Answer 163: As stated before, I do not have specific requirements for the UI/UX. Use best practices. However, I would 
  like it to be possible for the Customer Manager to have 2 or more instances of the application running, so that he/she could, 
  for instance, see the interviews grades and, at the same time, register the order/ranking of the candidates.

* Question 165: US1013 Clarifications - Mr. Client mentioned in Q155 that the system should have ranking configurations so that 
the Customer Manager doesn't have to rank all the candidates for a job opening, and that the ones that haven't been manually 
ranked are to be tagged with "not ranked". However, in Q162, you've said that all the candidates must be ranked before the result
phase starts. Can you clarify this situation?
    * Answer 165: The customer manager must evaluate all the candidates. It is the only way he/she can produce a ranking/order 
  for the candidates and select the “best” candidates to be included in the vacancies for the job opening. In Q155 I was only 
  proposing a way to avoid recording in the system a lot of details that will not have any impact on the next activities. 
  The term “not ranked” maybe is not the best. Maybe “rank not recorded” or something similar could be more appropriated.

* Question 183: US1013 – documents - When ranking the candidates, the customer manager makes decisions based on their CV 
and other relevant documents. My question is: should there be an option for the customer manager to view the relevant documents 
before ranking a candidate? Or has the customer manager already made the decision before ranking the candidates and purely uses 
this functionality to assign the previously planned ranking?
    * Answer 183: Once again this could be only a UX/UI issue. Please refer to Q17, Q163 and Q140. Also note that there is US1021 
  for listing application data.

* Question 215: US1013 – About the Us1013 which states: "As Customer Manager, I want to rank the candidates for a job opening.". 
I want to know if two candidates can be tied, which would mean having the same rank for the same job opening
    * Answer 215: No, ties should not be allowed. It must be clear what candidates are selected to the vacancies.

* Question 216: US1013 – Can we assume that once an interview is evaluated, a score is provided and that score is initially used 
for the rank entry associated with said application? The Customer Manager is then capable of defining manually the rank order.
    * Answer 216: I see no need for that. This would be an extra functionality.

* Question 241: US1013 - Na US1013 é suposto dar classificação aos candidatos, mas surgiu-nos uma questão que é após a conclusão desta 
US, a mesma deve avançar a fase do job opening, ou seja, passar da fase de analise (Analysis) para a fase de resultado (Result)?
  * Answer 241: Em principio a mudança de fases deve ser feita apenas no âmbito da respetiva US.

## 1.2. Explanation 

The objective of this user story is to provide Customer Managers with the functionality to rank candidates for a job opening. 
The Customer Manager will have access to job opening selected and the job applications for that job opening. The Customer 
Manager can then manually adjust this ranking based on additional data such as CVs and other relevant documents like the interview score.

## 2. Requirements

**US 1013** As Customer Manager, I want to rank the candidates for a job opening

#### Use Cases: 

* This user story will encompass use cases 1013 according to the data present in the Specifications Document.
  ([Specifications_Document.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Document.md)).

#### Functionality: 

* The task aims to enable Customer Managers to rank candidates for a job opening. This process involves:
  - Selecting a job opening to initiate the ranking process.
  - Displaying the list of job applications to rank.
  - Allowing manual adjustments to the rankings.

#### Understanding: 

The Customer Manager is responsible for the ranking process. This process involves selecting the job opening that the Manager 
wishes to work on, and then the system will display all the job applications for the chosen job opening. Next, the system will 
prompt the Manager to enter the rank for each of the job applications.

#### Dependencies: 

1. **US 1002 - As a Customer Manager, I want to register a Job Opening:** This user story is dependent on the creation of job
openings. The Customer Manager will need to select a job opening to rank the candidates for that job opening.

2. **US 2002 - As Operator, I want to register a job application of a candidate for a job opening and import all files received:**
This user story is dependent on the job applications being registered. The Customer Manager will need to rank the candidates
based on the job applications received.


#### Acceptance Criteria: 

AC 1013.1: When the Job Opening has more Job Applications than vacancies, the system should ask the user which Job Applications
they want to rank according to the number of vacancies for the selected Job Opening. Consequently, the Job Applications that 
are not selected will have a null value, indicating that they were not chosen to be ranked. (based on question 155)

AC 1013.2: The system should support concurrent instances of the application for Customer Managers, enabling them to view interview 
grades and simultaneously register the order or ranking of candidates. This functionality enhances efficiency and flexibility 
in the ranking process. (based on question 163)

AC 1013.3: Ties in candidate rankings should not be permitted to ensure clarity in candidate selection for the vacancies. Each candidate
should have a distinct and unambiguous rank, allowing for clear decision-making by the Customer Manager. (based on question 215)

AC 1013.4: The Job Openings that should appear for the Customer Manager must only be those that are in the analysis phase, 
as it is during this phase that the ranking of applications is conducted.

AC 1013.5: The Job Applications that should be displayed must only be those associated with the selected Job Opening.


#### Input and Output Data

*Input Data:*

* Selection Data : 
  * Job opening
  * Job applications to rank
* Insert Data:
  * Rank adjustments
  
*Output Data:*
  * (In)Success of the operation



## 3. Analysis

* Use case 1013: Our domain model satisfies the requirements of the aforementioned use case, ensuring that Customer Managers 
can effectively rank candidates. For that we are interacting with the Rank Aggregate.
* See the domain model in: [domain_model_v10.puml](..%2F..%2FGeneralDocumentation%2FDomain%20Model%2Fdomain_model_v10.puml)


## 4. Design

### 4.1. Realization (Sequence Diagram)

![sequence_diagram_us1013-_size_20_Sequence_Diagram_US_1013__size_.svg](svg%2Fsequence_diagram_us1013-_size_20_Sequence_Diagram_US_1013__size_.svg)

### 4.2. Class Diagram 

For UC 1013, the decision to omit a separate class diagram from the documentation is based on the principles of Domain-Driven
Design (DDD). Duplicating class information from the domain model would introduce redundancy. By directly utilizing the domain
model, clarity and efficiency are maintained in the documentation process while ensuring alignment with the project's evolving
domain understanding. Therefore, to see how the Class Diagram for this User Story would look, you simply need to look at the 
Domain Model and see the Rank Aggregate and its connections with the Job Application and the Job Opening.

[domain_model_v10.puml](..%2F..%2FGeneralDocumentation%2FDomain%20Model%2Fdomain_model_v10.puml)

### 4.3. Applied Patterns 

* **Service Layer:** The Service Layer pattern is applied to the 'RankService' class, which is responsible for the service of the
ranking process. This class interacts with the 'RankRepository' to handle the ranking of candidates. This pattern is used to 
encapsulate business logic and transactions, providing a simplified interface to the client. It promotes loose coupling between
the presentation and data access layers, making the system more maintainable and flexible.

* **Repository Pattern:** The Repository Pattern is applied to the 'RankRepository' class, which is responsible for the repository
of the ranking process. This class interacts with the database to handle the ranking of candidates. This pattern is used to decouple
the application logic from the data access layer. It provides a collection-like interface for accessing domain objects, making
the data access more manageable and organized.

* **Aggregate Pattern:** The Aggregate Pattern is applied to the 'Rank' class, which is responsible for the ranking of candidates. 
This pattern is used to ensure the consistency of changes to objects in the aggregate. An Aggregate is a cluster of domain 
objects that can be treated as a single unit.

* **Factory Pattern:** The Factory Pattern is applied to the 'JpaRepositoryFactory' class, which is responsible for creating instances of the
'Rank' class. This pattern is used to create objects without exposing the instantiation logic to the client and to refer to 
the newly created object using a common interface.

* **SOLID Principles:** The SOLID principles are applied throughout the design of the classes, ensuring that the classes are well-structured
and maintainable. The classes are designed to be single-responsibility, open-closed, Liskov substitution, interface segregation, and dependency
inversion. This ensures that the classes are easy to understand, extend, and maintain. 
  * **Single Responsibility Principle (SRP):** Each class has a single responsibility. For example, RankService is only responsible
  for the service of the ranking process. 
  * **Open-Closed Principle (OCP):** My classes are open for extension but closed for modification. This means I can add new functionality
  without changing the existing code. For example, new methods can be added to the RankService class without altering its existing methods.
  * **Liskov Substitution Principle (LSP):** Subtypes must be substitutable for their base types. This means that if a class is 
  used through an interface, the concrete implementation can be swapped without affecting behavior. For example, the RankRepository
  interface is implemented by a concrete class. Any class that implements this interface can be substituted in place of RankRepository
  without affecting the behavior of the program.
  * **Interface Segregation Principle (ISP):** Clients should not be forced to depend on interfaces they do not use. This means 
  that my interfaces are client-specific rather than general-purpose. For instance, the RankRepository interface provides a 
  specific set of methods related to the Rank domain object. This interface is used by the RankService class, which means RankService 
  is not forced to depend on methods it does not use.
  * **Dependency Inversion Principle (DIP):** High-level modules should not depend on low-level modules. Both should depend on 
  abstractions. This means that my high-level classes (like RankService) depend on abstractions (like RankRepository), not 
  on concrete classes.


### 4.2. Tests

[OrderTest.java](..%2F..%2F..%2Fjobs4u.core%2Fsrc%2Ftest%2Fjava%2Fjobs4u%2Fcore%2Frankmanagement%2Fdomain%2FOrderTest.java)

[RankTest.java](..%2F..%2F..%2Fjobs4u.core%2Fsrc%2Ftest%2Fjava%2Fjobs4u%2Fcore%2Frankmanagement%2Fdomain%2FRankTest.java)

## 5. Implementation

### Main classes created 

1. 'RankUI': This class is responsible for the user interface of the ranking process. It will display the job openings and the 
   job applications for the selected job opening. The Customer Manager can then adjust the rankings of the candidates.
2. 'RankController': This class is responsible for the control of the ranking process. It will interact with the 'RankService' 
   to handle the ranking of candidates.
3. 'RankService': This class is responsible for the service of the ranking process. It will interact with the 'RankRepository' 
   to handle the ranking of candidates.
4. 'RankRepository': This class is responsible for the repository of the ranking process. It will interact with the database 
   to handle the ranking of candidates.
5. 'Rank': This class is responsible for the ranking of candidates. It will store the rank of each candidate for a job opening.
6. 'Order': This class is responsible for the order of candidates. It will store the order of candidates for a job opening.


## 6. Integration/Demonstration 

To verify this functionality, simply run the backoffice application and log in as Customer Manager (username: manager1@this.app, 
password: managerA1). Next, select option 2 (settings) to access all options available to the Customer Manager. Option 12 
(Rank Candidates) allows the Customer Manager to rank the candidates for a job opening. After choosing this option, a list 
of job openings will appear, and the Customer Manager will be asked to select one. Then, a list of candidates for that job 
opening will appear, and if the number of job applications is bigger then the number of vacancies the application will ask 
to select the job applications that the user wants to rank. After that, the Customer Manager can rank the candidates. At the 
end, the Customer Manager will see a message confirming the ranking process.

## 7. Observations 

N/A

