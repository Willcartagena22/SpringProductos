INSERT INTO `usuarios` (username,password,enabled,name,email) VALUES('cwill','$2a$10$cUM9eqivczBBXrGtKpJV6.r6Tcile3bqDeg.NpoJYm6uPg0r5oV26',1,'Will Cartagena', 'calvarado@gmail.com');
INSERT INTO `usuarios` (username,password,enabled,name,email) VALUES('cwill2','$2a$10$OD8FMgzYIxx/h17k3GJXGu/1mYwVNNSv9HvWqO1SPXDrg4ole3bm6',1,'Will Cartagena2', 'calvarado2@gmail.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id,role_id) VALUES(1,1);
INSERT INTO `usuarios_roles` (usuario_id,role_id) VALUES(2,2);
INSERT INTO `usuarios_roles` (usuario_id,role_id) VALUES(2,1);