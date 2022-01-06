DROP DATABASE IF EXISTS spring_security_demo;

CREATE DATABASE spring_security_demo
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  enabled tinyint(1) NOT NULL,
  CONSTRAINT pk_users PRIMARY KEY (username)
);

INSERT INTO users VALUES 
('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1);

DROP TABLE IF EXISTS authorities;

CREATE TABLE authorities (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,
  CONSTRAINT uk_authorities UNIQUE KEY (username, authority),
  CONSTRAINT fk_authorities_username FOREIGN KEY 
  CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO authorities VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_ADMIN');


