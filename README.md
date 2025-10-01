# Sistema de Cautelas

## Descrição do Projeto

Este projeto é um sistema em Java para o gerenciamento de materiais e cautelas. Ele visa controlar o inventário de itens, registrando a entrada, saída (cautela) e o saldo de materiais, garantindo a organização e o controle de ativos.

## Tecnologias Utilizadas

    Linguagem de Programação: Java

    Banco de Dados: PostgreSQL

    Gerenciador de Dependências: Maven

    Driver de Conexão: PostgreSQL JDBC Driver

## Estrutura do Banco de Dados

O sistema utiliza um banco de dados PostgreSQL com duas tabelas principais, conectadas por uma chave estrangeira.

## Tabela materiais

Armazena informações sobre os materiais disponíveis.
| Coluna | Tipo de Dado | Descrição |
| :--- | :--- | :--- |
| id | SERIAL (PK) | Chave primária, auto-incrementada. |
| material | VARCHAR(150) | Nome do material. |
| tipo | VARCHAR(25) | Categoria do material. |
| disponivel | BOOLEAN | Indica se o material está em estoque (TRUE) ou não (FALSE). |
| previsto | INTEGER | Quantidade prevista em estoque. |
| existente | INTEGER | Quantidade existente em estoque. |
| data_registro | DATE | Data de registro do material. |

## Tabela registros_cautela

Registra cada operação de cautela dos materiais.
| Coluna | Tipo de Dado | Descrição |
| :--- | :--- | :--- |
| id | SERIAL (PK) | Chave primária, auto-incrementada. |
| material_id | INTEGER (FK) | Chave estrangeira que referencia o id da tabela materiais. |
| quantidade | INTEGER | Quantidade de itens envolvidos na cautela. |
| data_cautela | DATE | Data em que a cautela foi realizada. |
| observacao | VARCHAR(255) | Observações adicionais sobre a cautela. |

## Configuração do Ambiente

Para rodar este projeto localmente, siga os passos abaixo:

### Pré-requisitos

    Java Development Kit (JDK) 21 ou superior

    Apache Maven

    Servidor PostgreSQL

### 1. Clonar o Repositório

Bash

    git clone https://github.com/alejandro-s23/SiGeMa.git
    cd Cautelas

### 2. Configurar o Banco de Dados

  Inicie o seu servidor PostgreSQL.

  Crie um novo banco de dados chamado cautelasDB e um usuário com permissões de acesso.
    SQL
 
      CREATE DATABASE "cautelasDB";
      CREATE USER [SEU_USUARIO] WITH PASSWORD '[SUA_SENHA]';
      GRANT ALL PRIVILEGES ON DATABASE "cautelasDB" TO [SEU_USUARIO]";

  Execute os scripts SQL para criar as tabelas materiais e registros_cautela.

### 3. Configurar a Conexão no Projeto

Abra o projeto no seu IDE e configure as credenciais de conexão com o banco de dados no arquivo de configuração apropriado (por exemplo, application.properties ou em uma classe de utilidade de conexão).

### 4. Rodar o Projeto

Execute o projeto a partir do seu IDE ou usando o Maven:
Bash

    mvn clean install
    mvn exec:java

Autor

    Alejandro Souza dos Santos
