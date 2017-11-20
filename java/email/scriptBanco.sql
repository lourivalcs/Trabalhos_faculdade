CREATE DATABASE Email;

USE Email;


CREATE TABLE Usuario(
	idUsuario BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	login VARCHAR(255) NOT NULL,
	senha VARCHAR(255) NOT NULL,
	nome VARCHAR(255) NOT NULL
);

INSERT INTO Usuario(login, senha, nome) VALUES ('lourival', 'senha', 'Lourival Costa da Silva');
INSERT INTO Usuario(login, senha, nome) VALUES ('teste 01', 'senha', 'Teste usuario 01');
INSERT INTO Usuario(login, senha, nome) VALUES ('teste 02', 'senha', 'Teste usuario 02');
INSERT INTO Usuario(login, senha, nome) VALUES ('teste 03', 'senha', 'Teste usuario 03');
INSERT INTO Usuario(login, senha, nome) VALUES ('teste 04', 'senha', 'Teste usuario 04');
INSERT INTO Usuario(login, senha, nome) VALUES ('teste 05', 'senha', 'Teste usuario 05');
INSERT INTO Usuario(login, senha, nome) VALUES ('teste 06', 'senha', 'Teste usuario 06');


CREATE TABLE Email(
	idEmail BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	assunto VARCHAR(255),
	texto VARCHAR(10000),
	dataEnvio DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
);


CREATE TABLE TipoEmailUsuario(
	idTipoEmailUsuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	descricao VARCHAR(100)
);


INSERT INTO TipoEmailUsuario (descricao) VALUES ('Remetente'),('Destinatário');

CREATE TABLE EmailUsuario(
	idEmailUsuario BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	idEmail BIGINT NOT NULL,
	idUsuario BIGINT NOT NULL,
	idTipoEmailUsuario INT NOT NULL,
	lido boolean
);

ALTER TABLE EmailUsuario ADD CONSTRAINT FK_EmailUsuario_idEmail
FOREIGN KEY (idEmail) REFERENCES Email(idEmail);

ALTER TABLE EmailUsuario ADD CONSTRAINT FK_EmailUsuario_idUsuario
FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario);

ALTER TABLE EmailUsuario ADD CONSTRAINT FK_EmailUsuario_idTipoEmailUsuario
FOREIGN KEY (idTipoEmailUsuario) REFERENCES TipoEmailUsuario(idTipoEmailUsuario);