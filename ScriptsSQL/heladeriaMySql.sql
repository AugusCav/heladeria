CREATE TABLE Clientes (
  id_cliente int identity NOT NULL ,
  dni varchar(45),
  nombre varchar(45),
  apellido varchar(45),
  email varchar(45),
  telefono varchar(45),
  estado bit
  constraint pk_id_cliente PRIMARY KEY (id_cliente)
)

CREATE TABLE Usuarios (
  id_usuario int NOT NULL identity,
  nombre_completo varchar(45) DEFAULT NULL,
  usuario varchar(45) DEFAULT NULL,
  contraseña varchar(45) NOT NULL,
  estado bit NOT NULL,
  privilegio varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_usuario)
)

CREATE TABLE Insumos (
  id_insumo int NOT NULL identity,
  descripcion varchar(45) DEFAULT NULL,
  precio float DEFAULT NULL,
  estado bit DEFAULT NULL,
  PRIMARY KEY (id_insumo)
)

CREATE TABLE Proveedores (
  id_proveedor int NOT NULL identity,
  nombre varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  telefono varchar(45) DEFAULT NULL,
  estado bit DEFAULT NULL,
  PRIMARY KEY (id_proveedor)
)


CREATE TABLE Ordenes_Compra (
  id_orden int NOT NULL,
  fecha date DEFAULT NULL,
  id_proveedor int DEFAULT NULL,
  id_usuario int DEFAULT NULL,
  PRIMARY KEY (id_orden),
  CONSTRAINT id_proveedor FOREIGN KEY (id_proveedor) REFERENCES Proveedores (id_proveedor),
  CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES Usuarios (id_usuario)
) 

CREATE TABLE Detalles_Compra (
  id_detallesc int NOT NULL identity,
  id_orden int DEFAULT NULL,
  id_insumo int DEFAULT NULL,
  precio float DEFAULT NULL,
  cantidad int DEFAULT NULL,
  PRIMARY KEY (id_detallesc),
  CONSTRAINT id_ins FOREIGN KEY (id_insumo) REFERENCES Insumos (id_insumo),
  CONSTRAINT id_orden FOREIGN KEY (id_orden) REFERENCES Ordenes_Compra (id_orden)
)

CREATE TABLE Facturas (
  id_factura int NOT NULL,
  fecha date DEFAULT NULL,
  id_cliente int DEFAULT NULL,
  id_usuario int DEFAULT NULL,
  PRIMARY KEY (id_factura),
  CONSTRAINT id_cliente FOREIGN KEY (id_cliente) REFERENCES Clientes (id_cliente),
  CONSTRAINT id_user FOREIGN KEY (id_usuario) REFERENCES Usuarios (id_usuario)
) 


CREATE TABLE Productos (
  id_producto int NOT NULL identity,
  nombre varchar(45) DEFAULT NULL,
  precio float DEFAULT NULL,
  estado bit DEFAULT NULL,
  PRIMARY KEY (id_producto)
)


CREATE TABLE Detalles_Factura (
  id_detallesf int NOT NULL identity,
  id_factura int DEFAULT NULL,
  id_producto int DEFAULT NULL,
  precio float DEFAULT NULL,
  cantidad int DEFAULT NULL,
  PRIMARY KEY (id_detallesf),
  CONSTRAINT id_fact FOREIGN KEY (id_factura) REFERENCES Facturas (id_factura),
  CONSTRAINT id_product FOREIGN KEY (id_producto) REFERENCES Productos (id_producto)
)