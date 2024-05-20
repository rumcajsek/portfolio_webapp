-- SELECT * FROM clients;

INSERT INTO client_user_role(name, description) VALUES ('ADMIN', 'Ma dostęp do wszystkiego');
INSERT INTO client_user_role(name, description) VALUES ('USER', 'Dostęp tylko do odczytu');

INSERT INTO clients(name, surname) VALUES ('Anna', 'Kowalska');
INSERT INTO clients(name, surname) VALUES ('Marta','Nowak');
INSERT INTO clients(name, surname) VALUES ('Anita', 'Kaczmarek');
--
-- -- pazurki, martanowak, kaczmarek
INSERT INTO client_login_data(email, password, client_data_id) VALUES ('ania.kowalska@gmail.com', '{argon2}$argon2i$v=19$m=20,t=2,p=1$bVlVb1YzaExjYTBxSHg1Zg$GbxBE2p5n/diunC9o4LT3N7XvfU', (SELECT cl.id FROM clients cl WHERE cl.name = 'Anna' and cl.surname = 'Kowalska'));
INSERT INTO client_login_data(email, password, client_data_id) VALUES ('martanowak@gmail.com', '{argon2}$argon2i$v=19$m=20,t=2,p=1$bVlVb1YzaExjYTBxSHg1Zg$HoHWuAsU7xW++bzcm+sWLmO3WQ0', (SELECT cl.id FROM clients cl WHERE cl.name = 'Marta' and cl.surname = 'Nowak'));
INSERT INTO client_login_data(email, password, client_data_id) VALUES ('anikacz@gmail.com', '{argon2}$argon2i$v=19$m=20,t=2,p=1$bVlVb1YzaExjYTBxSHg1Zg$n/PQvVv8Df/LlQweCNCqzCo83bI', (SELECT cl.id FROM clients cl WHERE cl.name = 'Anita' and cl.surname = 'Kaczmarek'));

INSERT INTO client_to_user_role(client_login_entity_set_id, user_role_set_id) VALUES ((SELECT cld.id FROM client_login_data cld WHERE cld.email='ania.kowalska@gmail.com'), (SELECT cur.id FROM client_user_role cur WHERE cur.name = 'ADMIN'));
INSERT INTO client_to_user_role(client_login_entity_set_id, user_role_set_id) VALUES ((SELECT cld.id FROM client_login_data cld WHERE cld.email='ania.kowalska@gmail.com'), (SELECT cur.id FROM client_user_role cur WHERE cur.name = 'USER'));
INSERT INTO client_to_user_role(client_login_entity_set_id, user_role_set_id) VALUES ((SELECT cld.id FROM client_login_data cld WHERE cld.email='martanowak@gmail.com'), (SELECT cur.id FROM client_user_role cur WHERE cur.name = 'USER'));
INSERT INTO client_to_user_role(client_login_entity_set_id, user_role_set_id) VALUES ((SELECT cld.id FROM client_login_data cld WHERE cld.email='anikacz@gmail.com'), (SELECT cur.id FROM client_user_role cur WHERE cur.name = 'USER'));

INSERT INTO services(name, description, cost, duration) VALUES ('Usluga1', 'opis 1', 100.0, 1.5);
INSERT INTO services(name, description, cost, duration) VALUES ('Usluga2', 'opis 2', 150.0, 2.5);
INSERT INTO services(name, description, cost, duration) VALUES ('Usluga3', 'opis 3', 125.0, 2.0);
INSERT INTO services(name, description, cost, duration) VALUES ('Usluga4', 'opis 4', 130.0, 3.0);
INSERT INTO services(name, description, cost, duration) VALUES ('Usluga5', 'opis 5', 175.0, 1.0);
