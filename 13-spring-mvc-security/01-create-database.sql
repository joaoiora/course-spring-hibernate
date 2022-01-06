DROP DATABASE IF EXISTS spring_security_demo;

CREATE DATABASE spring_security_demo
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

DROP TABLE IF EXISTS "user";

CREATE TABLE "user" (
  id serial,
  username varchar(50) NOT NULL,
  password varchar(80) NOT NULL,
  first_name varchar(50) not null,
  last_name varchar(50) not null,
  email varchar(50) not null,
  CONSTRAINT pk_users PRIMARY KEY (id)
);

INSERT INTO "user" (username, password, first_name, last_name, email) VALUES 
('john','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','John','Doe','john@luv2code.com'),
('mary','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Mary','Public','mary@luv2code.com'),
('susan','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Susan','Adams','susan@luv2code.com');

-- Passwords generated using https://www.bcryptcalculator.com/encode.
UPDATE "user" SET password = '{bcrypt}$2a$10$6TbQxaOUSaFxbxq1IP351OO2no1uSwU7k8Zi.l2Ox8zfMclF95Bk.' WHERE username = 'john';
UPDATE "user" SET password = '{bcrypt}$2a$10$/uQqT1S.Is1Mz8OHBjgXru5C7b2c0d5gsX6aCAvphMCxmNcadfT3e' WHERE username = 'mary';
UPDATE "user" SET password = '{bcrypt}$2a$10$oBraRqFg4ZBauofgBsM0H.rfVJepY.UZqwvxr4VPhGj8BVgVP9ymm' WHERE username = 'susan';

DROP TABLE IF EXISTS "role";

CREATE TABLE "role" (
  id serial,
  name varchar(50) NULL,
  CONSTRAINT pk_role PRIMARY KEY (id)
);

INSERT INTO "role" (name) VALUES 
('ROLE_EMPLOYEE'),
('ROLE_MANAGER'),
('ROLE_ADMIN');

DROP TABLE IF EXISTS users_roles;

CREATE TABLE users_roles (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  
  CONSTRAINT pk_user_role PRIMARY KEY (user_id, role_id),
  
  CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES "user" (id),
  CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES "role" (id)
);

INSERT INTO users_roles (user_id, role_id) VALUES 
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 3);