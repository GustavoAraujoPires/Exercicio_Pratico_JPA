🚀 Sistema de Pedidos

API REST com Spring Boot + JPA + Docker

📌 Sobre o Projeto

Este projeto é uma API REST desenvolvida com Java + Spring Boot, utilizando Spring Data JPA para persistência de dados e PostgreSQL executado via Docker.

O sistema permite o gerenciamento de:

👤 Clientes

📦 Pedidos

Aplicando relacionamento entre entidades e regras básicas de negócio.

🎯 Objetivo

O projeto foi desenvolvido para praticar:

✔ Criação de API REST

✔ Mapeamento de entidades com JPA

✔ Relacionamento entre tabelas

✔ Uso de UUID como identificador

✔ Integração com PostgreSQL

✔ Execução do banco via Docker

✔ Arquitetura em camadas

🏗️ Estrutura do Projeto

A aplicação está organizada da seguinte forma:

Controller
   ↓
Service
   ↓
Repository
   ↓
Banco de Dados
🔹 Controller

Responsável por receber e responder requisições HTTP.

🔹 Service

Contém as regras de negócio e validações.

🔹 Repository

Comunicação com o banco via Spring Data JPA.

🔹 Model (Entity)

Representação das tabelas.

🗂️ Modelagem
👤 Cliente

id (UUID)

nome

email

📦 Pedido

id (UUID)

dataPedido

valorTotal

cliente

🔗 Relacionamento

✔ Um Cliente pode ter vários Pedidos
✔ Um Pedido pertence a um único Cliente

Configurações aplicadas:

Relacionamento bidirecional

FetchType.LAZY

Chave estrangeira na tabela de Pedido

📡 Funcionalidades
👤 Cliente

Cadastrar cliente

Listar clientes

Buscar cliente por ID

📦 Pedido

Criar pedido para cliente existente

Listar pedidos

Listar pedidos por cliente

Deletar pedido

📏 Regras Implementadas

Não é possível criar pedido para cliente inexistente

O valor do pedido deve ser maior que zero

O email do cliente é único

🐳 Banco de Dados com Docker
🔧 Criar network
docker network create pedido-network
🗄️ Subir PostgreSQL (16.3)
docker run --name pedidosdb -p 5432:5432 \
-e POSTGRES_PASSWORD=postgres \
-e POSTGRES_USER=postgres \
-e POSTGRES_DB=Pedidos \
--network pedido-network \
postgres:16.3
🖥️ Subir PgAdmin 4
docker run --name pgadmin4 \
-e PGADMIN_DEFAULT_EMAIL=admin@gmail.com \
-e PGADMIN_DEFAULT_PASSWORD=admin \
-p 15432:80 \
--network pedido-network \
dpage/pgadmin4:8.9
🚀 Como Executar

1️⃣ Subir o banco com Docker
2️⃣ Executar a aplicação Spring Boot
3️⃣ Acessar:

http://localhost:8080
🧠 Tecnologias Utilizadas

Java

Spring Boot

Spring Data JPA

Hibernate

PostgreSQL

Docker

👨‍💻 Autor

Gustavo Araujo Pires

Projeto desenvolvido para prática e consolidação de conhecimentos em backend com Java.
