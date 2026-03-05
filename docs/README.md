# 📌 Benefício System — Sistema Full‑Stack (Spring Boot + EJB + Angular)

## 🚀 Visão Geral

Este é um **projeto completo em camadas** que implementa um sistema de gerenciamento e transferência de benefícios usando:

- **Backend em Java com Spring Boot**
- **Serviço de negócio EJB (Enterprise JavaBeans)**
- **Frontend em Angular (SPA)**
- **Banco de dados H2 (em memória ou persistido)**
- **Arquitetura modular e bem organizada**
- **Documentação via Swagger/OpenAPI**

O objetivo é apresentar uma solução funcional, com arquitetura em camadas, integrado do frontend ao backend, com validação de regras de negócio no EJB e interface web consumindo APIs REST.

---

## 🗂️ Estrutura do Repositório
├── db/ # Scripts do banco de dados
│ ├── schema.sql # Criação de tabelas e constraints
│ └── seed.sql # Dados iniciais para testes
│
├── ejb‑module/ # Lógica de negócio em EJB
│ └── src/
│ └── BeneficioEjbService.java # Serviço de transferência com validações/locking
│
├── backend‑module/ # Backend Spring Boot
│ ├── src/main/java/ # Controllers, Services, Repositories, Entities
│ ├── src/main/resources/ # application.properties, Swagger config
│ └── src/test/java/ # Testes automatizados
│
├── frontend/ # Frontend Angular
│ ├── src/app/ # Componentes Angular, rotas e serviços HTTP
│ └── angular.json # Configuração do Angular CLI
│
├── docs/ # Documentação do projeto e critérios
│ └── architecture.md
|
├── .github/workflows/ # CI/CD pipelines (build, test, deploy)
│ └── build.yml
|
├── README.md # Este arquivo
└── pom.xml # POM raiz para multi‑módulos


---

## 🧠 Tecnologias Utilizadas

📦 **Backend & EJB**
- Java 17+
- Spring Boot 3.x
- JPA / Hibernate
- H2 Database (ou configuração externa)
- Swagger (springdoc‑openapi)

🌐 **Frontend**
- Angular (versão recente)
- RxJS
- HttpClient (serviço de API)
- Angular Router

⚙ **Build & Dev**
- Maven (multi‑modular)
- GitHub Actions para CI

---

## 🛠️ Como Configurar e Rodar o Projeto

### 1) Clonar o Repositório

```sh
git clone https://github.com/seu‑usuario/seu‑repositório.git
cd seu‑repositório
