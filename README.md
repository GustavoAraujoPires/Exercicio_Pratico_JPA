🚀 Sistema de Pedidos – API REST com Spring Boot + JPA + Docker
📌 Descrição

Este projeto consiste em uma API REST desenvolvida com Java e Spring Boot, utilizando Spring Data JPA para persistência de dados e PostgreSQL como banco de dados, executado em um container Docker.

O sistema permite o gerenciamento de Clientes e Pedidos, aplicando relacionamento entre entidades e regras básicas de negócio.

🎯 Objetivo

O objetivo do projeto foi praticar:

Criação de API REST com Spring Boot

Mapeamento de entidades com JPA

Relacionamento entre tabelas

Uso de UUID como identificador

Integração com PostgreSQL

Execução do banco via Docker

Organização em arquitetura em camadas

🏗️ Estrutura do Projeto

O projeto foi organizado nas seguintes camadas:

Controller → Responsável por receber e responder requisições HTTP

Service → Contém as regras de negócio

Repository → Responsável pela comunicação com o banco de dados

Model (Entity) → Representação das tabelas

Essa estrutura foi utilizada para manter o código organizado e separar responsabilidades.

🐳 Banco de Dados com Docker

O banco de dados PostgreSQL foi executado via Docker.

Passos realizados:

Criação do container PostgreSQL

Definição de banco, usuário e senha

Exposição da porta 5432

Configuração da conexão no application.yml

O Hibernate está configurado para criar/atualizar as tabelas automaticamente.

🗂️ Modelagem

O sistema possui duas entidades:

Cliente

id (UUID)

nome

email

Pedido

id (UUID)

dataPedido

valorTotal

cliente

🔗 Relacionamento

Foi implementado o seguinte relacionamento:

Um Cliente pode ter vários Pedidos

Um Pedido pertence a um único Cliente

Configurações aplicadas:

Relacionamento bidirecional

FetchType.LAZY

Chave estrangeira na tabela de Pedido

📡 Funcionalidades
Cliente

Cadastrar cliente

Listar clientes

Buscar cliente por ID

Pedido

Criar pedido para cliente existente

Listar pedidos

Listar pedidos por cliente

Deletar pedido

📏 Regras Implementadas

Não é possível criar pedido para cliente inexistente

O valor do pedido deve ser maior que zero

O email do cliente é único

🧠 Conceitos Utilizados

Spring Boot

Spring Data JPA

Hibernate

UUID

Relacionamentos @OneToMany e @ManyToOne

Docker

PostgreSQL

Arquitetura em camadas

🚀 Como Executar

Subir o banco PostgreSQL via Docker

Códigos Usado para Criação:

#Comando para criar uma NetWork
docker network create pedido-network

#Rodar container Postgre na versão 16.3
docker run --name pedidosdb -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=Pedidos --network pedido-network postgres:16.3

#Rodar Pgadmin 4
docker run --name pgadmin4 -e PGADMIN_DEFAULT_EMAIL=admin@gmail.com -e PGADMIN_DEFAULT_PASSWORD=admin -p 15432:80 --network pedido-network dpage/pgadmin4:8.9

Executar a aplicação Spring Boot

Acessar a API em:

http://localhost:8080
👨‍💻 Autor

Gustavo Araujo Pires
Projeto desenvolvido para prática e consolidação de conhecimentos em backend com Java.
