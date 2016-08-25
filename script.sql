drop database if exists dbzone;

create database dbzone;

use dbzone;

create table usuario(
	id int primary key auto_increment,
	nome varchar(25) not null,
	email varchar(50) unique not null
);

desc usuario;

select * from usuario;

