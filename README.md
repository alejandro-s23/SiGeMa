# Sistema de Gerenciamento de Material (SiGMa)


## Descrição do Projeto

Este projeto é um sistema em Java para o gerenciamento de materiais e cautelas. Ele visa controlar o inventário de itens, registrando a entrada, saída (cautela) e o saldo de materiais, garantindo a organização e o controle de ativos.
Como é um dos meus primeiros projetos, pode conter alguns bugs, fique a vontade para entrar em contato comigo para relatar os bugs!

## Tecnologias Utilizadas

    Linguagem de Programação: Java, Bash/Shell

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
| previsto | INTEGER | Quantidade prevista em estoque. |
| existente | INTEGER | Quantidade existente em estoque. |
| sit_carga | BOOLEAN | Material está documentado?. |
O valor de saldo e de quantidade de material cautelado é armazenado internamente no programa!

## Tabela cautelas

Registra cada operação de cautela dos materiais.
Por se tratar de um sistema utilizado no âmbito militar, ele possui algumas particularidades como a coluna "pg".
| Coluna | Tipo de Dado | Descrição |
| :--- | :--- | :--- |
| id | SERIAL (PK) | Chave primária, auto-incrementada. |
| material_id | INTEGER (FK) | Chave estrangeira que referencia o id da tabela materiais. |
| quantidade | INTEGER | Quantidade de itens envolvidos na cautela. |
| data_cautela | DATE | Data em que a cautela foi realizada. |
| pg | VARCHAR(10) | Posto/Graduação do militar que cautelou o material |
| nome | VARCHAR(50) | Nome do militar que cautelou o material |
| obs | VARCHAR(255) | Observações adicionais sobre a cautela. |
| sit_caut | BOOLEAN | Armezena se a cautela ainda está aberta ou encerrada |
| data_descautela | DATE | Data em que foi feita a descautela |
| descautelado | INTEGER | Quantas unidades já foram descauteladas |

## Configuração do Ambiente

Para rodar este projeto localmente, siga os passos abaixo:

### Pré-requisitos

    Java Development Kit (JDK) 21 ou superior

    Apache Maven

    Servidor PostgreSQL

    Sistema Operacional: Ubuntu (distros Ubuntu)
    
#### O Instalador fará a instalação as ferramentas necessárias para a execuçãodo programa!

### 1. Baixar a release mais recente

Entre na aba de releases e baixe o arquivo .zip nela.

### 2. Extrair o arquivo

  Após baixado o .zip, extraia ele no diretório que deseja instalar o SiGMa.
  
### 3. Conceder permissões

 Abra o terminal no diretório "instalador" e cole as seguintes linhas de comando:
 
 Bash

    chmod +x *sh
    ./Instalar\ SiGMa.sh

Ao executar esse comando você autorizou os arquivos .sh à serem executados, e o outro comando executará o instalador das dependências do SiGMa.

### 4. SiGMa

Bash

    ./SiGMa.sh

Este comando por fim iniciará o programa!!

### Futuras Implementações

Por motivos de agenda, ainda não consegui implementar tudo que gostaria no programa, então deixarei abaixo, uma lista das minhas ideias para o programa:
#### Sistema de login utilizando arquivos criptografados

Funcionará da seguinte maneira, o programa terá um menu que criará um arquivo criptografado com o "usuário" e "senha" para a conexão no banco de dados, do mesmo jeito que ele saberá ler esse arquivo.

#### Sistema para excluir materiais inseridos por engano ou depejados

Para completar o CRUD, será adicionado um menu para excluir os materiais não desejados, sob a condição de não haver nenhum material cautelado

#### Menu para listar cautelas por filtros

Como forma de auxiliar na procura de cautelas específicas, futuramente será adicionado um menu específico que exibirá as cautelas baseadas em um filtro escolhido pelo usuário.

#### Correção do bug de largura da janela

Atualmente se você inserir um material com um nome muito longo os campos irão sair da janela e impedirá de executar certas ações.

Autor

    Alejandro Souza dos Santos
