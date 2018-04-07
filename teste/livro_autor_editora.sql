CREATE TABLE livraria.editora (
	nome VARCHAR(60) PRIMARY KEY 
);

CREATE TABLE livraria.autor (
	nome VARCHAR(70) PRIMARY KEY
);

CREATE TABLE livraria.estilo (
	nome VARCHAR(25) PRIMARY KEY
);

CREATE TABLE livraria.livro (
  ISBN VARCHAR(20) PRIMARY KEY,
  nome_autor VARCHAR(70) NOT NULL,
  nome_editora VARCHAR(60) NOT NULL,
  nome_estilo VARCHAR(25) NOT NULL,
  titulo VARCHAR(100) NOT NULL,
  qtd_ideal_exemplar INT NOT NULL,
  CONSTRAINT fk_livro_editora FOREIGN KEY(nome_editora) REFERENCES livraria.editora(nome),
  CONSTRAINT fk_livro_autor FOREIGN KEY(nome_autor) REFERENCES livraria.autor(nome),
  CONSTRAINT fk_livro_estilo FOREIGN KEY(nome_estilo) REFERENCES livraria.estilo(nome)
);
