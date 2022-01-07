-- DROP DATABASE IF EXISTS "hb_mappings";

CREATE DATABASE "hb_mappings"
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

DROP TABLE IF EXISTS course;

CREATE TABLE course (
    id serial,
    title varchar(128) UNIQUE,
    instructor_id int,
    CONSTRAINT pk_course PRIMARY KEY (id),
    CONSTRAINT fk_instructor FOREIGN KEY (instructor_id) REFERENCES instructor (id)
);

DROP TABLE IF EXISTS review;

CREATE TABLE review (
    id serial,
    COMMENT varchar(255),
    course_id int,
    CONSTRAINT pk_review PRIMARY KEY (id),
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES course (id)
);

DROP TABLE IF EXISTS student;

CREATE TABLE student (
    id serial,
    first_name varchar(45),
    last_name varchar(45),
    email varchar(45),
    CONSTRAINT pk_student PRIMARY KEY (id)
);

DROP TABLE IF EXISTS course_student;

CREATE TABLE course_student (
    course_id int,
    student_id int,
    CONSTRAINT pk_course_student PRIMARY KEY (course_id, student_id),
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES course (id),
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student (id)
);