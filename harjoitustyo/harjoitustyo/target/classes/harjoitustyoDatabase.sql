DROP TABLE IF EXISTS retki;
DROP TABLE IF EXISTS havainto;
DROP TABLE IF EXISTS application_user;

CREATE TABLE application_user (
    tekija_id BIGSERIAL PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    password_hash VARCHAR(250) NOT NULL,
    user_role VARCHAR(100) NOT NULL
);

INSERT INTO application_user (username, password_hash, user_role) 
VALUES 
('user', '$2a$10$pK4LUhr0vF2DRBnhhOz5T.b8NfGCz7dNXEM2OGGNKty.LgbyARoSe', 'ROLE_USER'),
('admin', '$2a$10$xRCtQvySKG8qgr5za9fqL.KA6S7a6.WslR.vfsfs.OQtC21G6VSFa', 'ROLE_ADMIN');

CREATE TABLE retki (
    retki_id BIGSERIAL PRIMARY KEY,
    nimi VARCHAR(100) NOT NULL,
    pvm VARCHAR(20) NOT NULL,
    kuvaus VARCHAR(500),
    tekija_id BIGINT REFERENCES application_user(tekija_id)

);

INSERT INTO retki (nimi, pvm, kuvaus, tekija_id) 
VALUES 
('Hanhiretki', '13.03.2026', 'Kaunista', 1),
('Kahlaajaretki', '05.02.2025', '', 2);


CREATE TABLE havainto (
    id BIGSERIAL PRIMARY KEY,
    nimi VARCHAR(100) NOT NULL,
    paikka VARCHAR(100) NOT NULL,
    retki_id BIGINT REFERENCES retki(retki_id)
);

INSERT INTO havainto (nimi, paikka, retki_id) 
VALUES 
('Kanadanhandi', 'Viikki', 1),
('Tundrahanhi', 'Viikki', 1),
('Tylli', 'Viikki', 2),
('Punajalkaviklo', 'Viikki', 2);



