# US G004 - As Project Manager, I want the team to setup a continuous integration server.

## 1. Context

* On this User Story we are setting up a continuous integration server to help on team organization and project management.

### 1.1. User Story Description

TO DO

### 1.2. Customer Specifications and Clarifications

* Question: "Relativamente ao continuous integration server, o workflow irá
  ter de ser executado a cada push ou uma vez por dia, à noite?"
    * Answer: "Resposta rápida: sempre que há um push para o “main”. O processo executado pelo
      CI a cada push não pode exceder 2 minutos. O processo deve conseguir “compilar” o
      sistema, executar testes e publicar resultados sem “erros”, ou seja, não deve falhar por
      erros de “compilação”. No caso de haverem falhas o “responsável” pela falha (autor do
      commit/push) deve justificar a falha (por exemplo, justificando na sua área da
      documentação do repositório)."

## 2. Requirements

**US G004** As Project Manager, I want the team to setup a continuous integration server.

**Dependencies/References:**

*GitHub Actions/WorkFlows should be used.*

## 3. Observations

* We used Github Workflows as solicited, and configure a maven type workflow to execute everytime that exists a push on main branch and everyday at a specify hour (we choose 2AM).
* Check **.github/workflows/maven.yml** to see implementation details