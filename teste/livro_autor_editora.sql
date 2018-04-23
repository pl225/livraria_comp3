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

CREATE TABLE livraria.exemplar (
	ISBN VARCHAR(20) PRIMARY KEY REFERENCES livraria.livro(ISBN),
	precoUnitario real NOT NULL,
	qtdDisponivel int NOT NULL
);

CREATE TABLE livraria.bandeira (
	nome VARCHAR(20) PRIMARY KEY
);

CREATE TABLE livraria.cliente (
	CPF VARCHAR(14) PRIMARY KEY,
	nome VARCHAR(100) NOT NULL
);

CREATE TABLE livraria.telefone (
	CPF VARCHAR(14) REFERENCES livraria.cliente(CPF),
	numero VARCHAR(15) NOT NULL,
	PRIMARY KEY (CPF, numero)
);

CREATE TABLE livraria.endereco (
	CPF VARCHAR(14) PRIMARY KEY REFERENCES livraria.cliente(CPF),
	rua VARCHAR(100) NOT NULL,
	numero INT,
	bairro VARCHAR(100) NOT NULL,
	cidade VARCHAR(100) NOT NULL,
	CEP VARCHAR(100) NOT NULL
);

CREATE TABLE livraria.formaPagamento (
	ID int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
);

CREATE TABLE livraria.formaPagamentoDinheiro (
	ID INT PRIMARY KEY REFERENCES livraria.formaPagamento(ID),
	valorPago REAL NOT NULL
);

CREATE TABLE livraria.registroCompra (
	ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	total REAL NOT NULL,
	data TIMESTAMP NOT NULL,
	ISBN VARCHAR(20) NOT NULL REFERENCES livraria.livro(ISBN),
	IdFormaPagamento INT NOT NULL REFERENCES livraria.formaPagamento(ID)
);

CREATE TABLE livraria.registroCompraLivro (
	ID INT PRIMARY KEY REFERENCES livraria.registroCompra(ID),
	qtdExemplar INT NOT NULL
);

INSERT INTO livraria.formaPagamento VALUES (DEFAULT); 