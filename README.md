📚 Literalura








Aplicação Java Back-end desenvolvida com Spring Boot que consome a API pública Gutendex para buscar informações de livros e armazená-las em um banco de dados PostgreSQL.

O sistema permite pesquisar livros por título, registrar autores e livros no banco de dados e realizar diferentes consultas utilizando Spring Data JPA.

Este projeto foi desenvolvido como parte do Challenge Literalura do programa Oracle Next Education (ONE) + Alura.

🚀 Funcionalidades

A aplicação possui as seguintes funcionalidades:

🔎 Buscar livro pelo título

Consulta a API Gutendex e salva o livro encontrado no banco de dados.

📚 Listar livros registrados

Mostra todos os livros armazenados no banco de dados.

👨‍💼 Listar autores

Exibe todos os autores cadastrados.

🕰️ Listar autores vivos em determinado ano

Permite buscar autores que estavam vivos em um ano específico.

🌎 Listar livros por idioma

Filtra livros armazenados por idioma.

Idiomas disponíveis:

🇪🇸 Espanhol
🇺🇸 Inglês
🇫🇷 Francês
🇧🇷 Português

🛠️ Tecnologias Utilizadas

Este projeto foi desenvolvido utilizando as seguintes tecnologias:

Backend

Java 17+

Spring Boot

Spring Data JPA

Hibernate

Banco de dados

PostgreSQL

Build e dependências

Maven

API externa

Gutendex API

https://gutendex.com/

🏗️ Arquitetura do Projeto

O projeto foi organizado seguindo uma estrutura comum em aplicações Spring Boot.

literalura
│
├── src
│ └── main
│ ├── java
│ │ └── com.ronaldo.literalura
│ │
│ │ ├── model
│ │ │ ├── Autor.java
│ │ │ ├── Livro.java
│ │ │ ├── DadosLivro.java
│ │ │ └── ResultadoBusca.java
│ │ │
│ │ ├── repository
│ │ │ ├── AutorRepository.java
│ │ │ └── LivroRepository.java
│ │ │
│ │ ├── service
│ │ │ ├── ConsumoApi.java
│ │ │ └── ConverteDados.java
│ │ │
│ │ ├── principal
│ │ │ └── Principal.java
│ │ │
│ │ └── LiteraluraApplication.java
│ │
│ └── resources
│ └── application.properties
│
└── pom.xml

🗄️ Banco de Dados

O projeto utiliza PostgreSQL para persistência de dados.

Tabela Autor

Campo | Tipo
id | Long
nome | String
ano_nascimento | Integer
ano_falecimento | Integer

Tabela Livro

Campo | Tipo
id | Long
titulo | String
idioma | String
downloads | Integer
autor_id | Foreign Key

Relacionamento:

Autor 1 ---- N Livro

⚙️ Configuração do Projeto
1️⃣ Criar banco no PostgreSQL

Abra o PostgreSQL:

psql -U postgres

Crie o banco:

CREATE DATABASE literalura;

2️⃣ Configurar application.properties

Arquivo:

src/main/resources/application.properties

Exemplo:

spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=postgres
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.format-sql=true

▶️ Como Executar o Projeto
1️⃣ Clonar o repositório

git clone https://github.com/SEU_USUARIO/literalura.git

2️⃣ Entrar na pasta

cd literalura

3️⃣ Rodar o projeto

Se estiver usando Maven:

./mvnw spring-boot:run

Ou execute diretamente pela IDE:

IntelliJ IDEA
Eclipse
VS Code

Executando a classe:

LiteraluraApplication

🧪 Exemplo de Execução

Menu inicial da aplicação:

Escolha uma opção:
1 - Buscar livro pelo título
2 - Listar livros registrados
3 - Listar autores
4 - Listar autores vivos em determinado ano
5 - Listar livros por idioma
0 - Sair

Exemplo de busca:

1
Digite o nome do livro:
Dom Casmurro

Resultado:

Livro salvo no banco!

🌐 API Utilizada

Este projeto utiliza a Gutendex API, uma API pública com informações de livros do Project Gutenberg.

Documentação:

https://gutendex.com/

Exemplo de requisição:

https://gutendex.com/books/?search=dom+casmurro

📈 Melhorias Futuras

Possíveis melhorias para o projeto:

Criar API REST

Implementar Docker

Criar interface web

Adicionar testes automatizados

Criar paginação de resultados

Melhorar tratamento de erros

👨‍💻 Autor

Ronaldo Ferreira

🎓 Estudante de Ciência da Computação
💻 Desenvolvedor Back-end em formação

GitHub:
https://github.com/RS-Ferreira

📄 Licença

Este projeto foi desenvolvido para fins educacionais no programa Oracle Next Education + Alura.
