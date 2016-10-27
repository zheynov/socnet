DROP DATABASE IF EXISTS socnetDB;

CREATE DATABASE IF NOT EXISTS socnetDB;

USE socnetDB;

CREATE TABLE socnetDB.profile
(
  id   BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  firstname   VARCHAR(30),
  lastname    VARCHAR(30),
  birthDate   DATE,
  email       VARCHAR(30) UNIQUE,
  age         INT(30)                  DEFAULT NULL,
  sex         VARCHAR(30),
  city        VARCHAR(30),
  phoneNumber VARCHAR(30)
);

CREATE TABLE socnetDB.users
(
  id    BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  firstname VARCHAR(30)     NOT NULL,
  lastname  VARCHAR(30)     NOT NULL,
  email     VARCHAR(30)     NOT NULL UNIQUE,
  login     VARCHAR(30)     NOT NULL UNIQUE,
  password  VARCHAR(30)     NOT NULL,
  profileID BIGINT             NOT NULL,
  FOREIGN KEY (profileID) REFERENCES profile (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  login varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,login),
  KEY fk_username_idx (login),
  CONSTRAINT fk_username FOREIGN KEY (login) REFERENCES users (login)
);