# 📦 API de Clientes e Pedidos

API REST desenvolvida em Java utilizando Spring Boot para gerenciamento de clientes e pedidos.

Projeto desenvolvido com foco em boas práticas de desenvolvimento backend, arquitetura em camadas e aplicação de regras de negócio.

---

# 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- PostgreSQL
- Docker
- pgAdmin 4
- Lombok
- Maven

---

# 🎯 Objetivo do Projeto

Este projeto foi desenvolvido para praticar conceitos importantes no desenvolvimento backend profissional:

- Arquitetura em camadas
- Uso de DTOs
- Tratamento de exceções
- Aplicação de regras de negócio
- Persistência de dados com JPA
- Uso de containers com Docker
- Boas práticas de organização de código

---

# 🏗 Arquitetura do Projeto

O projeto segue o padrão **Arquitetura em Camadas**.

```
src/main/java

controller   → Recebe requisições HTTP
service      → Contém regras de negócio
repository   → Acesso ao banco de dados
model        → Entidades do sistema
dto          → Transferência de dados
exception    → Exceções personalizadas
handler      → Tratamento global de erros
```

Benefícios:

- Código organizado
- Facilidade de manutenção
- Separação de responsabilidades
- Escalabilidade

---

# 🗄 Modelagem do Sistema

### Cliente

| Campo | Tipo |
|------|------|
| id | UUID |
| nome | String |
| email | String |
| cpf | String |

### Pedido

| Campo | Tipo |
|------|------|
| id | UUID |
| nomePedido | String |
| dataPedido | LocalDate |
| valorTotal | BigDecimal |
| cliente | Cliente |

### Relacionamento

Cliente **1 → N** Pedido

Um cliente pode possuir vários pedidos.

---

# 🐳 Configuração do Banco com Docker

## Criar network

```bash
docker network create pedido-network
```

## Rodar PostgreSQL

```bash
docker run --name pedidosdb \
-p 5432:5432 \
-e POSTGRES_PASSWORD=postgres \
-e POSTGRES_USER=postgres \
-e POSTGRES_DB=Pedidos \
--network pedido-network \
-d postgres:16.3
```

## Rodar PgAdmin

```bash
docker run --name pgadmin4 \
-e PGADMIN_DEFAULT_EMAIL=pedidos@gmail.com \
-e PGADMIN_DEFAULT_PASSWORD=pedidos \
-p 15432:80 \
--network pedido-network \
-d dpage/pgadmin4:8.9
```

Acesso ao PgAdmin:

```
http://localhost:15432
```

Login:

```
Email: pedidos@gmail.com
Senha: pedidos
```

Configuração da conexão:

| Campo | Valor |
|------|------|
Host | pedidosdb
Port | 5432
Database | Pedidos
User | postgres
Password | postgres

---

# ▶ Executar a Aplicação

Para iniciar a aplicação:

```bash
mvn spring-boot:run
```

API disponível em:

```
http://localhost:8080
```

---

# 🔗 Endpoints da API

## Clientes

### Criar cliente

```
POST /clientes
```

```json
{
 "nome": "João Silva",
 "email": "joao@email.com",
 "cpf": "12345678900"
}
```

### Buscar cliente

```
GET /clientes/{id}
```

### Deletar cliente

```
DELETE /clientes/{cpf}
```

---

## Pedidos

### Criar pedido

```
POST /pedidos
```

```json
{
 "nomePedido": "Notebook",
 "dataPedido": "2026-03-11",
 "valorTotal": 2500,
 "clienteId": "uuid-do-cliente"
}
```

### Listar pedidos

```
GET /pedidos
```

### Buscar pedido

```
GET /pedidos/{id}
```

### Deletar pedido

```
DELETE /pedidos/{id}
```

---

# ⚙ Regras de Negócio

- Email de cliente deve ser único
- CPF de cliente deve ser único
- Valor do pedido deve ser maior que zero
- Pedido só pode ser criado se o cliente existir
- Tratamento de erros através de exceções personalizadas

---

# ⚠ Tratamento de Erros

Exemplo de resposta de erro:

```json
{
 "erro": "Cliente não encontrado"
}
```

---

# 📚 Boas Práticas Aplicadas

- Arquitetura em camadas
- Uso de DTOs
- Exceções customizadas
- Separação de responsabilidades
- Uso de UUID como identificador
- Regras de negócio na camada Service

---

# 👨‍💻 Autor

Desenvolvido por **Gustavo Araújo**

Projeto criado para prática de desenvolvimento backend com Java e Spring Boot.
