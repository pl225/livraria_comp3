INSERT INTO livraria.pesquisas (tipo_pesquisa, palavra_chave) VALUES (
	1,
	'Percy Jackson e o Ladrão de Raios'
)

INSERT INTO LIVRARIA.ESTILO (nome) VALUES ('Fantasia'), ('Drama'), ('Romance'), ('Suspense'), ('Infantil'), ('Terror');
INSERT INTO livraria.editora VALUES ('Saraiva'), ('Intríseca'), ('Rocco'), ('Arqueiro'), ('Leya'), ('Record'), ('Harper Collins'), ('Thomas Nelson Brasil'), ('Melhoramentos');
INSERT INTO livraria.autor VALUES ('Dan Brown'), ('Rick Riordar'), ('Lisa Genova'), ('George R. R. Martin'), ('Harlan Coben'), ('Agatha Christie'), ('James Patterson'), ('Cassandra Clare'), ('L. J. Smith'); 

INSERT INTO livraria.livro (ISBN, nome_autor, nome_editora, nome_estilo, titulo, qtd_ideal_exemplar) VALUES
	('584937276', 'Dan Brown', 'Arqueiro', 'Suspense', 'A Origem', 70),
	('644323222', 'Lisa Genova', 'Record', 'Drama', 'Para Sempre Alice', 25),
	('543236788', 'Rick Riordan', 'Intríseca', 'Fantasia', 'Percy Jackson e o Ladrão de Raios', 80),
	('543467888', 'Harlan Coben', 'Arqueiro', 'Suspense', 'Não Conte a Ninguém', 20);
	
INSERT INTO livraria.exemplar VALUES
	('584937276', 49.90, 30),
	('644323222', 17.00, 25),
	('543236788', 40.00, 40),
	('543467888', 10.00, 20);
	
SELECT l.isbn AS ISBN, l.titulo, l.nome_autor, l.nome_editora, l.nome_estilo,
		e.precoUnitario, e.qtdDisponivel
		FROM livraria.livro l
		INNER JOIN livraria.exemplar e ON e.ISBN = l.ISBN	

INSERT INTO livraria.bandeira VALUES ('Visa'), ('Elo'), ('MasterCard');

INSERT INTO livraria.cliente VALUES ('159813097-84', 'Matheus Abreu da Costa Corrêa'),
									('013224147-18', 'Raquel de Abreu da Costa');
									
INSERT INTO livraria.endereco VALUES ('159813097-84', 'Rua Lilian', 237, 'Amapá', 'Duque de Caxias', '25235-470'),
									 ('013224147-18', 'Rua Lilian', 237, 'Amapá', 'Duque de Caxias', '25235-470');
									 
INSERT INTO livraria.telefone VALUES ('159813097-84', '980018253'),
							         ('159813097-84', '975842709'),
							         ('013224147-18', '982289232');
							         
SELECT * FROM livraria.cliente c
	INNER JOIN livraria.endereco e on e.cpf = c.cpf
	INNER JOIN livraria.telefone t on t.cpf = c.cpf