CREATE TABLE livraria.cliente (
	cpf VARCHAR(11) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(50) NOT NULL,
	numero VARCHAR(20),
	bairro VARCHAR(50) NOT NULL,
	cidade VARCHAR(50) NOT NULL,
	celular VARCHAR(15) NOT NULL,
	tel_fixo VARCHAR(15)
);

DROP TABLE livraria.cliente;