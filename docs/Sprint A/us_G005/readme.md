# US G005 - As Project Manager, I want the team to add to the project the necessary scripts, so that build/executions/deployments/... can be executed effortlessly.

## 1. Context
### 1.1. User Story Description

This requirement holds significant importance for our project as it enables us to build, execute, and deploy our project effectively.

### 1.2. Customer Specifications and Clarifications

* Question: "Relativamente à G005, os scripts que são referidos são apenas de build e testes?"
    * Answer: "Eu diria que nesta fase (sprint A) possivelmente os scripts remetem apenas para construir as aplicações, executar testes e executar as aplicações. No entanto, a ideia é que consigam manter um conjunto de scripts que permitam a cada momento fazer as operações mais comuns de forma simplificada e fora do IDE. Mais à frente isso torna-se mais importante quando tiverem de preparar, por exemplo, “deployments” mais complexos."

## 2. Requirements

US G005 - As Project Manager, I want the team to add to the project the necessary scripts.

* G005.1. The project needs to be buildable.

* G005.2. The project needs to be executable.

* G005.3. The project needs to be deployable.


## 3. Implementation

* We add the build instructions on the pom.xml file of every app to define the main class when we execute them out the IDE after the build.
* The **build-all.sh** allows the build of the whole project.
* The **execute-jobs4u-app1.sh** allow the execution of App 1.
* The **execute-jobs4u-app2.sh** allow the execution of App 2.
* We include EAPLI Base Project on our project. We also adapt the provided scripts to run well on our project.


## 4. Observations

N/A