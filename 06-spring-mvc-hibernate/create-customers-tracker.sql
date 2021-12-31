-- DROP ROLE IF EXISTS springstudent;

CREATE ROLE springstudent WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  REPLICATION
  ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:jOm9/X3T5EENkhN+cMrzIA==$xVuWtodSwk8Biynvp66Q3JedsRZxSSqqR6qKRWhQEbg=:mffM22naZYFyDrebPTwgRBYOKiExR9mMaCVtQ3XUAdI=';

-- DROP DATABASE IF EXISTS web_customer_tracker;

CREATE DATABASE web_customer_tracker
    WITH 
    OWNER = springstudent
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id serial,
    first_name varchar(45),
    last_name varchar(45),
    email varchar(45),
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

INSERT INTO customer VALUES
	(1,'David','Adams','david@luv2code.com'),
	(2,'John','Doe','john@luv2code.com'),
	(3,'Ajay','Rao','ajay@luv2code.com'),
	(4,'Mary','Public','mary@luv2code.com'),
	(5,'Maxwell','Dixon','max@luv2code.com');

ALTER SEQUENCE customer_id_seq RESTART WITH 5;