# US 2003 - As Operator, I want to generate and export a template text file to help collect data fields for candidates of a job opening (so the data is used to verify the requirements of the job opening)

## 1. Context

### 1.1. Customer Specifications and Clarifications


* Question 15: "É o Operador que regista uma candidatura ou é o sistema que
  o faz automaticamente? E como integra o “plugin” de verificação da
  candidatura neste processo?"
    * Answer 15: "Na US 2002 o Operator regista a candidatura. Para isso, é o Operator que inicia o
      processo mas o sistema deve importar os dados resultantes do Application File Bot de
      forma “automática” (Ver References da US 2002). O plugin referido entre neste processo
      através da US 2003, em que o Operador gera um ficheiro template com os dados a
      introduzir para validar uma candidatura. Na US 2004, o Operador, após preencher os
      dados específicos da candidatura (com base no ficheiro template anterior) submete no
      sistema esse ficheiro que vai ser usado para o sistema avaliar/verificar a candidatura. Se
      os critérios não forem atingidos a candidatura é recusada."

* Question 101: US2003 – Quais são os campos/informação que têm de ser extraídos do candidato para verificar os requisitos 
de uma job opening? 
    * Answer 101: Vai depender do que estiver desenhado/especificado no modelo de Requirements Specification usado para esse 
  job opening.

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
You've stated in Q15, Q102 and Q119, that US2003 simply generates the file, while in US2004 the Operator defines the 
answers and uploads the file. Where is this file uploaded to? Given this, where is the usage of ANTRL in US2003 directed to?
    * Answer 132: Regarding the first question, although difficult it is possible to generate the template text file using 
  ANTLR. If so, there we have the usage o ANTLR. Although, unless there is some specific evaluation requirement from LPROG, 
  it is acceptable that the template file is hardcoded in the plugin (no need for any “complex” generation process/function). 
  Regarding the second question, the file is uploaded to the system. The last question was answered first.

## 1.2. Explanation

* This user story introduces a new feature request for Operators to generate and export a template text file aimed at 
collecting data fields for candidates of a job opening.
* Unlike previous sprints, this task has not been assigned or completed yet; it represents a fresh addition intended to 
enhance the system's functionality. There are no existing bugs associated with this task; it involves implementing a new 
feature.

## 2. Requirements

* US 2003 - As Operator, I want to generate and export a template text file to help collect data fields for candidates of a job opening (so the data is used to verify the requirements of the job opening)

#### Use Cases:

* This user story will encompass use cases 2003 according to the data present in the specifications document
  ([Specifications_Document.md](..%2F..%2FGeneral%20Documentation%2FUse%20Case%20Diagram%2FSpecifications_Document.md))).

#### Functionality:

* This user story involves implementing a feature that enables Operators to generate and export a template text file tailored 
to collect data fields for candidates applying for a job opening.

#### Understanding:

* Operators need a tool to systematically gather specific data fields from candidates to verify if they meet the requirements 
of a job opening. The generated template text file should contain fields aligned with the job requirements, such as skills, 
qualifications, experience, and any other pertinent information necessary for evaluation. By having a structured template, 
Operators can efficiently collect and organize candidate data, facilitating the assessment process and ensuring that candidates 
meet the job opening's requirements effectively.

#### Dependencies:

1. **US 1008 - As Language Engineer, I want to deploy and configure a plugin (i.e., Job Requirement Specification or Interview 
Model) to be used by the system.** The ability to generate and export a template text file for collecting data fields for 
candidates of a job opening may rely on the deployment and configuration of a plugin, such as the Job Requirement Specification 
plugin. Without the proper deployment and configuration of the plugin, the system may lack the necessary functionality to 
support this feature effectively.

2. **US 1009 - As Customer Manager, I want to select the requirements specification to be used for a job opening.** Before 
generating and exporting a template text file for collecting data fields for candidates, a requirements specification must 
be selected for the job opening. The chosen requirements specification will dictate the data fields that need to be collected 
from candidates during the recruitment process.

3. **US 2000a - As Operator, I want to register a candidate and create a corresponding user.** In order to generate and export 
a template text file for collecting data fields for candidates of a job opening, candidates must be registered in the system. 
The process of registering candidates and creating corresponding user profiles is essential for collecting and managing candidate 
data effectively.

4. **US 1002 - As Customer Manager, I want to register a job opening.** The functionality to generate and export a template
text file for collecting data fields for candidates is closely linked to the existence of registered job openings. Before
initiating the recruitment process and creating templates, job openings need to be registered in the system to provide context
for data collection and verification.

#### Acceptance Criteria: ----------------falta

* AC 2003: The system must allow Operators to generate and export a template text file for requirements specification.


#### Input and Output Data ----------------falta

*Input Data:*

* Typed data:
  * N/A

*Output Data:*
* Template text file containing predefined fields or prompts for collecting candidate answers during interviews.

## 3. Analysis

* Use case 2003: Our domain model satisfies the requirements of the aforementioned use case, as when generating a template text
  file for Requirement Specification, we will interact solely with the job opening aggregate and the Requirement Specification 
 aggregate.
* See the domain model in: [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)


## 4. Design

### 4.1. Realization (Sequence Diagram)

![sequence_diagram_US2003-_size_20_Sequence_Diagram_US_2003__size_.svg](svg%2Fsequence_diagram_US2003-_size_20_Sequence_Diagram_US_2003__size_.svg)

### 4.2. Class Diagram

For UC 2003, the decision to omit a separate class diagram from the documentation is based on the principles of Domain-Driven
Design (DDD). Duplicating class information from the domain model would introduce redundancy. By directly utilizing the
domain model, clarity and efficiency are maintained in the documentation process while ensuring alignment with the project's
evolving domain understanding. [domain_model_v4.puml](..%2F..%2FGeneral%20Documentation%2FDomain%20Model%2Fdomain_model_v4.puml)

### 4.3. Applied Patterns 

N/A

### 4.4. Tests

Unit tests were deemed unnecessary as domain concepts had been thoroughly tested. Current operations involve manipulation
of existing domain instances, minimizing the need for additional testing.

## 5. Implementation

### Main classes created 

This code defines a class named GenerateRSTemplateUI within the PluginManagement package. It extends AbstractUI from the EAPLI framework.

Within the class, there is a field named requirementsSpecification of type JobRequirementsSpecification_EX1.

In the doShow() method, it prints a message indicating the generation of a Requirement Specification Template and then calls the generateTemplate() method of the JobRequirementsSpecification_EX1 class.

The headline() method returns a string "Generate Requirement Specification Template".

In summary, this class represents a user interface component responsible for generating a Requirement Specification Template.


## 6. Integration/Demonstration 

1. Execute the `build-all` and `run-bootstrap` scripts to initialize the system.
2. Launch `run-backoffice` and log in as an Language Engineer (e.g., Username: operator1, Password: operatorA1).
3. Access "2. Settings" and select "4. Generate a template text file for a requirement specification".


## 7. Observations 

Currently, as we possess only a single template for the requirements specification, this feature will streamline the process by 
automatically generating the template. Instead of presenting a list of available requirement specification templates and prompting 
the user to choose one, it simplifies the workflow by immediately creating the template.
