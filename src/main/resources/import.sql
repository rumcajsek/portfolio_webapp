-- SELECT * FROM clients;

INSERT INTO client_user_role(id, name, description) VALUES (1, 'ADMIN', 'Ma dostęp do wszystkiego');
INSERT INTO client_user_role(id, name, description) VALUES (2, 'USER', 'Dostęp tylko do odczytu');

INSERT INTO clients(id, name, surname) VALUES (1, 'Anna', 'Kowalska');
INSERT INTO clients(id, name, surname) VALUES (2, 'Marta','Nowak');
INSERT INTO clients(id, name, surname) VALUES (3, 'Anita', 'Kaczmarek');

-- pazurki, martanowak, kaczmarek
INSERT INTO client_login_data(id, email, password, client_data_id) VALUES (1, 'ania.kowalska@gmail.com', '{argon2}$argon2i$v=19$m=20,t=2,p=1$bVlVb1YzaExjYTBxSHg1Zg$GbxBE2p5n/diunC9o4LT3N7XvfU', 1);
INSERT INTO client_login_data(id, email, password, client_data_id) VALUES (2, 'martanowak@gmail.com', '{argon2}$argon2i$v=19$m=20,t=2,p=1$bVlVb1YzaExjYTBxSHg1Zg$HoHWuAsU7xW++bzcm+sWLmO3WQ0', 2);
INSERT INTO client_login_data(id, email, password, client_data_id) VALUES (3, 'anikacz@gmail.com', '{argon2}$argon2i$v=19$m=20,t=2,p=1$bVlVb1YzaExjYTBxSHg1Zg$n/PQvVv8Df/LlQweCNCqzCo83bI', 3);

INSERT INTO client_to_user_role(client_entity_set_id, user_role_set_id) VALUES (1, 1);
INSERT INTO client_to_user_role(client_entity_set_id, user_role_set_id) VALUES (2, 2);
INSERT INTO client_to_user_role(client_entity_set_id, user_role_set_id) VALUES (3, 2);