create database Satira;

use Satira;


create table Producto(
    idProducto int primary key,
    nombre varchar(100),
    descripcion varchar(200),
    presentacion varchar(100),
    precio float,
    contenido varchar(10),
    ibu varchar(10),
    volumen varchar(10),
    marca varchar(50),
    stock int,
    idEstado int,
    procedencia varchar(25),
    idCategoria int,
    imagen longblob,
    foreign key (idCategoria) references Categoria (idCategoria),
    foreign key (idEstado) references Estado (idEstado)
);



create table Categoria(
    idCategoria int primary key,
    nombreCategoria varchar(100),
    descripcionCategoria varchar(120)
);


create table Estado(
	idEstado int primary key,
    nombre varchar(30),
    descripcion varchar(100)
);

create table Cliente(
	idCliente int primary key,
    nombre varchar(50),
    apellidos varchar(50),
    correo varchar(20),
    descripcion varchar(100),
	idProducto int,
    foreign key (idProducto) references Producto (idProducto)
);

create table Authorities(
	id int primary key,
    user_id int,
    authority varchar(45),
    foreign key (user_id) references Users (id)
);

create table Users(
	id int primary key,
    username varchar(45) unique,
    password varchar(60),
    enabled tinyint(1)
);


select * from Users

select * from authorities