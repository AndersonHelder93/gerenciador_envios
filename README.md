# 📦 Gerenciador de Envios de Pacotes

API REST para gerenciamento de produtos e controle de envios com código de rastreio único.

Projeto desenvolvido com foco em boas práticas de backend usando Spring Boot, incluindo arquitetura em camadas, tratamento global de exceções e documentação automática com Swagger.

---

## 🚀 Deploy

🔗 Swagger UI:
https://gerenciador-envios.onrender.com/swagger-ui/index.html

## 🛠️ Tecnologias

* Java 17
* Spring Boot 3.3
* Spring Web
* Spring Data JPA
* Bean Validation
* H2 Database
* Lombok
* OpenAPI / Swagger
* Maven
* Docker
* Render

---

## 🧱 Arquitetura

O projeto segue **arquitetura em camadas**:

```
controller → service → repository → entity → dto → exception
```

### Responsabilidades

* **Controller** → endpoints REST
* **Service** → regras de negócio
* **Repository** → persistência
* **DTOs** → contrato da API
* **Exception Handler** → tratamento global de erros

---

## ✅ Funcionalidades implementadas

* ✔️ CRUD de produtos
* ✔️ Criação de envios vinculados a produtos
* ✔️ Geração automática de código de rastreio (UUID)
* ✔️ Atualização de status do envio (PATCH)
* ✔️ Busca por código de rastreio
* ✔️ Tratamento global de exceções
* ✔️ Documentação interativa com Swagger

---

## 🔄 Fluxo de envio

### O envio pode transitar pelos seguintes status:

* EM_PREPARACAO

* EM_TRANSITO

* ENTREGUE

* CANCELADO

## ▶️ Como executar o projeto

### Pré-requisitos

* Java 17+
* Maven 3.9+

---

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/AndersonHelder93/gerenciador_envios.git
cd envios
```

---

### 2️⃣ Rodar a aplicação

```bash
mvn spring-boot:run
```

Aplicação disponível em:

```
http://localhost:8080
```

---

## 📖 Swagger (documentação da API)

Após subir a aplicação:

```
http://localhost:8080/swagger-ui/index.html
```

No Swagger você pode:

* testar endpoints
* visualizar contratos
* enviar requests
* validar respostas

---

## 🗄️ Banco de dados H2

Console disponível em:

```
http://localhost:8080/h2-console
```

**Configuração padrão:**

```
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (vazio)
```

---

## 📡 Endpoints principais

### 📦 Produtos

| Método | Endpoint    | Descrição         |
| ------ | ----------- | ----------------- |
| POST   | `/produtos` | Cadastrar produto |
| GET    | `/produtos` | Listar produtos   |

---

### 🚚 Envios

| Método | Endpoint                  | Descrição         |
| ------ | ------------------------- | ----------------- |
| POST   | `/envios`                 | Criar envio       |
| GET    | `/envios/{codigo}`        | Buscar por código |
| PATCH  | `/envios/{codigo}/status` | Atualizar status  |

---




## 👨‍💻 Autor

**Anderson Helder**

---

## 📄 Observação

Projeto desenvolvido para fins de estudo e avaliação técnica.
