📦 API de Clientes e Pedidos

API REST desenvolvida em Java utilizando Spring Boot para gerenciamento de clientes e pedidos.

Este projeto foi desenvolvido com o objetivo de praticar boas práticas de desenvolvimento backend, incluindo:

Arquitetura em camadas

Uso de DTOs

Tratamento de exceções

Regras de negócio na camada de serviço

Persistência de dados com Spring Data JPA

Banco de dados em container utilizando Docker

🚀 Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Data JPA

Hibernate ORM

PostgreSQL

Docker

pgAdmin 4

Lombok

Maven

📁 Estrutura do Projeto

O projeto segue uma arquitetura em camadas para manter o código organizado e de fácil manutenção.

src/main/java
│
├── controller      → Recebe as requisições HTTP
├── service         → Contém as regras de negócio
├── repository      → Acesso ao banco de dados
├── model           → Entidades do sistema
├── dto             → Objetos de transferência de dados
├── exception       → Exceções personalizadas
└── handler         → Tratamento global de exceções

Essa separação melhora:

manutenção do código

organização do projeto

escalabilidade da aplicação

🧠 Modelagem do Sistema

O sistema possui duas entidades principais:

Cliente

id

nome

email

cpf

Pedido

id

nomePedido

dataPedido

valorTotal

cliente

Relacionamento
Cliente 1 → N Pedido

Um cliente pode possuir vários pedidos.

🌐 Endpoints da API
Clientes
Criar cliente

POST

/clientes

Exemplo de requisição:

{
  "nome": "João Silva",
  "email": "joao@email.com",
  "cpf": "12345678900"
}
Buscar cliente por ID

GET

/clientes/{id}
Deletar cliente

DELETE

/clientes/{cpf}
Pedidos
Criar pedido

POST

/pedidos

Exemplo:

{
  "nomePedido": "Notebook",
  "dataPedido": "2026-03-11",
  "valorTotal": 2500,
  "clienteId": "uuid-do-cliente"
}
Listar pedidos

GET

/pedidos
Buscar pedido por ID

GET

/pedidos/{id}
Deletar pedido

DELETE

/pedidos/{id}
🧩 Regras de Negócio

O sistema possui algumas validações importantes:

Não é permitido cadastrar cliente com email já existente

Não é permitido cadastrar cliente com CPF duplicado

O valor do pedido deve ser maior que zero

Um pedido só pode ser criado se o cliente existir

Exceções personalizadas são utilizadas para retornar erros claros

⚠️ Tratamento de Erros

A aplicação utiliza um Global Exception Handler para tratar erros e retornar respostas padronizadas.

Exemplo de resposta de erro:

{
  "erro": "Cliente não encontrado"
}
📚 Boas Práticas Utilizadas

Arquitetura em camadas

DTO para entrada de dados

Exceptions customizadas

Separação de responsabilidades

Uso de UUID como identificador

Regras de negócio na camada Service

## 🚀 Como Executar

### 1. Subir o banco PostgreSQL via Docker

```bash
# Criar uma network (opcional, mas recomendado)
docker network create pedido-network

# Rodar container PostgreSQL na versão 16.3
docker run --name pedidosdb \
  -p 5432:5432 \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_DB=Pedidos \
  --network pedido-network \
  -d postgres:16.3

# (Opcional) Rodar PgAdmin 4
docker run --name pgadmin4 \
  -e PGADMIN_DEFAULT_EMAIL=admin@gmail.com \
  -e PGADMIN_DEFAULT_PASSWORD=admin \
  -p 15432:80 \
  --network pedido-network \
  -d dpage/pgadmin4:8.9

👨‍💻 Autor
Gustavo Araujo Pires
Projeto desenvolvido para prática e consolidação de conhecimentos em backend com Java
