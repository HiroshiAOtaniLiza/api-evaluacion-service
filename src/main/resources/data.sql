INSERT INTO USUARIO(nombre, correo, contrasenia) VALUES('Juan Rodriguez','juan@rodriguez.org','$2a$10$2EHuOHkdXtden6uxz8EpauFoKeWc.CgnIsZdqWqHBtsYfBRShlHgy');

INSERT INTO phone(number, citycode, contrycode, correo) VALUES('1234567','1', '57', 'juan@rodriguez.org');
INSERT INTO phone(number, citycode, contrycode, correo) VALUES('1234568','2', '58', 'juan@rodriguez.org');

INSERT INTO format_password(id, format) values(1, '^[\w]*$');