CREATE DATABASE jj;
USE jj;
DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario(
    id  int NOT NULL AUTO_INCREMENT,
    nombre varchar(255),
    apellido varchar(255),
    telefono varchar(255),
    usuario varchar(255),
    clave varchar(255),
    PRIMARY KEY(id)
);
