# API de Gerenciamento de Cursos

Esta é uma API REST para uma Empresa de Cursos de Programação, desenvolvida com Java e Spring Boot.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.1**
- **Spring Data JPA**
- **H2 Database** (Banco de dados em memória)
- **Bean Validation** (Hibernate Validator)
- **Lombok**
- **Maven**

## 📂 Estrutura do Projeto

O projeto segue a arquitetura em camadas:
- `controller`: Porta de entrada da API, lida com as requisições HTTP.
- `service`: Camada de regras de negócio.
- `repository`: Comunicação com o banco de dados.
- `model`: Entidades da aplicação.
- `exception`: Tratamento customizado de erros.

## 🛠️ Como rodar o projeto

1. **Pré-requisitos:**
   - Java 21 instalado.
   - Maven 3.x instalado.

2. **Passos:**
   - Clone o repositório.
   - Na raiz do projeto, execute o comando:
     ```bash
     mvn spring-boot:run
     ```
   - A API estará disponível em `http://localhost:8080`.

## 🛣️ Rotas da API

### 1. Criar Curso
- **URL:** `POST /cursos`
- **Body:**
  ```json
  {
    "name": "Java Especialista",
    "category": "Backend",
    "professor": "Jules AI"
  }
  ```
- **Resposta:** `201 Created`

### 2. Listar Cursos (com filtros opcionais)
- **URL:** `GET /cursos`
- **Query Params:** `name`, `category` (Ex: `/cursos?name=Java&category=Backend`)
- **Resposta:** `200 OK`

### 3. Atualizar Curso
- **URL:** `PUT /cursos/{id}`
- **Body:** (O campo `active` será ignorado se enviado)
  ```json
  {
    "name": "Java Master",
    "category": "Backend",
    "professor": "Jules AI"
  }
  ```
- **Resposta:** `200 OK`

### 4. Remover Curso
- **URL:** `DELETE /cursos/{id}`
- **Resposta:** `204 No Content`

### 5. Alternar Status Ativo
- **URL:** `PATCH /cursos/{id}/active`
- **Resposta:** `200 OK` (Retorna o objeto atualizado com o novo status)

## ⚠️ Regras de Negócio
- Campos `name`, `category` e `professor` são obrigatórios.
- A data de criação (`created_at`) e atualização (`updated_at`) são geradas automaticamente.
- O ID é um UUID gerado automaticamente.
- O campo `active` começa como `true` por padrão e só pode ser alterado via rota `PATCH`.
