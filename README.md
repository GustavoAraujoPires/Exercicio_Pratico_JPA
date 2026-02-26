🚀 Sistema de Pedidos – API REST com Spring Boot + JPA + Docker

Bem-vindo ao projeto Sistema de Pedidos 👋

Uma API REST desenvolvida com Java + Spring Boot, utilizando Spring Data JPA para persistência e PostgreSQL rodando em container Docker.

O sistema permite o gerenciamento de:

👤 Clientes

📦 Pedidos

Aplicando relacionamento entre entidades e regras básicas de negócio.

📌 Sobre o Projeto

Este projeto foi desenvolvido com foco em prática real de backend, simulando uma estrutura comum em aplicações corporativas.

Ele envolve:

✔ Persistência com JPA
✔ Relacionamento entre tabelas
✔ Banco relacional
✔ Ambiente isolado com Docker
✔ Organização em camadas

🎯 Objetivos de Aprendizado

Durante o desenvolvimento foram praticados:

Criação de API REST com Spring Boot

Mapeamento de entidades com JPA

Relacionamento entre tabelas

Uso de UUID como identificador

Integração com PostgreSQL

Execução do banco via Docker

Arquitetura em camadas

🏗️ Estrutura do Projeto

A aplicação foi organizada seguindo o padrão:

Controller → Service → Repository → Database
🔹 Controller

Recebe e responde requisições HTTP.

🔹 Service

Contém as regras de negócio e validações.

🔹 Repository

Responsável pela comunicação com o banco via Spring Data JPA.

🔹 Model (Entity)

Representação das tabelas no banco.

Essa organização melhora a manutenção e separa responsabilidades.

🐳 Banco de Dados com Docker

O PostgreSQL foi executado via container Docker para simular um ambiente real de desenvolvimento.

🔧 Passos realizados

Criação de uma network Docker

Subida do container PostgreSQL

Configuração de usuário, senha e banco

Exposição da porta 5432

Configuração da conexão no application.yml

O Hibernate está configurado para criar/atualizar as tabelas automaticamente.

🐋 Comandos Docker Utilizados
Criar a network
docker network create pedido-network
Subir o PostgreSQL (versão 16.3)
docker run --name pedidosdb -p 5432:5432 \
-e POSTGRES_PASSWORD=postgres \
-e POSTGRES_USER=postgres \
-e POSTGRES_DB=Pedidos \
--network pedido-network \
postgres:16.3
Subir o PgAdmin 4
docker run --name pgadmin4 \
-e PGADMIN_DEFAULT_EMAIL=admin@gmail.com \
-e PGADMIN_DEFAULT_PASSWORD=admin \
-p 15432:80 \
--network pedido-network \
dpage/pgadmin4:8.9
🗂️ Modelagem

O sistema possui duas entidades principais:

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

Foi implementado:

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

✔ Não é possível criar pedido para cliente inexistente
✔ O valor do pedido deve ser maior que zero
✔ O email do cliente é único

🧠 Tecnologias Utilizadas

Java

Spring Boot

Spring Data JPA

Hibernate

PostgreSQL

Docker

🚀 Como Executar
1️⃣ Subir o banco via Docker

Utilize os comandos acima.

2️⃣ Executar a aplicação Spring Boot
3️⃣ Acessar a API em:
http://localhost:8080
👨‍💻 Autor

Gustavo Araujo Pires

Projeto desenvolvido para prática e consolidação de conhecimentos em backend com Java.
