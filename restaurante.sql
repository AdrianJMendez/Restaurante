use restaurante;

create table platillo
(
platilloid int AUTO_INCREMENT PRIMARY KEY,
precio decimal (10,2),
nombre varchar(100)
);

create table inventario
(
invetarioid int AUTO_INCREMENT PRIMARY KEY,
nombre varchar (30),
preciocompra decimal (20,2),
cantidad decimal (12,2),
unidadmetrica varchar(20)
);

create TABLE ingredientes 
(
	inventarioid int,
    platilloid int,
    cantidad decimal, 
    FOREIGN KEY (inventarioid) REFERENCES inventario(invetarioid),
    FOREIGN KEY (platilloid) REFERENCES platillo(platilloid),
    PRIMARY KEY (inventarioid,platilloid)
);

CREATE TABLE ofertas 
(
	ofertaid int AUTO_INCREMENT PRIMARY KEY,
    platilloid int,
    descuento double (3,2),
    FOREIGN KEY (platilloid) REFERENCES platillo(platilloid)
);

create table oredenesdecompra
(
ordencompraid int AUTO_INCREMENT PRIMARY KEY,
    inventarioid int,
    cantidad decimal (12,2),
    preciototal decimal (12,2),
    FOREIGN KEY (inventarioid) REFERENCES inventario(invetarioid)

);

create TABLE mesa
(
mesaid int  PRIMARY KEY,
cantidaddesillasreservadas int
);

CREATE TABLE cateogriapermiso
(
    categoriapermisoid int PRIMARY KEY,
    nombre varchar(30),
    descripcion varchar (100)
);

CREATE TABLE cliente 
(
	clienteid int AUTO_INCREMENT PRIMARY KEY  NOT NULL,
    nombre varchar (30),
    apellido varchar (25),
    IDENTIFICACION varchar(13)
);

create table usuario 
(
	usuarioid int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    user varchar(20) NOT NULL,
    contrasena varchar(20) NOT NULL,
    categoriapermiso int NOT NULL,
    FOREIGN KEY (categoriapermiso) REFERENCES cateogriapermiso(categoriapermisoid)
);

CREATE TABLE reserva
(
	reservaid int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    clienteid int NOT NULL,
    fecha timestamp,
    cantidaddepersonas int ,
    usuarioid int NOT NULL,
    descripcion varchar(50),
     FOREIGN KEY (usuarioid) REFERENCES usuario(usuarioid),
     FOREIGN KEY (clienteid) REFERENCES cliente(clienteid)
    
);

CREATE TABLE transaccionalreserva 
(
    reservaid int,
    mesaid int,
    FOREIGN KEY (reservaid) REFERENCES reserva(reservaid),
    FOREIGN KEY (mesaid) REFERENCES mesa(mesaid),
    PRIMARY KEY (reservaid,mesaid)
    
);

CREATE TABLE factura 
(
	facturaid int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    usuarioid int,
    clienteid int,
    ofertaid int, 
    fecha timestamp,
    metododepago varchar (30),
    impuesto double(12,2),
    total double (12,2),
    
    FOREIGN KEY (usuarioid) REFERENCES usuario(usuarioid),
     FOREIGN KEY (clienteid) REFERENCES cliente(clienteid),
    FOREIGN KEY (ofertaid) REFERENCES ofertas(ofertaid)
    
);

create table transaccionalfactura
(
    facturaid int,
    platilloid int,
    cantidad int,
    preciototal double (12,2) ,
    FOREIGN KEY (facturaid) REFERENCES factura(facturaid),
     FOREIGN KEY (platilloid) REFERENCES platillo(platilloid),
         
    PRIMARY KEY (facturaid, platilloid)
);
