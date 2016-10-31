DROP DATABASE IF EXISTS socnetDB;

CREATE DATABASE IF NOT EXISTS socnetDB;

USE socnetDB;

-- Table profile
CREATE TABLE profile
(
  id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  firstname   VARCHAR(30),
  lastname    VARCHAR(30),
  birthDate   DATE,
  email       VARCHAR(30) UNIQUE,
  age         INT(30)                     DEFAULT NULL,
  sex         VARCHAR(30),
  city        VARCHAR(30),
  phoneNumber VARCHAR(30)
);

-- Table users
CREATE TABLE users
(
  id        BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  email     VARCHAR(30)        NOT NULL UNIQUE,
  username  VARCHAR(30)        NOT NULL UNIQUE,
  password  VARCHAR(30)        NOT NULL,
  enabled   TINYINT            NOT NULL DEFAULT 1,
  profileID BIGINT             NOT NULL,
  FOREIGN KEY (profileID) REFERENCES profile (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

-- Table for mapping user and roles
CREATE TABLE user_roles (
  id       BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username VARCHAR(45)        NOT NULL,
  role     VARCHAR(45)        NOT NULL
);

-- Insert data
INSERT INTO profile VALUES (1, 'admin', 'admin', NULL, 'admin@admin.com', NULL, NULL, NULL, NULL);
INSERT INTO users VALUES (1, 'admin@admin.com', 'admin', '1234567', 1, 1);

INSERT INTO profile VALUES (2, 'Vadim', 'Zheynov', NULL, 'vadim@gmail.com', NULL, NULL, NULL, NULL);
INSERT INTO users VALUES (2, 'vadim@gmail.com', 'Vadim', '1234567', 1, 2);


INSERT INTO socnetDB.user_roles VALUES (NULL, 'admin', 'ROLE_ADMIN');
INSERT INTO socnetDB.user_roles VALUES (NULL, 'Vadim', 'ROLE_USER');