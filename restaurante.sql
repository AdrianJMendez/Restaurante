use restaurante;

create table platillo
(
platilloid int AUTO_INCREMENT PRIMARY KEY,
precio decimal (10,2),
nombre varchar(100),
imagen varchar(250)
);

create table inventario
(
inventarioid int AUTO_INCREMENT PRIMARY KEY,
nombre varchar (30),
preciocompra decimal (20,2),
cantidad decimal (12,2),
unidadmetrica varchar(20),
minimo_recompra int 
);

create TABLE inventario_platillo
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

create table oredenes_de_compra
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
sillas int,
ocupado TINYINT
);

CREATE TABLE categoria_permiso
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
    identificacion varchar(13)
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

CREATE TABLE reserva_mesa
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

create table factura_platillo
(
    facturaid int,
    platilloid int,
    cantidad int,
    preciototal double (12,2) ,
    FOREIGN KEY (facturaid) REFERENCES factura(facturaid),
     FOREIGN KEY (platilloid) REFERENCES platillo(platilloid),
    PRIMARY KEY (facturaid, platilloid)
);
