# Sistema de lançamento de notas

## O desafio

Carlos é um professor que precisa organizar as notas e a frequência de seus alunos. Cada aluno tem uma nota para cada uma das cinco disciplinas que Carlos ensina e
um registro de presença para cada aula. Crie um sistema onde Carlos possa inserir as notas de cada aluno (0 a 10) nas cinco disciplinas e a frequência de cada
aluno em percentual (0 a 100%). O sistema deve calcular automaticamente a média das notas de cada aluno, a média da turma em cada disciplina e a frequência geral
de cada aluno. Além disso, o sistema deve permitir que Carlos veja quais alunos têm uma média de notas acima da média da turma e quais alunos têm uma frequência
abaixo de 75%, pois esses alunos precisam de atenção especial.

## Premissas e decisões do projeto
1 - O projeto foi desenvolvido utilizando Spring Boot para facilitar a criação de aplicações web.

2 - O banco de dados utilizado é um banco relacional, configurado para armazenar informações de alunos, notas e frequências.

3 - O sistema foi projetado para ser simples, focado no cadastro e análise de notas e frequência dos alunos.

4 - A interface do usuário utiliza Thymeleaf, permitindo a renderização dinâmica dos dados no frontend.

5 - Maven como gerenciador de dependências: Para facilitar a organização e atualização das bibliotecas utilizadas.

## O Que Mais Você Precisa Saber

1 - O sistema possui uma funcionalidade para excluir alunos, garantindo que os dados possam ser gerenciados dinamicamente.

2 - Há um cálculo automático da média geral da turma, permitindo uma melhor análise de desempenho dos alunos.

3 - O projeto pode ser expandido para incluir funcionalidades como exportação de relatórios e autenticação de usuários.

## Como Abrir e Rodar o Projeto Spring Boot


Este documento explica passo a passo como abrir e rodar o projeto Spring Boot, mesmo que você nunca tenha programado antes.

### 1. Instalar os Pré-requisitos

Antes de começar, você precisa instalar alguns programas no seu computador:

#### a) **Java (JDK 17 ou superior)**

O Spring Boot precisa do Java para funcionar.

1. Baixe o Java Development Kit (JDK) pelo link: [[https://www.oracle.com](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
2. Instale seguindo as instruções do site.
3. Para verificar se a instalação foi concluída, abra o **Prompt de Comando (Windows)** ou **Terminal (Mac/Linux)** e digite:
   ```sh
   java -version
   ```
   Se aparecer algo como `java version "17.0.1"`, significa que deu certo!

#### b) **Maven (Ferramenta de Gerenciamento do Projeto)**

O Maven é necessário para baixar e gerenciar as dependências do projeto.

1. Baixe o Maven pelo link: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
2. Siga as instruções do site para instalar.
3. Para verificar a instalação, digite no terminal:
   ```sh
   mvn -version
   ```
   Se aparecer algo como `Apache Maven 3.x.x`, a instalação foi bem-sucedida!

#### c) **Banco de Dados (MySQL)**

O projeto utiliza um banco de dados relacional para armazenar as informações dos alunos.

1. **Usando MySQL:**

   - Baixe e instale o MySQL pelo link: [https://dev.mysql.com/downloads/](https://dev.mysql.com/downloads/)
   - Crie um banco de dados chamado `NotasBD`:
     ```sh
     CREATE DATABASE NotasBD;
     ```
   - No arquivo `application.properties` (localizado na pasta `src/main/resources`), configure a conexão:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:5432/NotasBD
     spring.datasource.username=postgres
     spring.datasource.password=sua_senha
     ```
   - Certifique-se de que o MySQL está rodando antes de iniciar o projeto.


#### d) **IntelliJ IDEA ou VS Code**

Esses são editores de código que facilitam trabalhar com o projeto.

- **IntelliJ IDEA:** [Baixar](https://www.jetbrains.com/idea/download/)
- **VS Code:** [Baixar](https://code.visualstudio.com/)

### 2. Baixar o Código do Projeto

Você pode baixar o código de duas maneiras:

1. **Baixar o ZIP**: Clique no botão de **Download ZIP** no repositório do GitHub.
   - Depois de baixar, extraia os arquivos para uma pasta no seu computador.
2. **Usar o Git (Opcional)**: Se tiver o Git instalado, digite no terminal:
   ```sh
   git clone https://github.com/julia-alessandra/Notas.git
   ```

### 3. Abrir o Projeto

1. **Abra o IntelliJ IDEA ou VS Code**
2. **Selecione a opção "Open"** e escolha a pasta do projeto.
3. **Espere o Maven baixar as dependências** (Isso pode demorar um pouco na primeira vez).

### 4. Rodar o Projeto

Agora que o projeto está pronto, vamos rodá-lo:

1. No IntelliJ, vá até a classe principal (`AlunoApplication.java`) e clique em **Run** (ou pressione `Shift + F10`).
2. Se estiver usando o terminal, digite:
   ```sh
   mvn spring-boot:run
   ```
3. Quando aparecer `Tomcat started on port 8080`, significa que o projeto está rodando!

### 5. Acessar no Navegador

Abra o navegador e digite na barra de endereços:

```
http://localhost:8080/Notas
```

Agora você pode interagir com o sistema!



