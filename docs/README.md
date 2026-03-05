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

2) Banco de Dados

Os scripts estão em:

db/schema.sql
db/seed.sql

Você pode rodá‑los diretamente no console H2 ou com sua ferramenta preferida.
3) Backend (Spring Boot + EJB)
Rodar com Maven
cd backend‑module
mvn clean install
mvn spring‑boot:run

O backend será exposto em:
📍 http://localhost:8080

📍 Documentação Swagger:
→ http://localhost:8080/swagger‑ui.html
4) Frontend (Angular)
cd frontend
npm install
ng serve --open

O Angular será aberto em:
📍 http://localhost:4200

🧪 Testes
📍 Backend

Execute testes unitários e de integração:

mvn test
📄 Exemplos de Rotas REST
Método	Endpoint	Descrição
GET	/beneficios	Lista todos os benefícios
GET	/beneficios/{id}	Retorna benefício por ID
POST	/beneficios	Cria novo benefício
POST	/beneficios/transfer	Transfere valor entre benefícios
📌 Boas Práticas de Arquitetura

O projeto está organizado em camadas com responsabilidades bem definidas:

DB → Scripts e seed para testes e configuração local

EJB → Regras de negócio com validações e locking para evitar inconsistências

Backend → API REST, serviços, repositórios (camadas controller → service → repository)

Frontend → SPA Angular consumindo API backend

CI/CD → Integração contínua configurada no .github/workflows

📌 Critérios Avaliados (para o desafio)

✔ Arquitetura em camadas
✔ Correção do EJB com validações e optimistic locking
✔ CRUD completo + endpoint de transferência
✔ Qualidade de código e testes
✔ Documentação (Swagger + README)
✔ Frontend funcional conectado ao backend

👨‍💻 Recomendações

Se quiser evoluir este projeto:

✔ Adicione autenticação (JWT / OAuth)
✔ Construa testes end‑to‑end no frontend
✔ Dockerize a aplicação inteira (backend + frontend + BD)
✔ Adicione logging estruturado e métricas

🤝 Contribuições

Pull requests são bem‑vindos!
Caso encontre bugs ou queira sugerir melhorias, abra uma issue.

📝 Licença

Este projeto está sob a licença MIT — consulte o arquivo LICENSE para mais detalhes.
