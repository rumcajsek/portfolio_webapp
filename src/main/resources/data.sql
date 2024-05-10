-- SELECT * FROM clients;
-- pazurki, martanowak, kaczmarek
-- INSERT INTO client_login_data(email, password) VALUES ('ania.kowalska@gmail.com', '{argon2}$argon2i$v=19$m=20,t=2,p=1$bVlVb1YzaExjYTBxSHg1Zg$GbxBE2p5n/diunC9o4LT3N7XvfU');
-- INSERT INTO client_login_data(email, password) VALUES ('martanowak@gmail.com', '{argon2}$argon2i$v=19$m=20,t=2,p=1$bVlVb1YzaExjYTBxSHg1Zg$HoHWuAsU7xW++bzcm+sWLmO3WQ0');
-- INSERT INTO client_login_data(email, password) VALUES ('anikacz@gmail.com', '{argon2}$argon2i$v=19$m=20,t=2,p=1$bVlVb1YzaExjYTBxSHg1Zg$n/PQvVv8Df/LlQweCNCqzCo83bI');

INSERT INTO client_user_role(id, name, description) VALUES (1, 'ADMIN', 'Ma dostęp do wszystkiego');
INSERT INTO client_user_role(id, name, description) VALUES (2, 'USER', 'Dostęp tylko do odczytu');

-- INSERT INTO client_to_user_role(client_entity_set_id, user_role_set_id) VALUES (1, 1);
-- INSERT INTO client_to_user_role(client_entity_set_id, user_role_set_id) VALUES (2, 2);
-- INSERT INTO client_to_user_role(client_entity_set_id, user_role_set_id) VALUES (3, 2);

-- INSERT INTO clients(name, surname) VALUES ('Anna', 'Kowalska', 1);
-- INSERT INTO clients(name, surname) VALUES ('Marta','Nowak', 2);
-- INSERT INTO clients(name, surname) VALUES ('Anita', 'Kaczmarek', 3);

--INSERT INTO client_login_data(id,email, password) VALUES (1,'ania.kowalska@gmail.com', '{argon2}$argon2i$v=19$m=20,t=2,p=1$bVlVb1YzaExjYTBxSHg1Zg$GbxBE2p5n/diunC9o4LT3N7XvfU');
--INSERT INTO client_login_data(id,email, password) VALUES (2,'martanowak@gmail.com', '{argon2}$argon2i$v=19$m=20,t=2,p=1$bVlVb1YzaExjYTBxSHg1Zg$HoHWuAsU7xW++bzcm+sWLmO3WQ0');
--INSERT INTO client_login_data(id,email, password) VALUES (3,'anikacz@gmail.com', '{argon2}$argon2i$v=19$m=20,t=2,p=1$bVlVb1YzaExjYTBxSHg1Zg$n/PQvVv8Df/LlQweCNCqzCo83bI');
--
--INSERT INTO client_user_role(id,name, description) VALUES (1,'ADMIN', 'Ma dostęp do wszystkiego');
--INSERT INTO client_user_role(id,name, description) VALUES (2,'USER', 'Dostęp tylko do odczytu');
--
--INSERT INTO client_to_user_role(client_entity_set_id, user_role_set_id) VALUES (1, 1);
--INSERT INTO client_to_user_role(client_entity_set_id, user_role_set_id) VALUES (2, 2);
--INSERT INTO client_to_user_role(client_entity_set_id, user_role_set_id) VALUES (3, 2);
--
--INSERT INTO clients(id, name, surname, login_data_id) VALUES (1,'Anna', 'Kowalska', 1);
--INSERT INTO clients(id, name, surname, login_data_id) VALUES (2,'Marta','Nowak', 2);
--INSERT INTO clients(id, name, surname, login_data_id) VALUES (3,'Anita', 'Kaczmarek', 3);