-- DROP DATABASE IF EXISTS employee_directory;

CREATE DATABASE employee_directory
    WITH 
    OWNER = springstudent
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id serial,
  first_name varchar(45),
  last_name varchar(45),
  email varchar(45),
  CONSTRAINT pk_employee PRIMARY KEY (id)
);

INSERT INTO employee VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com'),
	(2,'Emma','Baumgarten','emma@luv2code.com'),
	(3,'Avani','Gupta','avani@luv2code.com'),
	(4,'Yuri','Petrov','yuri@luv2code.com'),
	(5,'Juan','Vega','juan@luv2code.com');
