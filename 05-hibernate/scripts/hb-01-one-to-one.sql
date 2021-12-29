-- DROP DATABASE IF EXISTS "hb_01_one_to_one";

CREATE DATABASE "hb_01_one_to_one"
    WITH
    OWNER = hbstudent
    ENCODING = "UTF8"
    lc_collate = "Portuguese_Brazil.1252"
    lc_ctype = "Portuguese_Brazil.1252"
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

DROP TABLE IF EXISTS instructor_detail;

CREATE TABLE instructor_detail (
    id serial,
    youtube_channel varchar(128),
    hobby varchar(45),
    CONSTRAINT pk_instructor_detail PRIMARY KEY (id)
);

DROP TABLE IF EXISTS instructor;

CREATE TABLE instructor (
  id serial,
  first_name varchar(45),
  last_name varchar(45),
  email varchar(45),
  instructor_detail_id int,
  CONSTRAINT pk_instructor PRIMARY KEY (id),
  CONSTRAINT fk_instructor_detail FOREIGN KEY (instructor_detail_id) REFERENCES instructor_detail (id)
);