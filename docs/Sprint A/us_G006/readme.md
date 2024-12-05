# US G006 - As Project Manager, I want the team to elaborate a Domain Model using DDD.

## 1. Context
### 1.1. User Story Description

In this US we were asked to develop a Domain Model which is essential for the project design, using DDD.

### 1.2. Customer Specifications and Clarifications

* Question: "Qual a distinção entre Company e Entity?"
    * Answer: "Quando no enunciado aparece a referência a entity é no sentido de podermos ter clientes da Jobs4u que podem não ser empresas, podem ser outro tipo de organizações."

* Question: "Por cada Customer, apenas existe um “representante” que acede à conta (i.e., Customer App)?"
    * Answer: "Sim, parece-me suficiente."

* Question: "O Admin é responsável por gerir apenas Customer managers ou outros, como por exemplo Operators? E qual o significado dessa responsabilidade?"
  * Answer: "A ideia é que o Admin fará a gestão desses utilizadores (e no limite também dos Operators). Na prática, as US que remetem para essas funcionalidades, podem ser “substituidas” por um processo de “bootstrap” que faça inicializações na base de dados para suportar esses utilizadores/papeis (tal como mencionado no texto das US)."

* Question: "No enunciado não está explicita a informação a recolher para os Customers? Qual a informação necessária? E quando aos funcionários da empresa?"
  * Answer: "De facto isso não está explicito. No entanto, são referidos no nome da empresa e o seu endereço no âmbito de um job opening. Quanto aos utilizadores (representante da empresa que acede à Customer App) eu diria que serão dados similares ao do Candidate. Quando aos funcionários da empresa, eu diria que é importante garantir que é usado o email para identificar qualquer utilizador do sistema. Penso que será importante para cada utilizador termos o nome completo assim como um short user name (que deverá ser único). Actualização em 2024-03-21: O Product Owner reconsiderou e decidiu que o short user name é dispensável uma vez que para autenticação dos utilizadores se deve usar apenas o email e a password."

* Question: "Qual a distinção entre especificação de requisitos e de entrevistas?"
  * Answer: "O “estilo” das perguntas e respostas é similar, mas nos requisitos o objetivo é avaliar o candidato e ver se tem os mínimos ou não, portanto o resultado será sim ou não. Nas entrevistas a ideia é classificar/pontuar cada resposta de forma a no final ter pontuações diferentes para os candidatos e assim ajudar a fazer o seu ranking."

* Question: "Um customer manager pode gerir vários clientes?"
  * Answer: "Sim."

* Question: "Quem informa o Customer manager do tipo de entrevista/perguntas?"
  * Answer: "Isso pode ser obtido pelo Customer manager em dialogo com o Customer. Depois disso, com a ajuda do Language engineer é elaborado o suporte para a entrevista."

* Question: "Uma pessoa poderá ter vários papeis no sistema?"
  * Answer: "Será muito difícil controlar que uma pessoa não consegue ter mais do que uma forma de acesso ao sistema (por exemplo, uma pessoa que é Customer Manager poderá ser, no limite, também uma candidato a uma oferta de emprego). Relativamente aos papéis “internos” eu diria que devemos considerar uma hierarquia de acessos. O Admin pode fazer “tudo” o que os outros fazem. Segue-se o Customer Manager e por último o Operator."

* Question: "Relativamente ao Job Opening (secção 2.2.2), o job reference refere que deve ser gerado pelo sistema a partir de um customer code. O que é este customer code e se existe alguma regra para a sua criação?"
  * Answer: "Eu dira que qualquer customer terá de ter um código identificativo (único) que poderá ser uma espécie de abreviatura do seu nome. Com um número limitado de caracteres. Por exemplo, para o cliente Instituto Superior de Engenharia do Porto, o customer code poderi ser ISEP e não poderia haver mais nenhum customer com este customer code. Um limite razoável seria talvez 8 a 10 carateres. Podemos definir 10. Este código é introduzido manualmente na criação do customer no sistema."


## 2. Requirements

* It is required to create and consistently update a domain model. This model should be incorporated into the technical documentation within the repository.

* NFR02 - Technical Documentation Project documentation should be always available on the project repository ("docs" folder, markdown format) and, when applicable, in accordance to the UML notation. The development process of every US (e.g.: analysis, design, testing, etc.) must be reported (as part of the documentation).


## 3. Analysis

* In order to address this User Story, your team will commence by thoroughly examining the System Specification of the project and compiling a glossary containing the key components.
* Subsequently, these components will be integrated into the Domain model and interconnected in alignment with the System Specification.
* Finally, the aggregates will be created to consolidate the components effectively.

## 4. Design

TO DO

### 4.1. Realization

#### [Glossary](../../General%20Documentation/Domain%20Model/glossary.md)


#### Domain Model

![domain_model.svg](svg%2Fdomain_model.svg)



## 5. Implementation

N/A


## 6. Integration/Demonstration

N/A


## 7. Observations

N/A 