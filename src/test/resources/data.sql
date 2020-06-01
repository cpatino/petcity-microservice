DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS user;

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

INSERT INTO company (id, document, name, paid, creation, enabled, photo, initialcustomid, actualcustomid) VALUES
(1, '123-456-789', 'name', '1', '2016-10-24 18:01:53', '1', 'photo', 10, 11);


INSERT INTO user (id, document, name, lastname, phone, email, password, idcompany, creation, enabled) VALUES
(1, '123456789', 'name', 'lastName', '987654321', 'test@test.test', 'password', 1, '2016-10-24 18:04:28', '1'),
(2, '987654321', 'name', 'lastName', '321654987', 'disabled@test.test', 'password', 1, '2016-10-24 18:04:28', '0');