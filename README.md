
# 🚗 Vehicle Rental System  
## Arquitetura Microkernel com Plugins

---

## 📌 Visão Geral

Este projeto foi desenvolvido em **contexto acadêmico**, com o objetivo de aplicar, de forma prática, conceitos avançados de **arquitetura de software**. A solução adota o padrão **Microkernel (Plug-in Architecture)**, aliado ao uso de **interfaces**, **modularização**, **persistência em banco de dados**, **containerização com Docker** e **interface gráfica com JavaFX**.

A aplicação foi projetada para ser **extensível, desacoplada e modular**, permitindo que funcionalidades completas sejam adicionadas, removidas ou substituídas **sem impactar o núcleo do sistema** ou outros módulos independentes.

---

## 🧠 Arquitetura do Projeto

O sistema segue o padrão **Microkernel**, no qual:

- O **núcleo (core)** é mínimo, estável e independente de regras de negócio
- As funcionalidades do sistema são implementadas como **plugins**
- Cada plugin implementa **interfaces previamente definidas**
- Os plugins são **independentes entre si**
- A remoção ou adição de um plugin **não compromete os demais**

### Benefícios da Arquitetura:
- Baixo acoplamento
- Alta coesão
- Facilidade de manutenção
- Evolução incremental do sistema
- Extensibilidade sem refatoração do core

---

## 🧩 Plugins Implementados

### 🔹 Rental Plugin — Alocação de Veículos

O **Rental Plugin** foi o primeiro e principal módulo desenvolvido, sendo responsável por implementar todo o **fluxo de locação de veículos** do sistema.

#### Funcionalidades:
- Implementação das interfaces fornecidas pelo core
- Comunicação direta com a camada de persistência
- Execução de comandos SQL para operações de aluguel
- Inserção e manipulação de dados no banco de dados

Este plugin representa o **fluxo central da aplicação**, tornando o sistema funcional como uma solução de locação de veículos.

---

### 🔹 Relatório 1 — Gráfico de Pizza (JavaFX)

Plugin responsável pela geração de um **gráfico de pizza**, que apresenta a **distribuição de veículos por tipo de combustível**.

#### Características:
- Desenvolvido com **JavaFX**
- Consumo direto de dados do banco via SQL
- Processamento dinâmico das informações
- Construção do gráfico utilizando componentes nativos do JavaFX

---

### 🔹 Relatório 2 — Tabela Geral (JavaFX)

O **Relatório 2** é um plugin independente que exibe uma **tabela consolidada** com informações gerais do sistema.

#### Características:
- Implementado com **JavaFX (TableView)**
- Consumo de dados via comandos SQL
- Exibição organizada e estruturada dos dados
- Totalmente desacoplado dos demais plugins

Assim como os outros módulos, sua remoção **não impacta** o funcionamento do Rental Plugin ou do core.

---

## 🗄️ Banco de Dados

- **Banco de dados:** MariaDB  
- Executado em **contêiner Docker**
- Estrutura e dados facilmente reproduzíveis em qualquer ambiente

### Vantagens da Dockerização:
- Ambiente padronizado
- Independência do banco local do desenvolvedor
- Facilidade de testes, execução e avaliação
- Reprodutibilidade total do ambiente

---

## 🐳 Docker

O banco de dados MariaDB é inicializado utilizando **Docker Compose**, garantindo que:

- Não seja necessária instalação local do banco
- O ambiente seja idêntico em qualquer máquina
- A execução do projeto seja simples e previsível

---

## ⚙️ Maven

O **Apache Maven** é utilizado para:

- Gerenciamento de dependências
- Organização do ciclo de vida do projeto
- Compilação e empacotamento da aplicação
- Padronização do processo de build

---

## 🖥️ Interface Gráfica

- Desenvolvida em **JavaFX**
- Utilizada principalmente nos plugins de relatório
- Responsável pela visualização gráfica dos dados
- Integrada diretamente ao banco de dados via SQL

---

## 🧪 Tecnologias Utilizadas

- **Java**
- **JavaFX**
- **MariaDB**
- **Docker**
- **Docker Compose**
- **Apache Maven**
- **Arquitetura Microkernel**
- **Interfaces e Plugins**
- **SQL**

---

## ▶️ Compilação e Execução

### 📂 Diretório de Execução

⚠️ **Todos os comandos devem ser executados a partir do diretório `microkernel`:**

### Subir o banco de dados
```bash
docker compose up -d
A senha do banco: mariadb09
````

### Compilar o projeto

```bash
mvn clean install
```

### Executar a aplicação

```bash
mvn -pl app exec:java
```

### Fluxo resumido

1. Acessar o diretório `microkernel`
2. Subir o banco com `docker compose up -d`
3. Compilar o projeto com `mvn clean install`
4. Executar a aplicação com `mvn -pl app exec:java`

---

## 📚 Considerações Finais

Este projeto demonstra, de forma prática, a aplicação de conceitos essenciais de **engenharia de software**, como modularidade, desacoplamento, arquitetura baseada em plugins e integração entre diferentes tecnologias.

A arquitetura adotada permite a **evolução contínua do sistema**, possibilitando a criação e integração de novos plugins **sem a necessidade de alterações no núcleo da aplicação**, evidenciando os benefícios do padrão **Microkernel** em sistemas reais.

---
