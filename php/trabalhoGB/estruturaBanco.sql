CREATE DATABASE LocadoraAutomoveis;

USE LocadoraAutomoveis;

CREATE TABLE TipoUsuario(
idTipoUsuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
descricao VARCHAR(200)
);

CREATE TABLE Usuario(
idUsuario INT PRIMARY KEY NOT NULL,
idTipoUsuario INT NOT NULL,
nome VARCHAR(200),
login VARCHAR(200),
senha VARCHAR(200)
);

ALTER TABLE Usuario ADD CONSTRAINT FK_Usuario_idTipoUsuario
FOREIGN KEY (idTipoUsuario) REFERENCES TipoUsuario(idTipoUsuario);

CREATE TABLE Marca(
idMarca INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
nome VARCHAR(200)
);

CREATE TABLE Automovel(
idAutomovel INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idMarca INT NOT NULL,
placa VARCHAR(10),
valorAluguel DOUBLE
);

ALTER TABLE Automovel ADD CONSTRAINT FK_Automovel_idMarca
FOREIGN KEY (idMarca) REFERENCES Marca(idMarca);

CREATE TABLE Locacao(
idLocacao INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
idAutomovel INT NOT NULL,
idUsuario INT NOT NULL,
DataAlugado DATETIME,
DataDevolucao DATETIME
);

ALTER TABLE Locacao ADD CONSTRAINT FK_Locacao_idAutomovel
FOREIGN KEY (idAutomovel) REFERENCES Automovel(idAutomovel);

ALTER TABLE Locacao ADD CONSTRAINT FK_Locacao_idUsuario
FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario);
