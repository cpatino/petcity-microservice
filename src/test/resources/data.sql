DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS vaccine;

CREATE TABLE company (
  id int(11) NOT NULL AUTO_INCREMENT,
  document varchar(45) DEFAULT NULL,
  name varchar(100) NOT NULL,
  paid bit(1) NOT NULL DEFAULT '0',
  creation timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  enabled bit(1) NOT NULL DEFAULT '1',
  photo varchar(200) DEFAULT NULL,
  initialcustomid bigint(20) DEFAULT NULL,
  actualcustomid bigint(20) DEFAULT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  document varchar(10) NOT NULL,
  name varchar(50) NOT NULL,
  lastname varchar(50) NOT NULL,
  phone varchar(10) NOT NULL,
  email varchar(150) NOT NULL,
  password varchar(30) NOT NULL,
  idcompany int(11) NOT NULL,
  creation timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  enabled bit(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (id),
  CONSTRAINT fk_user_company FOREIGN KEY (idcompany) REFERENCES company (id)
);

CREATE TABLE vaccine (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  idcompany int(11) DEFAULT NULL,
  creation timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  enabled bit(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (id),
  CONSTRAINT fk_vaccine_company FOREIGN KEY (idcompany) REFERENCES company (id)
);


INSERT INTO company (id, document, name, paid, creation, enabled, photo, initialcustomid, actualcustomid) VALUES
(1, '123-456-789', 'veterinary1', '1', '2016-10-24 18:01:53', '1', 'photo', 10, 11);
INSERT INTO company (id, document, name, paid, creation, enabled, photo, initialcustomid, actualcustomid) VALUES
(2, '987-321-654', 'veterinary2', '1', '2017-10-24 18:01:53', '1', 'photo', 12, 13);
INSERT INTO company (id, document, name, paid, creation, enabled, photo, initialcustomid, actualcustomid) VALUES
(3, '456-423-123', 'veterinary3', '1', '2018-10-24 18:01:53', '1', 'photo', 14, 15);



INSERT INTO user (id, document, name, lastname, phone, email, password, idcompany, creation, enabled) VALUES
(1, '123456789', 'name', 'lastName', '987654321', 'test@test.test', 'password', 1, '2016-10-24 18:04:28', '1'),
(2, '987654321', 'name', 'lastName', '321654987', 'disabled@test.test', 'password', 1, '2016-10-24 18:04:28', '0');


INSERT INTO vaccine (id,name,idcompany,creation,enabled)
VALUES (1,'vaccine1',1,'2016-11-16 16:53:30','1');
INSERT INTO vaccine (id,name,idcompany,creation,enabled)
VALUES (2,'vaccine2',1,'2016-12-23 09:41:26','1');
INSERT INTO vaccine (id,name,idcompany,creation,enabled)
VALUES (3,'vaccine3',1,'2017-03-19 20:12:05','0');
INSERT INTO vaccine (id,name,idcompany,creation,enabled)
VALUES (4,'vaccine4',2,'2017-07-01 10:56:49','0');
INSERT INTO vaccine (id,name,idcompany,creation,enabled)
VALUES (5,'vaccine5',2,'2018-02-25 16:07:20','0');
