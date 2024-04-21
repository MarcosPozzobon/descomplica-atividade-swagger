# DESCOMPLICA ATIVIDADE SWAGGER
*Este projeto foi construído a fim de realizar uma tarefa solicitada pelo professor do curso de Análise e Desenvolvimento de Sistemas da faculdade Uniamerica cujo objetivo era desenvolver uma API simples utilizando Spring Boot.* 


# O QUE FOI CRIADO?
* Criei uma API baseada na utilização de uma metodologia ágil. Basicamente se trata de uma aplicação onde o usuário pode criar um gerenciamento de tarefas e usuários utilizando Kanban.*
* é possível cadastrar, listar, buscar, filtrar, atualizar e deletar usuários.*
* é possível criar uma tarefa, atribuir ela a um responsável, listar tarefas e filtrar por descrição, título, estado da tarefa e ID da tarefa além de também poder mudar essa tarefa
para Backlog, Doing, Review e Done ("Backlog", "Em andamento", "Revisando", "Finalizado").*
* um usuário pode ter várias tarefas atribuídas a si mesmo*


# OBSERVAÇÕES
* Não foi implementada nenhuma prática de autenticação e autorização utilizando Spring Security e JWT nesta aplicação. Apenas um CRUD básico e a implementação do Swagger UI foram implementadas.
* Este projeto está disponível para visualização somente. Não foi solicitado para disponibilzar localmente a API para testes na máquina do usuário. Apenas visualização do código fonte e da estrutura do projeto.


# ESTRUTURA DAS TABELAS

*TABELA DE USUÁRIOS*
CREATE TABLE users (
	id SERIAL PRIMARY KEY,
	usuario VARCHAR (35) NOT NULL,
	senha VARCHAR (35) NOT NULL
);

*TABELA DE TAREFAS*
CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    estado VARCHAR(20) NOT NULL CHECK (estado IN ('Backlog', 'Doing', 'Review', 'Done')),
    responsavel_id INT,
	previsao_entrega DATE,
    data_criacao TIMESTAMP,
    data_ultima_atualizacao TIMESTAMP,
    FOREIGN KEY (responsavel_id) REFERENCES users(id)
);
