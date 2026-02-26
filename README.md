# Sistema de Pedidos - Spring Boot + JPA + PostgreSQL + Docker

API REST simples de gerenciamento de clientes e pedidos, desenvolvida como exercício para praticar:

- Relacionamentos bidirecionais JPA (@OneToMany / @ManyToOne)
- FetchType.LAZY e evitar LazyInitializationException
- Validações básicas de negócio
- Uso de UUID como identificador primário
- Integração com PostgreSQL via Docker
- Tratamento de exceções personalizadas

## 🎯 Objetivos do Exercício

- Modelar relacionamento Cliente ↔ Pedido (bidirecional, lazy)
- Implementar CRUD básico de clientes e pedidos
- Garantir regras de negócio (email único, pedido > 0, cliente existente)
- Configurar ambiente 100% Dockerizado
- Exibir log SQL no console
- Tratar 404 de forma adequada

## Tecnologias Utilizadas

| Tecnologia            | Versão / Propósito                          |
|-----------------------|---------------------------------------------|
| Java                  | 17 ou 21                                    |
| Spring Boot           | 3.x                                         |
| Spring Data JPA       | Hibernate como provedor                     |
| PostgreSQL            | 15 / 16 (via Docker)                        |
| Docker                | Containerização do banco                    |
| Maven                 | Gerenciamento de dependências               |
| Lombok                | Reduzir boilerplate                         |
| UUID                  | Identificador primário das entidades        |

