DROP DATABASE IF EXISTS socnetDB;

CREATE DATABASE IF NOT EXISTS socnetDB;

USE socnetDB;

CREATE TABLE socnetDB.profile
(
  profileID   LONG PRIMARY KEY NOT NULL AUTO_INCREMENT,
  firstName   VARCHAR(30),
  lastName    VARCHAR(30),
  birthDate   DATE,
  email       VARCHAR(30) UNIQUE,
  age         INT(30)                  DEFAULT NULL,
  sex         VARCHAR(30),
  city        VARCHAR(30),
  phoneNumber VARCHAR(30)
);

CREATE TABLE socnetDB.users
(
  userID    LONG PRIMARY KEY NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(30)     NOT NULL,
  lastName  VARCHAR(30)     NOT NULL,
  email     VARCHAR(30)     NOT NULL UNIQUE,
  login     VARCHAR(30)     NOT NULL UNIQUE,
  password  VARCHAR(30)     NOT NULL,
  profileID INT             NOT NULL,
  FOREIGN KEY (profileID) REFERENCES profile (profileID)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);






