DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS application_user;

CREATE TABLE category(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
    
);

INSERT INTO category (name)
VALUES
('Sarjakuva'),
('Pokkari');


CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publication_year INT,
    isbn VARCHAR(15) NOT NULL,
    price INT,
	categoryid BIGINT REFERENCES category(id)
);

INSERT INTO book (title, author, publication_year, isbn, price, categoryid) 
VALUES 
('Aku Ankka', 'Carl B', '1962', '27291927', 12, 1),
('Mustakaapu', 'Floyd G', '1979', '654245', 14, 1);


CREATE TABLE application_user (
    id BIGSERIAL PRIMARY KEY,
    role VARCHAR(100) NOT NULL,
    username VARCHAR(250) NOT NULL,
    password_hash VARCHAR(250) NOT NULL
);

INSERT INTO application_user (username, password_hash, role) 
VALUES 
('user', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'USER'),
('admin', '$2a$10$cDZgyF4xaPMmmoRW3OVcmuf.8o2YSx8.M7CeRKqi.1PVw.t3E8uEC', 'ADMIN');