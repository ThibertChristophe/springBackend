CREATE DATABASE db;

CREATE TABLE USER (
  ID integer primary key not null AUTO_INCREMENT,
  EMAIL varchar(50) UNIQUE
);

CREATE TABLE HOME (
  ID integer primary key not null AUTO_INCREMENT,
  NAME varchar(150),
  CITY varchar(100),
  STATE varchar(10),
  STREET varchar(150) UNIQUE,
  TYPE varchar(100),
  USER_ID integer,
  CONSTRAINT user_fk FOREIGN KEY (USER_ID) REFERENCES USER(ID)
);
