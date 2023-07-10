INSERT INTO company (document, name, paid, creation, enabled, photo, initialcustomid, actualcustomid) VALUES
('123-456-789', 'veterinary1', '1', '2016-10-24 18:01:53', '1', 'photo', 10, 11),
('987-321-654', 'veterinary2', '1', '2017-10-24 18:01:53', '1', 'photo', 12, 13),
('456-423-123', 'veterinary3', '1', '2018-10-24 18:01:53', '1', 'photo', 14, 15);


INSERT INTO app_user (document, name, lastname, phone, email, password, idcompany, creation, enabled) VALUES
('123456789', 'name', 'lastName', '987654321', 'test@test.test', 'password', 1, '2016-10-24 18:04:28', '1'),
('987654321', 'name', 'lastName', '321654987', 'disabled@test.test', 'password', 1, '2016-10-24 18:04:28', '0');


INSERT INTO vaccine (name, idcompany, creation, enabled) VALUES
('vaccine1',1,'2016-11-16 16:53:30','1'),
('vaccine2',1,'2016-12-23 09:41:26','1'),
('vaccine3',1,'2017-03-19 20:12:05','0'),
('vaccine4',2,'2017-07-01 10:56:49','0'),
('vaccine5',2,'2018-02-25 16:07:20','0');
