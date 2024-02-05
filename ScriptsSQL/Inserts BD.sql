insert into Clientes (dni, nombre, apellido, email, telefono, estado)
	VALUES ('41333545', 'Raul', 'García', 'raulg@email.com', '3581151515', 1),
		('42337515', 'Jorge', 'Perez', 'jorgito@email.com', '3515152232', 1),
		('40054181', 'Lionel', 'Messi', 'leomessi@email.com', '3515849554', 1),
		('39233212', 'Steve', 'Jobs', 'stevelaburos@email.com', '3585222474', 1),
		('41355555', 'Isabel II', 'del Reino Unido', 'reinaisabel@email.com', '3581252525', 1)

insert into Productos (nombre, precio, estado)
	VALUES ('Helado 1 bocha', 150, 1),
		('Helado 2 bocha', 200, 1),
		('Helado 3 bocha', 300, 1),
		('Helado 1/2 kg', 650, 1),
		('Helado 1 kg', 1200, 1)

insert into Usuarios (nombre_completo, usuario, contraseña, estado, privilegio)
	VALUES ('Jeff Bezos', 'cajero1', 'cajero123', 1, 'Cajero'),
		('Elon Musk', 'comprador1', 'comprador123', 1, 'Comprador'),
		('Charly Garcia', 'gerente', '1234', 1, 'Gerente')