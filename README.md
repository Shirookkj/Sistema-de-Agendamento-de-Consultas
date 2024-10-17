# Sistema de Agendamento de Consultas

Este projeto é um Sistema de Agendamento de Consultas em Java que permite o cadastro de pacientes e médicos, agendamento de consultas, verificação de disponibilidade e geração de relatórios. Ele foi desenvolvido utilizando conceitos de Programação Orientada a Objetos (POO).

## Funcionalidades

- Cadastrar Pacientes: Permite criar novos registros de pacientes com nome, idade e CPF.
- Cadastrar Médicos: Permite criar novos registros de médicos com nome, CRM, especialidade e disponibilidade.
- Agendar Consultas: Os pacientes podem agendar consultas com médicos disponíveis em uma determinada especialidade.
- Gerar Relatório de Consultas: Gera relatórios detalhados das consultas agendadas.
- Listar Consultas por Paciente: Permite visualizar todas as consultas agendadas para um paciente específico.

## Estrutura do Projeto

### 1. Main.java
- Arquivo principal que gerencia o fluxo do sistema.
- Cria listas de pacientes, médicos e consultas.
- Apresenta um menu interativo para escolher opções como:
  - Cadastro de pacientes.
  - Cadastro de médicos.
  - Agendamento de consultas.
  - Geração de relatórios de consultas.
  - Listagem de consultas por paciente.
- Usa as classes Paciente, Medico, e Consulta para operar sobre os dados.

### 2. Paciente.java
- Classe que representa um paciente.
- Armazena informações como nome, idade e CPF.
- Principais métodos:
  - Getters e Setters para acessar e modificar os dados do paciente.
  - toString: Método que retorna uma representação textual do paciente.

### 3. Medico.java
- Classe que representa um médico.
- Armazena informações como nome, CRM, especialidade e disponibilidade.
- Principais métodos:
  - Getters e Setters para acessar e modificar os dados do médico.
  - toString: Método que retorna uma representação textual do médico.

### 4. Consulta.java
- Classe que representa uma consulta agendada.
- Armazena informações sobre o paciente, médico e a data da consulta.
- Principais métodos:
  - Getters para acessar os dados da consulta.
  - toString: Método que retorna uma representação textual da consulta.
