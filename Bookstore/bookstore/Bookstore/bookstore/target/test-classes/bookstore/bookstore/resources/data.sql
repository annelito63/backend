INSERT INTO category (name)
VALUES
('Sarjakuva'),
('Dekkari'),
('Dokumentti')

INSERT INTO book (title, author, publication_year, isbn, price, categoryid) 
VALUES 
('Mökkimaailma', 'Mari Marison', '1974', '2727', 12.90, 1),
('Puutarha', 'Minni Hiiri', '1970', '6545', 15.95, 1);

INSERT INTO application_user (username, password_hash, role) 
VALUES 
('user', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'USER'),
('admin', '$2a$10$cDZgyF4xaPMmmoRW3OVcmuf.8o2YSx8.M7CeRKqi.1PVw.t3E8uEC', 'ADMIN');