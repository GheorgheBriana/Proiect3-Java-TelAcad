-- USER table
CREATE TABLE IF NOT EXISTS USERS (
	id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- FLIGHT TABLE
CREATE TABLE IF NOT EXISTS FLIGHTS (
	id INT NOT NULL AUTO_INCREMENT,
    city VARCHAR(100),
    departure_date VARCHAR(100),
    arrival_date VARCHAR(100),
    airline VARCHAR(100),
    PRIMARY KEY (id)
);

-- RESERVATIONS TABLE
CREATE TABLE IF NOT EXISTS RESERVATIONS (
	id_user INT NOT NULL,
    id_zbor INT NOT NULL,
    number_of_childrens INT,
    number_of_adults INT
);

-- ADD VALUES
INSERT INTO FLIGHTS (city, departure_date, arrival_date, airline) 
VALUES ('Maldive', '2026-06-01', '2026-06-15', 'Emirates'),
       ('Paris', '2026-07-10', '2026-07-17', 'Air France');
