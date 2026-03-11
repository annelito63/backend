CREATE TABLE category(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
    
);



CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publication_year INT,
    isbn VARCHAR(15) NOT NULL,
    price INT,
	categoryid BIGINT REFERENCES category(id)
);




CREATE TABLE application_user (
    id BIGSERIAL PRIMARY KEY,
    role VARCHAR(100) NOT NULL,
    username VARCHAR(250) NOT NULL,
    password_hash VARCHAR(250) NOT NULL
);

