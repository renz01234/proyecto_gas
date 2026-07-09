
--==================TABLA ROL=================================================
INSERT INTO ROL(nombre_rol) VALUES ('Administrador');
INSERT INTO ROL(nombre_rol) VALUES ('Repartidor');
INSERT INTO ROL(nombre_rol) VALUES ('Cliente');


--==================TABLA PRODUCTO=================================================
INSERT INTO PRODUCTO(nombre_marca, precio, tamaño) VALUES ('Solgas 10 Kg', 55.00, '10 Kg');
INSERT INTO PRODUCTO(nombre_marca, precio, tamaño) VALUES ('Llamagas 45 Kg', 180.00, '45 Kg');

--================== TABLA USUARIO ==========================================================

INSERT INTO USUARIO (cod_rol, nombre, apellido, email, password, activo) VALUES (1, 'Administrador', 'Sistema', 'admin@gas.com', '123456', TRUE), (2, 'Carlos', 'Perez', 'repartidor@gas.com', '123456', TRUE), (3, 'Juan', 'Lopez', 'cliente@gas.com', '123456', TRUE);


