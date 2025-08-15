# 📝 API de Lista de Tarefas (To-Do List)

Uma API REST simples desenvolvida com **Spring Boot** para gerenciar tarefas (To-Do List).  
Este projeto foi criado como exercício de aprendizado, abordando **operações CRUD**, **DTOs** e **Spring Data JPA** com banco de dados **PostgresDb**.

---

## 📌 Funcionalidades

- Criar, listar, atualizar e excluir tarefas
- Uso de DTOs para entrada e saída de dados da API
- Banco de dados Postgres
- Docker Compose para rodar com container de banco de dados
- Endpoints REST seguindo boas práticas

---
## 📡 Endpoints da API

| Método | Endpoint        | Descrição                  |
|--------|----------------|----------------------------|
| POST   | `/tarefas`     | Criar uma nova tarefa      |
| GET    | `/tarefas`     | Listar todas as tarefas    |
| GET    | `/tarefas/{id}`| Buscar tarefa pelo ID      |
| PUT    | `/tarefas/{id}`| Atualizar tarefa           |
| DELETE | `/tarefas/{id}`| Excluir tarefa             |

---

## 🧪 Exemplo de Requisição

**Criar Tarefa**
```http
POST /tarefas
Content-Type: application/json

{
  "title": "Estudar Spring Boot",
  "description": "Finalizar o desafio da API de tarefas",
  "dateTime": "2025-08-15"
}
```
---
### 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Docker & Docker Compose



