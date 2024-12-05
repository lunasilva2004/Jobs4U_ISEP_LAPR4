# US 2004 - As Operator, I want to upload a text file with the data fields (requirements ) of a candidate for its verification #44

## 1. Context
### 1.1. Customer Specifications and Clarifications


* Question 15: É o Operador que regista uma candidatura ou é o sistema que o faz automaticamente? E como integra o “plugin” 
de verificação da candidatura neste processo?
    * Answer 15: Na US 2002 o Operator regista a candidatura. Para isso, é o Operator que inicia o processo mas o sistema 
  deve importar os dados resultantes do Application File Bot de forma “automática” (Ver References da US 2002). O plugin 
  referido entre neste processo através da US 2003, em que o Operador gera um ficheiro template com os dados a introduzir para 
  validar uma candidatura. Na US 2004, o Operador, após preencher os dados específicos da candidatura (com base no ficheiro 
  template anterior) submete no sistema esse ficheiro que vai ser usado para o sistema avaliar/verificar a candidatura. Se 
  os critérios não forem atingidos a candidatura é recusada.

* Question 102: US2003 – Quem vai preencher as respostas no ficheiro template?
    * Answer 102: Será o Operador e, no âmbito da US2004, este submete o ficheiro já preenchido no sistema.

* Question 119: Management of screening data - We have a question about the management of the screen phase of the recruitment 
process. Specifically, after the applications are filtered during the screening process, I'm unsure about who manages the 
results and oversees this phase. Could you please clarify if the responsibility for managing the screening results falls 
under the customer manager, the operators, or both?
    * Answer 119: In US2003 and US2004 it is the Operator that “downloads” a template file to register the requirements, 
  registers the answers for the requirements in the file, and then uploads the file. It is then the Costumer manager that 
  executes the verification process (US1015) and executes the notification of the results (US1016)
 
* Question 132: US1008 - US2003 - Usage of ANTLR- Is it possible to clarify the usage of ANTRL within user story 2003? 
You've stated in Q15, Q102 and Q119, that US2003 simply generates the file, while in US2004 the Operator defines the answers 
and uploads the file. Where is this file uploaded to? Given this, where is the usage of ANTRL in US2003 directed to?
    * Answer 132: Regarding the first question, although difficult it is possible to generate the template text file using 
  ANTLR. If so, there we have the usage o ANTLR. Although, unless there is some specific evaluation requirement from LPROG, 
  it is acceptable that the template file is hardcoded in the plugin (no need for any “complex” generation process/function).
  Regarding the second question, the file is uploaded to the system. The last question was answered first.

* Question 166: US2004 - Requirements Answers - I'm having trouble understading where are the requirements answer obtained 
from the candidates, so that the operator can then register their answers in the template previously generated and submit 
them to the system. Are these answers already within the files processed by tge application fie bot?
    * Answer 166: Please see Q15, Q102, Q119 and Q123. We can assume that the operator has access to all the files submitted 
  by the candidates (since he/she is the one that imports the files into the system – US2002). He/she can than consult these 
  files in order to answer the questions in the requirements template file. She/he then submits the file with the answers (US2004).

* Question 180: US2004 - Candidate Answers - Does US2004 only deals with the upload of the file to the system or also the 
registration of the candidate's answer by the Operator? I've seen many mentions about the file's answers but I want to understand 
if that aspect is also part of US2004.
    * Answer 180: In US2003 the Operator downloads a template file that he/she uses to register the candidate requirements. 
  In US 2004, the Operator uploads a file with the requirements and the system should validate the file (verify of the syntax 
  is correct). US 1015 is the one that executes the verification of requirements for the candidates (based on the previously 
  uploaded files).

* Question 218: US2004 - Submissão de um ficheiro para verificação – O meu grupo tem uma dúvida em relação à US2004, nomeadamente 
sobre o processo de submissão do ficheiro. Gostaríamos de saber se "submeter o ficheiro para verificação" na US 2004 implica apenas 
guardar o caminho do ficheiro no sistema e fazer a sua análise sintática (como referiu na Q180) ou se envolve também a extração e
armazenamento da informação contida no ficheiro em estruturas específicas para posterior verificação. Temos esta dúvida porque
há User Stories em que está explícito que é suposto importar as informações dos ficheiros, como por exemplo na US2002: "As Operator,
I want to register an application of a candidate for a job opening and import all files received". No entanto, na US2004 não está 
explícito o que significa "submeter o ficheiro".
    * Answer 218: Submeter o ficheiro significa “importar” o ficheiro para o sistema, verificando se está sintaticamente correto. 
  O ficheiro passa a fazer parte do sistema, sendo possível operações posteriores sobre esse ficheiro/dados, como a US1015. Não 
  quero/devo condicionar como é que isso é feito em termos de solução.

* Question 223: US 2004 – About the Us2004, in A180 you previously stated that "the Operator uploads a file with the requirements 
and the system should validate the file (verify of the syntax is correct). US 1015 is the one that executes the verification...". 
What should happen if the file failes this verification? Is the application instantly refused or do you have something else in mind?
    * Answer 223: A file that fails the verification means that that file has an error (syntactic error) it does not mean that the 
  application does not meet the requirements. The user should fix the error and submit again. Only US 1015 results in approving 
  or rejecting an application.

* Question 228: US 2004 - About the Us2004, when the Operator uploads the text file, in which phase is this US going to be?
    * Answer 228: All the files of the candidate must have been imported before. These files will be necessary for the operator 
  to be able to answer the questions in the requirements specification template. Only then can the operator upload the file with
  the answers. This is the normal sequence. Regarding the phase of the process, I think it will depend on the proposed solution.
  I am open to solutions that do not invalidate the data consistency of the system.

## 1.2. Explanation 

The goal of this user story is to enable Operators to upload a text file that contains various data fields related to candidates. 
This data will be utilized to verify if candidates meet the specific requirements for a job opening. By uploading the text file, 
the system will automatically parse and validate the candidate information against the predefined job criteria.

## 2. Requirements

**US 2004** As Operator, I want to upload a text file with the data fields (requirements ) of a candidate for its verification

#### Use Cases:

* This user story will encompass use cases 2004 according to the data present in the Specifications Document.
  ([Specifications_Document.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Document.md)).

#### Functionality:

* This task enables Operators to upload a text file containing candidate data fields for verification. The system provides an 
interface for Operators to upload the file, which is then parsed to extract candidate information. The extracted data is 
automatically compared against predefined job requirements.

#### Understanding: 

* The Operator is responsible for uploading the text file with candidate data, which the system will then parse and validate. 
This process ensures that all candidate information is correctly captured and verified against the job requirements.

#### Dependencies: 

1. **US 2003 - As Operator, I want to generate and export a template text file to help collect data fields for candidates of 
a job opening (so the data is used to verify the requirements of the job opening)**

US 2003 generates a template text file that outlines the data fields required for candidates. This template, which initially does
not contain any responses, is used by candidates to fill in their information. In US 2004, the operator uploads this now completed 
text file, which was previously generated by US 2003 and filled out by the candidate, for verification purposes.

2. **US 1002 - As Customer Manager, I want to register a job opening.**

US 1002 allows Customer Managers to register job openings, which are then used to define the requirements for candidates. The
requirements are used to evaluate candidate applications, which are uploaded by Operators in US 2004.

3. **US 2002 - As Operator, I want to register an application of a candidate for a job opening and import all files received.**

US 2002 enables Operators to register candidate applications for job openings. These applications will be listed so that the 
completed file can later be associated with the corresponding application.

4. **US 1005 - As Customer Manager, I want to list all applications for a job opening.**

US 1005 allows the Customer Manager to list all applications for a specific job opening. This is crucial for US 2004, as it 
enables the operator to select the correct application for verification.

#### Acceptance Criteria:

AC 2004.1: The system should validate the syntax of the uploaded text file against the predefined template structure. If the 
syntax is incorrect, the system should reject the file and provide a clear error message indicating the specific issues, ensuring
that the operator can correct and re-upload the file. (based on question 180 and 223)

AC 2004.2: The system should ensure that each uploaded text file is associated with a specific job application. The file must
be linked to the candidate’s application for a particular job opening. 

AC 2004.3: Upon successful validation of the uploaded text file, the system should create a folder named with the identifier 
of the corresponding job application. The system must then move the validated file into this newly created folder. This ensures
proper organization and association of candidate requirements with the relevant job applications. If the file validation fails, 
the system should not create the folder or move the file, providing feedback to the operator to resolve any issues before 
proceeding.

AC 2004.4: The system should only list the Job Openings that are in the screening phase, as it is during this phase that 
it is verified whether the candidates meet the requirements. (based on question 228)

#### Input and Output Data

*Input Data:*

* Selection Data :
  * Job opening
  * Job application
* Insert Data:
  * The file path

*Output Data:*
* Confirmation message about the syntax validation
* (In)Success message of the operation


## 3. Analysis

* Use case 2004: Our domain model satisfies the requirements of the aforementioned use case, ensuring that Operators
  can effectively upload a text file. For that we are interacting with the JobApplication Aggregate, by adding a file to 
  the list of files of the JobApplication.
* See the domain model in: [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)

## 4. Design

### 4.1. Realization (Sequence Diagram) 

For this user story, I decided to create two sequence diagrams that represent the interaction between the operator and the system. 
The first diagram represents the interaction of the UI with the RequirementSpecificationModel_Ex1 when the method isFileSyntaxCorrect(filePath) 
returns true. The second diagram represents the interaction of the UI with the RequirementSpecificationModel_Ex1 when the method 
isFileSyntaxCorrect(filePath) returns false. This way, we can clearly visualize what happens when the file is valid and when the 
file is invalid.

#### 4.1.1. Sequence Diagram 1 - File is valid

![sequence_diagram_us2004_falseversion-_size_20_Sequence_Diagram_US_2004___True_Version__size_.svg](svg%2Fsequence_diagram_us2004_falseversion-_size_20_Sequence_Diagram_US_2004___True_Version__size_.svg)

#### 4.1.2. Sequence Diagram 2 - File is invalid

![sequence_diagram_us2004_trueversion-_size_20_Sequence_Diagram_US_2004___True_Version__size_.svg](svg%2Fsequence_diagram_us2004_trueversion-_size_20_Sequence_Diagram_US_2004___True_Version__size_.svg)

### 4.2. Class Diagram

For UC 2004, the decision to omit a separate class diagram from the documentation is based on the principles of Domain-Driven
Design (DDD). Duplicating class information from the domain model would introduce redundancy. By directly utilizing the domain
model, clarity and efficiency are maintained in the documentation process while ensuring alignment with the project's evolving
domain understanding. Therefore, to see how the Class Diagram for this User Story would look, you simply need to look at the
Domain Model and see the Job Application Aggregate and its specially with the FileJobApp (This is where the files we will 
upload will be stored) and the JobOpening (We are uploading a requirement file, for an application in a specific Job Opening).

### 4.3. Applied Patterns 

### 4.3. Applied Patterns

* **Service Layer:** The Service Layer pattern is applied to the `FileService`class. This class handle the business logic 
related to file operations. This pattern encapsulates business logic and transactions, providing a simplified interface to 
the client and promoting loose coupling between the presentation and data access layers.

* **Factory Pattern:** The Factory Pattern is applied implicitly within the repository and service initialization, where 
instances of repositories are created using specific factory methods or configuration settings. This pattern helps in creating 
objects without exposing the instantiation logic to the client and allows referring to the newly created object using a common 
interface.

* **SOLID Principles:** Some of the SOLID principles are applied throughout the design of the classes, ensuring that they 
are well-structured and maintainable.
  * **Single Responsibility Principle (SRP):** Each class has a single responsibility. For example, `FileService` handles 
  file-related operations.
  * **Open-Closed Principle (OCP):** Classes are open for extension but closed for modification. For instance, new methods
  can be added to `FileService` without altering existing ones, allowing the system to evolve without breaking existing 
  functionality.
  
### 4.2. Tests 

Unit tests were deemed unnecessary as domain concepts had been thoroughly tested. Current operations involve manipulation
of existing domain instances, minimizing the need for additional testing.

## 5. Implementation

### Main classes created 

* 'UploadRequirementsFileUI': Responsible for the user interface for the candidate requirements file upload functionality. 
Manages the main file upload flow, including job opening and application selection, file syntax verification, and moving the 
file to the appropriate directory.

* 'FileService': Responsible for services related to files, such as creating directories and moving files. It has several 
functions including creating a directory for the job opening if it does not exist, moving the file to the job opening directory, 
creating a directory for the job application within the job opening directory if it does not exist, and moving the file to 
the job application directory within the job opening directory.

* 'UploadFileController': Coordinates the business logic related to the upload of candidate requirements files. It has several 
functions including retrieving all job openings from the repository and returning a list, retrieving a job opening by its 
index in the list of all job openings, retrieving all applications for a given job opening from the repository and returning 
a list, retrieving an application by its index in the list of all applications for a given job opening, and creating a new 
FileJobApp with the provided path, saving it to the database, and associating it with the given application.

## 6. Integration/Demonstration 

After filling out the template file generated by US2003 (see [readme.md](../..//Sprint%20B/us_2003/readme.md)), the Operator 
submits the file into the system. To insert the file into the system, we should run the program and start the session as an 
operator (username: operator1@this.app, password: operatorA1, for example) and then select the settings option and choose the option to
upload (option 5). Then we have to input the information that the system prompts us for, including the selection of the job
opening and the job application to which the file refers, the file's path, and whether or not we want to confirm the operation. 
After entering the data, the system will verify if the file is correct syntactically, and if it is, it will create a folder with 
the name of the job application and move the file there.

## 7. Observations 

N/a
